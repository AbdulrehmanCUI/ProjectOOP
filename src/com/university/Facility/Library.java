package com.university.Facility;

import java.util.ArrayList;

public class Library {

    // Attributes
    private String librarian;
    private int totalBooks;
    private ArrayList<Book> book;

    // Constructor
    Library() {
        librarian = "Unknown";
        totalBooks = 0;
        book = new ArrayList<>();
    }
    Library(String librarian, int totalBooks, ArrayList<Book> book){
        this.librarian = librarian;
        this.totalBooks = totalBooks;
        this.book = book;

    }


    // Setter & Getter
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
    public void setBook(ArrayList<Book> book) {
        this.book = book;
    }
    public void getBook() {
        for(Book b : book){
            System.out.println(b + "\n");
        }
    }


    // toString method
    public String toString(){
        return librarian + " " + " " + totalBooks + " " + " " + book;
    }
}
