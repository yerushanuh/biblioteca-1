package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
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
    public void shouldCallForUserInputWhenUserHasNotQuit() {
        when(menuCommand.processUserCommand()).thenReturn(true, false);
        menu.runMenuOptions();
        verify(menuCommand, times(2)).processUserCommand();
    }

    @Test
    public void shouldCallForUserInputOnceWhenUserEntersQuitFirst() {
        when(menuCommand.processUserCommand()).thenReturn(false);
        menu.runMenuOptions();
        verify(menuCommand).processUserCommand();
    }
}