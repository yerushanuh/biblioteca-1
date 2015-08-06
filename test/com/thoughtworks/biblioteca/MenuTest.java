package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lfitzger on 8/6/15.
 */
public class MenuTest {

    private BufferedReader bufferedReader;
    private  BibliotecaApp bibliotecaApp;
    private PrintStream printStream;
    private List<Book> bookList;
    private Book harryPotter;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        bibliotecaApp = mock(BibliotecaApp.class);
        bookList = new ArrayList<Book>();
        harryPotter = mock(Book.class);
        menu = new Menu(printStream, bufferedReader, bibliotecaApp);

    }

    @Test
    public void shouldShowMenuOptionsWhenMenuIsDisplayed() {
        menu.showOptions();
        verify(printStream).println(contains("Enter [1]"));
        verify(printStream).println(contains("Quit [0]"));
    }

    @Test
    public void shouldListBooksWhenMenuOptionOneIsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "0");
        menu.respondToUserInput();
        verify(bibliotecaApp).listBooks();
    }

    @Test
    public void shouldReportErrorWhenInvalidIntegerSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("-1", "1", "0");
        menu.respondToUserInput();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldReportErrorMessageWhenInputIsNotInteger() throws IOException {
        when(bufferedReader.readLine()).thenReturn("not an integer", "1", "0");
        menu.respondToUserInput();
        verify(printStream).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldBePromptedOnceWhenQuitIsFirstChoice() throws IOException {
        when(bufferedReader.readLine()).thenReturn("0", "1");
        menu.respondToUserInput();
        verify(bufferedReader).readLine();
    }


}