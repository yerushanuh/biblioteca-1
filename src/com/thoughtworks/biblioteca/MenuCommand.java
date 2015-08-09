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

    public void checkOutBook() {
        printStream.println("Enter the title of the book you would like to check out.");
        String bookTitle = getUserInput();
        library.checkOut(bookTitle);
    }

    public void returnBook() {
        printStream.println("Enter the title of the book you would like to return.");
        String bookTitle = getUserInput();
        library.returnBook(bookTitle);
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

    public void listBooks() {
        library.listBooks();
    }
}
