package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


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
    public void shouldPrintWelcomeMessageWhenStarting(){
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
    public void shouldShowMenuOptionsWhenMenuIsDisplayed(){
        bibliotecaApp.start();
        verify(printStream).println(contains("Enter [1]"));
    }

    @Test
    public void shouldGetBookDetailsWhenUserInputsOne() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        bookList.add(harryPotter);
        bibliotecaApp.start();
        verify(harryPotter).getDetailsAsString();
    }

    @Test
    public void shouldReportErrorMessageWhenInputIsNotInteger() throws IOException {
        when(bufferedReader.readLine()).thenReturn("not an integer");
        bookList.add(harryPotter);
        bibliotecaApp.start();
        verify(printStream).println(contains("Please enter a valid integer."));
    }

    @Test
    public void shouldReportErrorWhenInvalidOptionSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("-1");
        bookList.add(harryPotter);
        bibliotecaApp.start();
        verify(printStream).println(contains("Select a valid option!"));
    }

}