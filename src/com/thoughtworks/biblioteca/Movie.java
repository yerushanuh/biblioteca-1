package com.thoughtworks.biblioteca;

/**
 * Created by ynuh on 8/10/15.
 */
public class Movie {

    private String title;
    private String director;
    private String year;
    private String rating;
    private boolean isAvailable;

    public Movie(String title, String director, String year, String rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.isAvailable = true;
    }

    public String getDetailsAsString() {
        return String.format("%-30.30s | %-30.30s | %-4.4s | %-30.30s", title, director, year, rating);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkOut() {
        isAvailable = false;
    }

    public boolean hasTitle(String chosenTitle) {
        return chosenTitle.equals(title);
    }
}
