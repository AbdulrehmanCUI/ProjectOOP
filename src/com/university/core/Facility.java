package com.university.core;

abstract class Facility extends Campus_entity {
    // Attributes
    protected int capacity;
    protected double maintenanceCost;

    // Abstract method
    abstract double calculateOperationalCost();

    // toString()
    public String toString(){
        return capacity +" " + " " + maintenanceCost;
    }
}
