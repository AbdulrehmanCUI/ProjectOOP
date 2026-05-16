package com.university.core;

abstract class Facility extends CampusEntity {
    // Attributes
    protected int capacity;
    protected double maintenanceCost;
    protected static int totalFacilityUsage = 0;


    // Abstract method
    abstract double calculateOperationalCost();

    // toString()
    public String toString(){
        return capacity + " " + " " + maintenanceCost;
    }
}
