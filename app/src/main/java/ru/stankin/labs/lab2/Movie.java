package ru.stankin.labs.lab2;

public class Movie {
    private String title;
    private String year;
    private String genre;
    private String description;

    public Movie(String title, String year, String genre, String description) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.description = description;
    }

    public String getTitle() { return title; }
    public String getYear() { return year; }
    public String getGenre() { return genre; }
    public String getDescription() { return description; }
}
