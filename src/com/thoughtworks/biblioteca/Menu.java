package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

public class Menu {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Boolean readyToReadInput;
    private MenuCommand menuCommand;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, MenuCommand menuCommand) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.readyToReadInput = true;
        this.menuCommand = menuCommand;
    }

    public void showOptions() {
        printStream.println("Menu");
        printStream.println("Enter [1] to show all books");
        printStream.println("Enter [2] to checkout books");
        printStream.println("Enter [3] to return books");
        printStream.println("Quit [0] to close the library");
    }

    public void respondToUserInput() {
        while (readyToReadInput) {
            applySelectedMenuOption(readAndValidateInputMenuOption());
        }
    }

    public void applySelectedMenuOption(Integer input) {
        switch (input) {
            case 0:
                readyToReadInput = false;
                break;
            case 1:
                menuCommand.listBooks();
                break;
            case 2:
                menuCommand.checkOutBook();
                break;
            case 3:
                menuCommand.returnBook();
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


}
