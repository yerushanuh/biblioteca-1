package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by ynuh on 8/10/15.
 */
public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("Title", "Director", "Year", "Rating");
    }

    @Test
    public void shouldReturnMovieDetailsAsString() {
        assertEquals(movie.getDetailsAsString(), String.format("%-30.30s | %-30.30s | %-4.4s | %-30.30s", "Title", "Director", "Year", "Rating"));
    }

    @Test
    public void shouldBecomeUnavailableWhenMovieIsCheckedOut() {
        movie.checkOut();
        assertFalse(movie.isAvailable());
    }

    @Test
    public void shouldReturnTrueWhenBookHasTitle() {
        assertTrue(movie.hasTitle("Title"));
    }

}