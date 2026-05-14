package com.university.Facility;

public class Book {

    private String title;
    private String author;
    private int pages;

    Book() {
        title = "No Title";
        author = "Unknown";
        pages = 0;
    }

    Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
