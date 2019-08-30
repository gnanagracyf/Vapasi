package com.vapasi.justcinemas.controller;
import com.vapasi.justcinemas.model.Movie;
import com.vapasi.justcinemas.model.User;
import com.vapasi.justcinemas.service.MovieDetailsService;
import com.vapasi.justcinemas.service.UserValidation;
import com.vapasi.justcinemas.service.UserValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;
import static org.junit.Assert.assertEquals;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MovieControllerTest {

    @Mock
    MovieDetailsService movieDetailsServiceMock;
    @Mock
    Model modelMock;
    @Mock
    HttpSession sessionMock;
    @InjectMocks
    MovieController movieController;
    @Test
    public void testGetMoviesReturnMovieWithModelAttributeMovie() {
        List<Movie> moviesList=new ArrayList<>();
        createMovieList(moviesList);
        when(movieDetailsServiceMock.getMovieDetails()).thenReturn(moviesList);
        assertEquals("movie", movieController.getHome(modelMock));
        verify(movieDetailsServiceMock).getMovieDetails();
        verify(modelMock).addAttribute(eq("movies"), eq(moviesList));
    }

    private void createMovieList(List<Movie> movieList) {
        Movie movie1 = new Movie();
        movie1.setMovieName("Kabali");
        movie1.setSoundTrack("Dolby Digital");
        movieList.add(movie1);
        Movie movie2 = new Movie();
        movie2.setMovieName("Kennedy Clud");
        movie2.setSoundTrack("Sony Dynamic Digital");
        movieList.add(movie2);
        Movie movie3 = new Movie();
        movie3.setMovieName("Alladin");
        movie3.setSoundTrack("Sony Dynamic Digital");
        movieList.add(movie3);
    }
}