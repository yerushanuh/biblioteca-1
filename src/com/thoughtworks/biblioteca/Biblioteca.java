package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * Created by ynuh on 8/9/15.
 */
public class Biblioteca {

    private PrintStream printStream;
    private Library library;
    private Menu menu;
    private MenuCommand menuCommand;

    public Biblioteca(PrintStream printStream, BufferedReader bufferedReader, Library library) {
        this.printStream = printStream;
        this.library = library;
        menuCommand = new MenuCommand(printStream, bufferedReader, this.library);
        menu = new Menu(printStream, bufferedReader, menuCommand);
    }

    public void start() {
        printStream.println("Welcome to the Biblioteca Library!");
        menu.showOptions();
        menu.respondToUserInput();
    }
}
