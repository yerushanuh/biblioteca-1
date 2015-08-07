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


public class LibraryAppTest {

    private PrintStream printStream;
    private LibraryApp libraryApp;
    private List<Book> bookList;
    private Book harryPotter;
    private BufferedReader bufferedReader;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bookList = new ArrayList<>();
        bufferedReader = mock(BufferedReader.class);
        libraryApp = new LibraryApp(printStream, bufferedReader, bookList);
        harryPotter = mock(Book.class);

    }

    @Test
    public void shouldPrintWelcomeMessageWhenStarting() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "0");
        libraryApp.start();
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldListExistingBooksInLibrary(){
        bookList.add(harryPotter);
        when(harryPotter.getDetailsAsString()).thenReturn("some string");
        when(harryPotter.isAvailable()).thenReturn(true);
        libraryApp.listBooks();
        verify(printStream).print(contains("some string"));
    }

    @Test
    public void shouldListNothingWhenNoBooksInLibrary(){
        libraryApp.listBooks();
        verify(printStream).print(contains(""));
    }

    @Test
    public void shouldNotIncludeBookInBookListWhenBookIsCheckedOut() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(false);
        when(harryPotter.getDetailsAsString()).thenReturn("some string");
        libraryApp.listBooks();
        verify(printStream, times(0)).print(contains("some string"));
    }

    @Test
    public void shouldCheckOutBookWhenTitleIsGiven() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(true);
        when(harryPotter.hasTitle("Harry Potter")).thenReturn(true);
        libraryApp.checkOut("Harry Potter");
        verify(harryPotter).checkOut();
    }

    @Test
    public void shouldPrintSuccessMessageWhenBookIsSuccessfullyCheckedOut() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(true);
        when(harryPotter.hasTitle("Harry Potter")).thenReturn(true);
        libraryApp.checkOut("Harry Potter");
        verify(printStream).println(contains("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldPrintFailureMessageWhenBookIsNotAvailableInLibrary() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(false);
        when(harryPotter.hasTitle("Harry Potter")).thenReturn(true);
        libraryApp.checkOut("Harry Potter");
        verify(printStream).println(contains("That book is not available."));
    }
}