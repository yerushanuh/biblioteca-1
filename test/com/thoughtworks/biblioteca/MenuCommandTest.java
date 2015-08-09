package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

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
    public void shouldInstructLibraryToListBooksWhenListBooksChosen() {
        menuCommand.listBooks();
        verify(library).listBooks();
    }

    @Test
    public void shouldInstructLibraryToCheckOutBookWhenBookSpecified() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Harry Potter");
        menuCommand.checkOutBook();
        verify(library).checkOut("Harry Potter");
    }

    @Test
    public void shouldInstructLibraryToReturnBooksWhenBookReturnIsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Harry Potter");
        menuCommand.returnBook();
        verify(library).returnBook("Harry Potter");
    }
}