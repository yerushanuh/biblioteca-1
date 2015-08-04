package com.thoughtworks.biblioteca;

import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

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
        String output = "";
        for (Book book : bookList){
            output += book.getTitle() + "\n";
        }

        printStream.print(output);
    }

    public void printBookDetails() {
        String output = "";
        for (Book book : bookList){
            output += book.getDetailsAsString() + "\n";
        }

        printStream.print(output);
    }
}
