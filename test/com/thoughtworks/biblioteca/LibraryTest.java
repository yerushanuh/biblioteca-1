package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;


public class LibraryTest {

    private PrintStream printStream;
    private Library library;
    private List<Book> bookList;
    private Book harryPotter;
    private BufferedReader bufferedReader;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bookList = new ArrayList<>();
        bufferedReader = mock(BufferedReader.class);
        library = new Library(printStream, bookList);
        harryPotter = mock(Book.class);

    }

    @Test
    public void shouldListExistingBooksInLibrary(){
        bookList.add(harryPotter);
        when(harryPotter.getDetailsAsString()).thenReturn("some string");
        when(harryPotter.isAvailable()).thenReturn(true);
        library.listBooks();
        verify(printStream).print(contains("some string"));
    }

    @Test
    public void shouldListNothingWhenNoBooksInLibrary(){
        library.listBooks();
        verify(printStream).print(contains(""));
    }

    @Test
    public void shouldNotIncludeBookInBookListWhenBookIsCheckedOut() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(false);
        when(harryPotter.getDetailsAsString()).thenReturn("some string");
        library.listBooks();
        verify(printStream, times(0)).print(contains("some string"));
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
    public void shouldPrintSuccessMessageWhenBookIsSuccessfullyCheckedOut() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(true);
        when(harryPotter.hasTitle("Harry Potter")).thenReturn(true);
        library.checkOut("Harry Potter");
        verify(printStream).println(contains("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldPrintFailureMessageWhenBookIsNotAvailableInLibrary() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(false);
        when(harryPotter.hasTitle("Harry Potter")).thenReturn(true);
        library.checkOut("Harry Potter");
        verify(printStream).println(contains("That book is not available."));
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
        verify(printStream).println(contains("Thank you for returning the book."));
    }

    @Test
    public void shouldPrintFailureMessageWhenBookIsNotSuccessfullyReturned() {
        library.returnBook("Harry Potter");
        verify(printStream).println(contains("That is not a valid book to return."));
    }

}