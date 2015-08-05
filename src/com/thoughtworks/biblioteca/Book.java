package com.thoughtworks.biblioteca;


public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }



    public String getDetailsAsString() {
        return this.title + " | " + this.author + " | " + this.year;
    }
}
