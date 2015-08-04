package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    private final PrintStream printStream;
    private List<Book> bookList;

    public BibliotecaApp(PrintStream printStream){
        this.printStream = printStream;
        this.bookList = new ArrayList<Book>();
        this.bookList.add(new Book("Title 1", "Author 1", 1));
        this.bookList.add(new Book("Title 2", "Author 2", 2));
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
