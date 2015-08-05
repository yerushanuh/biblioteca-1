package com.thoughtworks.biblioteca;

import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    private final PrintStream printStream;
    private List<Book> bookList;

    public BibliotecaApp(PrintStream printStream, List<Book> listOfBooks){
        bookList = listOfBooks;
        this.printStream = printStream;
    }

    public void start() {
        printStream.println("Welcome to the Biblioteca Library!");
    }

    public void listBooks() {
        String output = "";
        for (Book book : bookList){
            output += book.getDetailsAsString() + "\n";
        }

        printStream.print(output);
    }


}
