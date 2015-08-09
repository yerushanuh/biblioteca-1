package com.thoughtworks.biblioteca;

import java.util.List;

public class Library {
    private List<Book> bookList;

    public Library(List<Book> listOfBooks) {
        this.bookList = listOfBooks;
    }

    public String listBooks() {
        String output = "";
        for (Book book : bookList) {
            if (book.isAvailable()) {
                output += book.getDetailsAsString() + "\n";
            }
        }
        return output;
    }

    public String checkOut(String bookTitle) {
        String output;
        boolean bookFound = false;
        for (Book book : bookList) {
            if (!bookFound && book.hasTitle(bookTitle) && book.isAvailable()) {
                book.checkOut();
                bookFound = true;
            }
        }
        if (bookFound) {
            output = "Thank you! Enjoy the book";
        } else {
            output = "That book is not available.";
        }
        return output;
    }

    public String returnBook(String bookTitle) {
        String output;
        boolean bookFound = false;
        for (Book book : bookList) {
            if (!bookFound && book.hasTitle(bookTitle) && !book.isAvailable()) {
                book.returnBook();
                bookFound = true;
            }
        }
        if (bookFound) {
            output = "Thank you for returning the book.";
        } else {
            output = "That is not a valid book to return.";
        }
        return output;
    }
}
