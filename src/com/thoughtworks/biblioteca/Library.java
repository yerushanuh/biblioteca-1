package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private PrintStream printStream;
    private List<Book> bookList;

    public Library(PrintStream printStream, List<Book> listOfBooks){
        this.bookList = listOfBooks;
        this.printStream = printStream;
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
        boolean bookFound = false;
        for (Book book: bookList) {
            if (!bookFound && book.hasTitle(bookTitle) && book.isAvailable()) {
                book.checkOut();
                bookFound = true;
            }
        }
         if(bookFound) {
             printStream.println("Thank you! Enjoy the book");
         }
         else {
             printStream.println("That book is not available.");
         }
    }

    public void returnBook(String bookTitle) {
        boolean bookFound = false;
        for (Book book: bookList) {
            if (!bookFound && book.hasTitle(bookTitle) && !book.isAvailable()) {
                book.returnBook();
                bookFound = true;
            }
        }
        if(bookFound) {
            printStream.println("Thank you for returning the book.");
        }
        else {
            printStream.println("That is not a valid book to return.");
        }
    }
}
