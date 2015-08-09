package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by lfitzger on 8/6/15.
 */
public class MenuTest {

    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private MenuCommand menuCommand;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        menuCommand = mock(MenuCommand.class);
        menu = new Menu(printStream, bufferedReader, menuCommand);
    }

    @Test
    public void shouldShowMenuOptionsWhenMenuIsDisplayed() {
        menu.showOptions();
        verify(printStream).println(contains("Enter [1]"));
        verify(printStream).println(contains("Enter [2]"));
        verify(printStream).println(contains("Enter [3]"));
        verify(printStream).println(contains("Quit [0]"));
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

    @Test
    public void shouldListBooksWhenOption1IsSelected() {
        menu.applySelectedMenuOption(1);
        verify(menuCommand).listBooks();
    }

    @Test
    public void shouldCheckOutBooksWhenOption2IsSelected() {
        menu.applySelectedMenuOption(2);
        verify(menuCommand).checkOutBook();
    }

    @Test
    public void shouldReturnBooksWhenOption3IsSelected() {
        menu.applySelectedMenuOption(3);
        verify(menuCommand).returnBook();
    }
}