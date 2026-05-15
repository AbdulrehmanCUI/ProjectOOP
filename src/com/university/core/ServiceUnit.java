package com.university.core;

abstract class ServiceUnit extends Campus_entity {

    // Attributes
    protected int serviceHours;
    protected int staffCount;

    // Abstract method
    abstract double calculateOperationalCost();

    // toString method
    public String toString(){
        return serviceHours + " " + " " + staffCount;
    }
}
