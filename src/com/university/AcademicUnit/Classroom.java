package com.university.AcademicUnit;

import com.university.core.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Classroom extends AcademicUnit implements Serializable {

    // Attributes
    private int roomNo;
    private int capacity;
    private String buildingName;
    private boolean available = true;

    // Composition
    private ArrayList<Equipment> equipments = new ArrayList<>();

    // To track occupied slots inside classroom
    private ArrayList<String> occupiedSlots = new ArrayList<>();

    // Constructors
    public Classroom() {}

    public Classroom(int roomNo, int capacity, String buildingName) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.buildingName = buildingName;
        this.available = true;
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

    public ArrayList<String> markUnavailable() {
        this.available = false;

        ArrayList<String> affectedSlots = new ArrayList<>(occupiedSlots);
        occupiedSlots.clear();

        return affectedSlots;
    }

    public void markAvailable() {
        this.available = true;
    }

    public void addOccupiedSlot(String slot) {
        occupiedSlots.add(slot);
    }

    public ArrayList<String> getOccupiedSlots() {
        return occupiedSlots;
    }

    public void clearSlots() {
        occupiedSlots.clear();
    }





    // Getters
    public int getRoomNo() {
        return roomNo;
    }
    public int getCapacity() {
        return capacity;
    }
    public String getBuildingName() {
        return buildingName;
    }
    public boolean isAvailable() {
        return available;
    }
    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    // Setters
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
    public void setEquipments(ArrayList<Equipment> equipments) {
        this.equipments = equipments;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // toString()
    @Override
    public String toString() {
        return "Room: " + roomNo + ", Building: " + buildingName + ", Capacity: " + capacity + ", Available: " + available;
    }
}









