package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private BibliotecaApp bibliotecaApp;
    private Boolean userInputValid;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, BibliotecaApp bibliotecaApp) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.bibliotecaApp = bibliotecaApp;
        this.userInputValid = true;
    }

    public void showOptions() {
        printStream.println("Menu");
        printStream.println("Enter [1] to show all books");
    }

    public void respondToUserInput() {

        while (userInputValid) {
            applySelectedMenuOption(readAndValidateUserInput());
        }
    }

    private void applySelectedMenuOption(Integer input) {
        switch (input) {
            case 1:
                bibliotecaApp.listBooks();
                userInputValid = false;
                break;
            default:
                printStream.println("Select a valid option!");
        }
    }

    private Integer readAndValidateUserInput() {
        Integer input = -1;
        try {
            printStream.print("Menu selection: ");
            input = Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {}

        return input;
    }
}
