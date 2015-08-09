package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ynuh on 8/9/15.
 */
public class BibliotecaTest {

    private BufferedReader bufferedReader;
    private Biblioteca biblioteca;
    private PrintStream printStream;
    private Library library;

    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        biblioteca = new Biblioteca(printStream, bufferedReader, library);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenStarting() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "0");
        biblioteca.start();
        verify(printStream).println(contains("Welcome"));
    }


}