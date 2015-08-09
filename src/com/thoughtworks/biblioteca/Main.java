package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Book> listOfBooks = new ArrayList<>();
        Book chronicles = new Book("Chronicles of Narnia", "CS Lewis", 1990);
        listOfBooks.add(chronicles);
        Book lordOfRings = new Book("Fellowship of the Rings", "JRR Tolkien", 1970);
        listOfBooks.add(lordOfRings);
        Book sandAndFog = new Book("House of Sand and Fog", "Andre Dubus", 2003);
        listOfBooks.add(sandAndFog);

        PrintStream printStream = new PrintStream(System.out);

        Library library = new Library(listOfBooks);

        Biblioteca biblioteca = new Biblioteca(printStream, new BufferedReader(new InputStreamReader(System.in)), library);
        biblioteca.start();

    }
}
