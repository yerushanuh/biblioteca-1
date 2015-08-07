package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;

public class LibraryApp {
    private final PrintStream printStream;
    private List<Book> bookList;
    private final Menu menu;

    public LibraryApp(PrintStream printStream, BufferedReader bufferedReader, List<Book> listOfBooks){
        bookList = listOfBooks;
        this.printStream = printStream;
        menu = new Menu(printStream, bufferedReader, this);
    }

    public void start() {
        printStream.println("Welcome to the Biblioteca Library!");
        menu.showOptions();
        menu.respondToUserInput();
    }

    public void listBooks() {
        String output = "";
        for (Book book : bookList){
            if (book.isAvailable()) {
                output += book.getDetailsAsString() + "\n";
            }
        }

        printStream.print(output);
    }

    public void checkOut(String bookTitle) {
        for (Book book: bookList) {
            if (book.hasTitle(bookTitle)) {
                book.checkOut();
                printStream.println("Thank you! Enjoy the book");
            }
        }
    }
}
