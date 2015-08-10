package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

public class Menu {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Boolean userHasNotQuit;
    private MenuCommand menuCommand;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, MenuCommand menuCommand) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.userHasNotQuit = true;
        this.menuCommand = menuCommand;
    }

    public void showOptions() {
        printStream.println("Menu");
        printStream.println("Enter [1] to show all books");
        printStream.println("Enter [2] to checkout books");
        printStream.println("Enter [3] to return books");
        printStream.println("Enter [4] to show all movies");
        printStream.println("Enter [5] to checkout movies");
        printStream.println("Quit [0]");
    }

    public void runMenuOptions() {
        userHasNotQuit = menuCommand.processUserCommand();
        while (userHasNotQuit) {
            userHasNotQuit = menuCommand.processUserCommand();
        }
    }




}
