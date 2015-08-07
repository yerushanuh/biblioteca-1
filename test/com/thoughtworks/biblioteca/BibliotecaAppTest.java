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


public class BibliotecaAppTest {

    private PrintStream printStream;
    private BibliotecaApp bibliotecaApp;
    private List<Book> bookList;
    private Book harryPotter;
    private BufferedReader bufferedReader;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bookList = new ArrayList<>();
        bufferedReader = mock(BufferedReader.class);
        bibliotecaApp = new BibliotecaApp(printStream, bufferedReader, bookList);
        harryPotter = mock(Book.class);

    }

    @Test
    public void shouldPrintWelcomeMessageWhenStarting() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        bibliotecaApp.start();
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldListExistingBooksInLibrary(){
        bookList.add(harryPotter);
        when(harryPotter.getDetailsAsString()).thenReturn("some string");
        bibliotecaApp.listBooks();
        verify(printStream).print(contains("some string"));
    }

    @Test
    public void shouldListNothingWhenNoBooksInLibrary(){
        bibliotecaApp.listBooks();
        verify(printStream).print(contains(""));
    }

    @Test
    public void shouldNotPrintOutWhenBookIsCheckedOut() {
        bookList.add(harryPotter);
        when(harryPotter.isAvailable()).thenReturn(false);
        when(harryPotter.getDetailsAsString()).thenReturn("some string");
        bibliotecaApp.listBooks();
        verify(printStream, times(0)).print(contains("some string"));
    }




}