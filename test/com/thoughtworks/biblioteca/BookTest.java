package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;

public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        book = new Book("Title 1", "Author 1", 1);
    }

    @Test
    public void shouldReturnTitle() {
        assertEquals("Title 1", book.getTitle());
    }

    @Test
    public void shouldReturnAuthor() {
        assertEquals("Author 1", book.getAuthor());
    }

    @Test
    public void shouldReturnYear() {
        assertEquals(1, book.getYear());
    }
}