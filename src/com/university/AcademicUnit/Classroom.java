package com.university.AcademicUnit;

import com.university.core.*;
import com.university.AcademicUnit.Equipment;
class Classroom extends Academic_unit {
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

    public double calculateOperationalCost() {
        double operationalCost = 0;
        for (Equipment eq : equipments) {
            operationalCost += eq.getOperationalCost();
        }
        return operationalCost;
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

