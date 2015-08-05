package com.thoughtworks.biblioteca;

import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private List<Book> bookList;
    private final Menu menu;

    public BibliotecaApp(PrintStream printStream, BufferedReader bufferedReader, List<Book> listOfBooks){
        bookList = listOfBooks;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        menu = new Menu();
    }

    public void start() {
        printStream.println("Welcome to the Biblioteca Library!");
        menu.showOptions();
        menu.respondToUserInput();
    }

    public void listBooks() {
        String output = "";
        for (Book book : bookList){
            output += book.getDetailsAsString() + "\n";
        }

        printStream.print(output);
    }

    private class Menu{

        public void showOptions() {
            printStream.println("Menu");
            printStream.println("Enter [1] to show all books");
        }

        public void respondToUserInput() {
            listBooks();
        }
    }

}
