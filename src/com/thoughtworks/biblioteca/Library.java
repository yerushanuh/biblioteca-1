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
        boolean bookFound = false;
        for (Book book : bookList) {
            if (!bookFound && book.hasTitle(bookTitle) && book.isAvailable()) {
                book.checkOut();
                bookFound = true;
                return "Thank you! Enjoy the book";
            }
        }
        return "That book is not available.";

    }

    public String returnBook(String bookTitle) {
        boolean bookFound = false;
        for (Book book : bookList) {
            if (!bookFound && book.hasTitle(bookTitle) && !book.isAvailable()) {
                book.returnBook();
                bookFound = true;
                return "Thank you for returning the book.";
            }
        }
        return "That is not a valid book to return.";
    }
}
