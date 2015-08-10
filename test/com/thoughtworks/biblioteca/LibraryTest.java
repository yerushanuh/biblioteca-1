package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;


public class LibraryTest {

    private PrintStream printStream;
    private Library library;
    private List<Book> bookList;
    private Book harryPotter;
    private BufferedReader bufferedReader;
    private Movie defaultMovie;
    private List<Movie> movieList;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bookList = new ArrayList<>();
        movieList = new ArrayList<>();
        bufferedReader = mock(BufferedReader.class);
        library = new Library(bookList, movieList);
        harryPotter = mock(Book.class);
        defaultMovie = mock(Movie.class);
    }

    @Test
    public void shouldListExistingBooksInLibrary(){
        bookList.add(harryPotter);
        when(harryPotter.getDetailsAsString()).thenReturn("some string");
        when(harryPotter.isAvailable()).thenReturn(true);
        assertEquals(library.listBooks(), ("some string\n"));
    }

    @Test
    public void shouldListExistingMoviesInLibrary() {
        movieList.add(defaultMovie);
        when(defaultMovie.getDetailsAsString()).thenReturn("some string");
        when(defaultMovie.isAvailable()).thenReturn(true);
        assertEquals(library.listMovies(), ("some string\n"));
    }

    @Test
    public void shouldListNothingWhenNoBooksInLibrary(){
        library.listBooks();
        assertEquals(library.listBooks(), (""));
    }

    @Test
    public void shouldNotReturnMovieDetailsWhenNotAvailable() {
        movieList.add(defaultMovie);
        when(defaultMovie.isAvailable()).thenReturn(false);
        library.listMovies();
        verify(defaultMovie, never()).getDetailsAsString();
    }

    @Test
    public void shouldNotIncludeBookInBookListWhenBookIsNotAvailable() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(false);
        when(harryPotter.getDetailsAsString()).thenReturn("some string");
        assertFalse(library.listBooks().equals("some string\n"));
    }

    @Test
    public void shouldCheckOutBookWhenTitleIsGiven() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(true);
        when(harryPotter.hasTitle("Harry Potter")).thenReturn(true);
        library.checkOut("Harry Potter");
        verify(harryPotter).checkOut();
    }

    @Test
    public void shouldCheckOutMovie() {
        movieList.add(defaultMovie);
        when(defaultMovie.isAvailable()).thenReturn(true);
        when(defaultMovie.hasTitle("Title 1")).thenReturn(true);
        library.checkOutMovie("Title 1");
        verify(defaultMovie).checkOut();
    }

    @Test
    public void shouldPrintSuccessMessageWhenBookIsSuccessfullyCheckedOut() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(true);
        when(harryPotter.hasTitle("Harry Potter")).thenReturn(true);
        assertEquals(library.checkOut("Harry Potter"), "Thank you! Enjoy the book");
    }

    @Test
    public void shouldPrintFailureMessageWhenBookIsNotAvailableInLibrary() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(false);
        when(harryPotter.hasTitle("Harry Potter")).thenReturn(true);
        assertEquals(library.checkOut("Harry Potter"), "That book is not available.");
    }

    @Test
    public void shouldAddBookToBooklistWhenBookIsReturned() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(false);
        when(harryPotter.hasTitle("Harry Potter")).thenReturn(true);
        library.returnBook("Harry Potter");
        verify(harryPotter).returnBook();
    }

    @Test
    public void shouldPrintSuccessMessageWhenBookIsSuccessfullyReturned() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(false);
        when(harryPotter.hasTitle("Harry Potter")).thenReturn(true);
        library.returnBook("Harry Potter");
        assertEquals(library.returnBook("Harry Potter"), "Thank you for returning the book.");
    }

    @Test
    public void shouldPrintFailureMessageWhenBookIsNotSuccessfullyReturned() {
        library.returnBook("Harry Potter");
        assertEquals(library.returnBook("Harry Potter"), "That is not a valid book to return.");
    }

}