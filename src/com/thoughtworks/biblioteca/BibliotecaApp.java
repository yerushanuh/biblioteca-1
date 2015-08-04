package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    private final PrintStream printStream;
    private List<Book> bookList;

    public BibliotecaApp(PrintStream printStream){
        this.printStream = printStream;
        this.bookList = new ArrayList<String>();
        this.bookList.add("Book 1");
        this.bookList.add("Book 2");
    }
    public void start() {
        printStream.println("Welcome to the Biblioteca Library!");
    }

    public void listBooks() {
        for (String book : bookList){
            printStream.println(book);
        }
    }
}
