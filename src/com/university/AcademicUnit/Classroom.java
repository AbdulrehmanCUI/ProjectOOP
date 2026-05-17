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

        try{

            if(roomNo <= 0){
                throw new Exception("Invalid room number");
            }

            if(capacity <= 0){
                throw new Exception("Capacity cannot be negative");
            }

            if(buildingName == null || buildingName.isEmpty()){
                throw new Exception("Building name cannot be empty");
            }

            this.roomNo = roomNo;
            this.capacity = capacity;
            this.buildingName = buildingName;
            this.available = true;
        }

        catch(Exception e){

            System.out.println(e.getMessage());

            this.roomNo = 0;
            this.capacity = 0;
            this.buildingName = "Unknown";
        }
    }


    @Override
    public double calculateOperationalCost() {

        double operationalCost = 0;

        try{

            for (Equipment eq : equipments) {

                if(eq == null){
                    throw new Exception("Equipment missing");
                }

                operationalCost += eq.getOperationalCost();
            }

        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }

        operationalCost += capacity * 50;

        return operationalCost;
    }


    public ArrayList<String> markUnavailable() {

        this.available = false;

        ArrayList<String> affectedSlots =
                new ArrayList<>(occupiedSlots);

        occupiedSlots.clear();

        return affectedSlots;
    }


    public void markAvailable() {
        this.available = true;
    }


    public void addOccupiedSlot(String slot) {

        try{

            if(slot == null || slot.isEmpty()){
                throw new Exception("Slot cannot be empty");
            }

            occupiedSlots.add(slot);
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
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

        try{

            if(roomNo <= 0){
                throw new Exception("Invalid room number");
            }

            this.roomNo = roomNo;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public void setCapacity(int capacity) {

        try{

            if(capacity <= 0){
                throw new Exception("Capacity cannot be negative");
            }

            this.capacity = capacity;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public void setBuildingName(String buildingName) {

        try{

            if(buildingName == null || buildingName.isEmpty()){
                throw new Exception("Building name cannot be empty");
            }

            this.buildingName = buildingName;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public void setEquipments(ArrayList<Equipment> equipments) {

        try{

            if(equipments == null){
                throw new Exception("Equipment list missing");
            }

            this.equipments = equipments;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public void setAvailable(boolean available) {
        this.available = available;
    }



    // toString()
    @Override
    public String toString() {

        return "Room: " + roomNo
                + ", Building: " + buildingName
                + ", Capacity: " + capacity
                + ", Available: " + available;
    }
}








