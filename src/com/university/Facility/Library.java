package com.university.Facility;

import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {

    // Attributes
    private String librarian;
    private int totalBooks;
    private ArrayList<Book> book;

    // Default Constructor
    Library() {

        try {
            librarian = "Unknown";
            totalBooks = 0;
            book = new ArrayList<>();
        }

        catch(Exception e) {
            System.out.println("Error in default constructor: " + e.getMessage());
        }
    }

    //  Constructor
    Library(String librarian, int totalBooks, ArrayList<Book> book) {

        try {

            if(librarian == null || librarian.trim().isEmpty()) {
                throw new Exception("Librarian name cannot be empty");
            }

            if(totalBooks < 0) {
                throw new Exception("Total books cannot be negative");
            }

            if(book == null) {
                throw new Exception("Book list cannot be null");
            }

            this.librarian = librarian;
            this.totalBooks = totalBooks;
            this.book = book;
        }

        catch(Exception e) {
            System.out.println("Constructor Error: " + e.getMessage());
        }
    }


    // Setter & Getter

    public void setLibrarian(String librarian) {

        try {

            if(librarian == null || librarian.trim().isEmpty()) {
                throw new Exception("Librarian name cannot be empty");
            }

            this.librarian = librarian;
        }

        catch(Exception e) {
            System.out.println("Error in setLibrarian: " + e.getMessage());
        }
    }

    public String getLibrarian() {
        return librarian;
    }


    public void setTotalBooks(int totalBooks) {

        try {

            if(totalBooks < 0) {
                throw new Exception("Total books cannot be negative");
            }

            this.totalBooks = totalBooks;
        }

        catch(Exception e) {
            System.out.println("Error in setTotalBooks: " + e.getMessage());
        }
    }

    public int getTotalBooks() {
        return totalBooks;
    }


    public void setBook(ArrayList<Book> book) {

        try {

            if(book == null) {
                throw new Exception("Book list cannot be null");
            }

            this.book = book;
        }

        catch(Exception e) {
            System.out.println("Error in setBook: " + e.getMessage());
        }
    }


    public void getBook() {

        try {

            if(book.isEmpty()) {
                throw new Exception("No books available");
            }

            for(Book b : book) {
                System.out.println(b + "\n");
            }
        }

        catch(Exception e) {
            System.out.println("Error in getBook: " + e.getMessage());
        }
    }

    // toString method
    public String toString() {
        return librarian + " " + totalBooks + " " + book;
    }
}