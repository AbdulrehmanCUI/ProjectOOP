package com.university.Facility;

public class Hostel {

    // Attributes
    private int rooms;
    private String warden;
    private int students;

    // Default Constructor
    Hostel() {

        try {
            rooms = 0;
            warden = "Unknown";
            students = 0;
        }

        catch(Exception e) {
            System.out.println("Error in default constructor: " + e.getMessage());
        }
    }

    //Constructor
    Hostel(int rooms, String warden, int students) {

        try {

            if(rooms <= 0) {
                throw new Exception("Rooms must be greater than 0");
            }

            if(warden == null || warden.trim().isEmpty()) {
                throw new Exception("Warden name cannot be empty");
            }

            if(students < 0) {
                throw new Exception("Students cannot be negative");
            }

            this.rooms = rooms;
            this.warden = warden;
            this.students = students;
        }

        catch(Exception e) {
            System.out.println("Constructor Error: " + e.getMessage());
        }
    }


    // Getter & Setter

    public void setRooms(int rooms) {

        try {

            if(rooms <= 0) {
                throw new Exception("Rooms must be greater than 0");
            }

            this.rooms = rooms;
        }

        catch(Exception e) {
            System.out.println("Error in setRooms: " + e.getMessage());
        }
    }

    public int getRooms() {
        return rooms;
    }


    public void setWarden(String warden) {

        try {

            if(warden == null || warden.trim().isEmpty()) {
                throw new Exception("Warden name cannot be empty");
            }

            this.warden = warden;
        }

        catch(Exception e) {
            System.out.println("Error in setWarden: " + e.getMessage());
        }
    }

    public String getWarden() {
        return warden;
    }


    public void setStudents(int students) {

        try {

            if(students < 0) {
                throw new Exception("Students cannot be negative");
            }

            this.students = students;
        }

        catch(Exception e) {
            System.out.println("Error in setStudents: " + e.getMessage());
        }
    }

    public int getStudents() {
        return students;
    }


    // toString()
    public String toString() {
        return rooms + " " + warden + " " + students;
    }
}
