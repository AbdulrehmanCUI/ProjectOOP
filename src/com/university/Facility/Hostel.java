package com.university.Facility;

public class Hostel {
    private int rooms;
    private String warden;
    private int students;

    Hostel() {
        rooms = 0;
        warden = "Unknown";
        students = 0;
    }

    Hostel(int rooms, String warden, int students) {
        this.rooms = rooms;
        this.warden = warden;
        this.students = students;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getRooms() {
        return rooms;
    }

    public void setWarden(String warden) {
        this.warden = warden;
    }

    public String getWarden() {
        return warden;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public int getStudents() {
        return students;
    }

    public String toString(){
        return rooms + " " + " " + warden + " " + " " + students;
    }
}
