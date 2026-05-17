package com.university.Facility;

import java.io.Serializable;

public class Cafeteria implements Serializable {

    // Attribute
    private String menu;
    private int seats;
    private String timing;

    // Default Constructor
    Cafeteria() {

        try {
            menu = "Not Available";
            seats = 0;
            timing = "None";
        }

        catch(Exception e) {
            System.out.println("Error in default constructor: " + e.getMessage());
        }
    }

    // Parameterized Constructor
    Cafeteria(String menu, int seats, String timing) {

        try {

            if(menu == null || menu.trim().isEmpty()) {
                throw new Exception("Menu cannot be empty");
            }

            if(seats <= 0) {
                throw new Exception("Seats must be greater than 0");
            }

            if(timing == null || timing.trim().isEmpty()) {
                throw new Exception("Timing cannot be empty");
            }

            this.menu = menu;
            this.seats = seats;
            this.timing = timing;
        }

        catch(Exception e) {
            System.out.println("Constructor Error: " + e.getMessage());
        }
    }


    // Getter & Setter

    public void setMenu(String menu) {

        try {

            if(menu == null || menu.trim().isEmpty()) {
                throw new Exception("Menu cannot be empty");
            }

            this.menu = menu;
        }

        catch(Exception e) {
            System.out.println("Error in setMenu: " + e.getMessage());
        }
    }

    public String getMenu() {
        return menu;
    }

    public void setSeats(int seats) {

        try {

            if(seats <= 0) {
                throw new Exception("Seats must be greater than 0");
            }

            this.seats = seats;
        }

        catch(Exception e) {
            System.out.println("Error in setSeats: " + e.getMessage());
        }
    }

    public int getSeats() {
        return seats;
    }

    public void setTiming(String timing) {

        try {

            if(timing == null || timing.trim().isEmpty()) {
                throw new Exception("Timing cannot be empty");
            }

            this.timing = timing;
        }

        catch(Exception e) {
            System.out.println("Error in setTiming: " + e.getMessage());
        }
    }

    public String getTiming() {
        return timing;
    }

    // toString()
    public String toString() {
        return menu + " " + seats + " " + timing;
    }

}