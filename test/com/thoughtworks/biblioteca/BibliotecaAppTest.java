package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

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
        verify(printStream).println("Welcome to the Biblioteca Library!");
    }

    @Test
    public void shouldListExistingBooksInLibrary(){
        bibliotecaApp.listBooks();
        verify(printStream).println("Book 1");
        verify(printStream).println("Book 2");
    }
}