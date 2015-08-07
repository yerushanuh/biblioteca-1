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

    //private static final Book DEFAULT_BOOK = mock(Book.class);
    private BufferedReader bufferedReader;
    private LibraryApp libraryApp;
    private PrintStream printStream;
    private MenuCommand menuCommands;
    //private List<Book> bookList;
    private Book harryPotter;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        libraryApp = mock(LibraryApp.class);
        //bookList = new ArrayList<Book>();
        menuCommands = mock(MenuCommand.class);
        harryPotter = mock(Book.class);
        menu = new Menu(printStream, bufferedReader, libraryApp);
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
    public void shouldListBooksWhenMenuOptionOneIsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "0");
        menu.respondToUserInput();
        verify(libraryApp).listBooks();
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

    @Ignore
    public void shouldPromptUserForBookTitleWhenOption2IsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2", "0", "0");
        menu.respondToUserInput();
        verify(menuCommands).checkOutBook();
    }

}