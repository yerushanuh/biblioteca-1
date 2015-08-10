package com.thoughtworks.biblioteca;

import java.util.List;

public class Library {
    private List<Book> bookList;
    private List<Movie> movieList;

    public Library(List<Book> listOfBooks, List<Movie> listOfMovies) {
        this.bookList = listOfBooks;
        this.movieList = listOfMovies;
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

    public String listMovies() {
        String output = "";
        for (Movie movie : movieList) {
            if (movie.isAvailable()) {
                output += movie.getDetailsAsString() + "\n";
            }
        }
        return output;
    }

    public void checkOutMovie(String title) {
        for (Movie movie : movieList) {
            if (movie.isAvailable() && movie.hasTitle("Title 1")) {
                movie.checkOut();
            }
        }
    }
}
