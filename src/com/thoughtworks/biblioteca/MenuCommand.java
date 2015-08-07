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
    private LibraryApp libraryApp;

    public MenuCommand(PrintStream printStream, BufferedReader bufferedReader, LibraryApp libraryApp) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.libraryApp = libraryApp;
    }

    public void checkOutBook() {
        printStream.println("Enter the title of the book you would like to check out.");
        String bookTitle = "";
        try {
            bookTitle = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        libraryApp.checkOut(bookTitle);
    }
}
