package com.university.Facility;

import java.io.Serial;
import java.io.Serializable;

public class Book implements Serializable {

    // Attributes
    private String title;
    private String author;
    private int pages;

    // Default Constructor
    Book() {
        try {
            title = "No Title";
            author = "Unknown";
            pages = 0;
        }
        catch (Exception e) {
            System.out.println("Error in default constructor: " + e.getMessage());
        }
    }

    //  Constructor
    Book(String title, String author, int pages) {

        try {
            if(title == null || title.trim().isEmpty()) {
                throw new Exception("Title cannot be empty");
            }

            if(author == null || author.trim().isEmpty()) {
                throw new Exception("Author cannot be empty");
            }

            if(pages <= 0) {
                throw new Exception("Pages must be greater than 0");
            }

            this.title = title;
            this.author = author;
            this.pages = pages;
        }

        catch(Exception e) {
            System.out.println("Constructor Error: " + e.getMessage());
        }
    }

    // Setters
    public void setTitle(String title) {

        try {
            if(title == null || title.trim().isEmpty()) {
                throw new Exception("Title cannot be empty");
            }

            this.title = title;
        }

        catch(Exception e) {
            System.out.println("Error in setTitle: " + e.getMessage());
        }
    }

    public void setAuthor(String author) {

        try {
            if(author == null || author.trim().isEmpty()) {
                throw new Exception("Author cannot be empty");
            }

            this.author = author;
        }

        catch(Exception e) {
            System.out.println("Error in setAuthor: " + e.getMessage());
        }
    }

    public void setPages(int pages) {

        try {
            if(pages <= 0) {
                throw new Exception("Pages must be greater than 0");
            }

            this.pages = pages;
        }

        catch(Exception e) {
            System.out.println("Error in setPages: " + e.getMessage());
        }
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    // toString
    public String toString() {
        return title + " " + author + " " + pages;
    }
}