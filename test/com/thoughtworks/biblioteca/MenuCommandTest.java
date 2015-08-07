package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ynuh on 8/7/15.
 */
public class MenuCommandTest {

    private MenuCommand menuCommands;
    private BufferedReader bufferedReader;
    private LibraryApp libraryApp;
    private PrintStream printStream;

    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        libraryApp = mock(LibraryApp.class);
        menuCommands = new MenuCommand(printStream, bufferedReader, libraryApp);
    }

    @Test
    public void shouldInstructLibraryToCheckOutBookWhenBookSpecified() throws IOException {
        when(bufferedReader.readLine()).thenReturn("Harry Potter");
        menuCommands.checkOutBook();
        verify(libraryApp).checkOut("Harry Potter");
    }
}