package com.university.core;

public abstract class Facility extends CampusEntity {
    // Attributes
    protected int capacity;
    protected double maintenanceCost;
    protected static int totalFacilityUsage = 0;


    // Constructor
    public Facility(){
        totalFacilityUsage++;
    }
    public Facility(int entityID, String name, String location, double maintenanceCost){
        super(entityID, name, location);
        this.maintenanceCost = maintenanceCost;
        totalFacilityUsage++;
    }
    // Abstract method | override krna
    public double calculateOperationalCost(){
        return maintenanceCost + (totalFacilityUsage * 10);
    }

    // toString()
    public String toString(){
        return capacity + " " + " " + maintenanceCost;
    }
}
