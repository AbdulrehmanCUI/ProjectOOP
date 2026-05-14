package com.university.Facility;

public class Cafeteria {
    private String menu;
    private int seats;
    private String timing;

    Cafeteria() {
        menu = "Not Available";
        seats = 0;
        timing = "None";
    }

    Cafeteria(String menu, int seats, String timing) {
        this.menu = menu;
        this.seats = seats;
        this.timing = timing;
    }
    
    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getTiming() {
        return timing;
    }
}
