package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new PrintStream(System.out));
        bibliotecaApp.start();
        bibliotecaApp.listBooks();
    }
}
