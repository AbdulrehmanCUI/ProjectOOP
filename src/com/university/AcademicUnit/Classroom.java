package com.university.AcademicUnit;

import com.university.core.*;
import java.util.ArrayList;

class Classroom extends Academic_unit {

    private int roomNo;
    private int capacity;
    private String buildingName;

    private ArrayList<Equipment> equipments = new ArrayList<>();

    public Classroom() {}

    public Classroom(int roomNo, int capacity, String buildingName) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.buildingName = buildingName;
    }

    @Override
    public double calculateOperationalCost() {

        double operationalCost = 0;

        for (Equipment eq : equipments) {
            operationalCost += eq.getOperationalCost();
        }

        operationalCost += capacity * 50;
        return operationalCost;
    }
    // Setters

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setEquipments(ArrayList<Equipment> equipments) {
        this.equipments = equipments;
    }
}