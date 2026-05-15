package com.university.Facility;

import com.university.Interfaces.Reportable;

public class Library implements Reportable {
    private String librarian;
    private int totalBooks;
    private Book book;

    Library() {
        librarian = "Unknown";
        totalBooks = 0;
        book = new Book();
    }

    Library(String librarian, int totalBooks, Book book) {
        this.librarian = librarian;
        this.totalBooks = totalBooks;
        this.book = book;
    }

    public void setLibrarian(String librarian) {
        this.librarian = librarian;
    }

    public String getLibrarian() {
        return librarian;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
