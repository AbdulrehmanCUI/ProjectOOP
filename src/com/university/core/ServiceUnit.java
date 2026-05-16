package com.university.core;

abstract class ServiceUnit extends CampusEntity {

    // Attributes
    protected int serviceHours;
    protected int staffCount;

    public ServiceUnit(int entityID, String name, String location, int serviceHours, int staffCount){
        super(entityID,name,location);
        this.serviceHours = serviceHours;
        this.staffCount = staffCount;
    }

    // Abstract method
    public double calculateOperationalCost(){
        return staffCount * serviceHours * 20;
    }

    // toString method
    public String toString(){
        return serviceHours + " " + " " + staffCount;
    }
}
