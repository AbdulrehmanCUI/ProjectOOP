package com.university.AcademicUnit;

public class Classroom {
    private int roomNo;
    private int capacity;
    private String buildingName;

    public Classroom() {
    }
    public Classroom(int roomNo, int capacity, String buildingName) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.buildingName = buildingName;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}

