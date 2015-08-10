package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by ynuh on 8/7/15.
 */
public class MenuCommand {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Library library;

    public MenuCommand(PrintStream printStream, BufferedReader bufferedReader, Library library) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.library = library;
    }

    public Boolean processUserCommand() {
        return applySelectedMenuOption(readAndValidateInputMenuOption());
    }

    private void checkOutBook() {
        printStream.println("Enter the title of the book you would like to check out.");
        String bookTitle = getUserInput();
        String output = library.checkOut(bookTitle);
        printStream.println(output);
    }

    private void returnBook() {
        printStream.println("Enter the title of the book you would like to return.");
        String bookTitle = getUserInput();
        String output = library.returnBook(bookTitle);
        printStream.println(output);
    }

    private void listBooks() {
        String output = library.listBooks();
        printStream.println(output);
    }

    private String getUserInput() {
        String string = "";
        try {
            string = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    private boolean applySelectedMenuOption(Integer input) {
        switch (input) {
            case 0:
                return false;
            case 1:
                listBooks();
                break;
            case 2:
                checkOutBook();
                break;
            case 3:
                returnBook();
                break;
            case 4:
                listMovies();
                break;
            case 5:
                checkOutMovie();
                break;
            default:
                printStream.println("Select a valid option!");
        }
        return true;
    }

    private void checkOutMovie() {
        library.checkOutMovie("title");
    }

    private void listMovies() {
        String output = library.listMovies();
        printStream.println(output);
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
