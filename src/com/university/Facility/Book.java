package com.university.Facility;

public class Book {

    // Attributes
    private String title;
    private String author;
    private int pages;

    // Constructors
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
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPages() {
        return pages;
    }


    // toString method
    public String toString(){
        return title + " " + " " + author + " " + " " + pages;
    }
}




