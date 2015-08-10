package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ynuh on 8/7/15.
 */
public class MenuCommandTest {

    private MenuCommand menuCommand;
    private BufferedReader bufferedReader;
    private Library library;
    private PrintStream printStream;

    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        menuCommand = new MenuCommand(printStream, bufferedReader, library);
    }

    @Test
    public void shouldReportErrorWhenInvalidIntegerSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("-1", "1", "0");
        menuCommand.processUserCommand();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldReportErrorMessageWhenInputIsNotInteger() throws IOException {
        when(bufferedReader.readLine()).thenReturn("not an integer", "1", "0");
        menuCommand.processUserCommand();
        verify(printStream).println(contains("Select a valid option!"));
    }


    @Test
    public void shouldListBooksWhenOption1IsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "0");
        menuCommand.processUserCommand();
        verify(library).listBooks();
    }

    @Test
    public void shouldCheckOutBooksWhenOption2IsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2", "some title", "0");
        menuCommand.processUserCommand();
        verify(library).checkOut("some title");
    }

    @Test
    public void shouldReturnBooksWhenOption3IsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("3", "some title", "0");
        menuCommand.processUserCommand();
        verify(library).returnBook("some title");
    }

}