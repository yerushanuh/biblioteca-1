package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BibliotecaAppTest {

    private PrintStream printStream;
    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bibliotecaApp = new BibliotecaApp(printStream);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenStarting(){
        bibliotecaApp.start();
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldListExistingBooksInLibrary(){
        bibliotecaApp.listBooks();
        verify(printStream).print(contains("Title 1"));
        verify(printStream).print(contains("Title 2"));
    }

    @Test
    public void shouldListNothingWhenNoBooksInLibrary(){
        bibliotecaApp.listBooks();
        verify(printStream).print(contains(""));
    }

    @Test
    public void shouldListExistingBookDetails() {
        bibliotecaApp.printBookDetails();
        verify(printStream).print(contains("Title 1"));
        verify(printStream).print(contains("Author 1"));
        verify(printStream).print(contains("1"));
    }
}