package com.vapasi.justcinemas.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CommonControllerTest {

    CommonController commonController = new CommonController();
    @Test
    public void testGetTermsReturnTerms() {
        assertEquals("terms", commonController.getTerms());
    }
    @Test
    public void testGetAboutReturnAboutUs() {
        assertEquals("about_us", commonController.getAbout());
    }

}
