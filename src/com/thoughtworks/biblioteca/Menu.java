package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

public class Menu {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private LibraryApp libraryApp;
    private Boolean readyToReadInput;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, LibraryApp libraryApp) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.libraryApp = libraryApp;
        this.readyToReadInput = true;
    }

    public void showOptions() {
        printStream.println("Menu");
        printStream.println("Enter [1] to show all books");
        printStream.println("Enter [2] to checkout books");
        printStream.println("Quit [0] to close the library");
    }

    public void respondToUserInput() {

        while (readyToReadInput) {
            applySelectedMenuOption(readAndValidateInputMenuOption());
        }
    }

    private void applySelectedMenuOption(Integer input) {
        switch (input) {
            case 0:
                readyToReadInput = false;
                break;
            case 1:
                libraryApp.listBooks();
                break;
            case 2:
                checkOutBook();
                break;
            default:
                printStream.println("Select a valid option!");
        }
    }

    private Integer readAndValidateInputMenuOption() {
        Integer input = -1;
        try {
            printStream.println("Menu selection: ");
            input = Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {}

        return input;
    }



    public void checkOutBook() {
        printStream.println("Enter the title of the book you would like to check out.");
    }
}
