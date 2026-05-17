package com.university.core;
import com.university.Interfaces.Identifiable;

import java.io.Serializable;

abstract class CampusEntity implements Identifiable, Serializable {

    // Attributes
    protected int entityID ;
    protected String name;
    protected String location;

    // Constructors
    public CampusEntity(){}
    public CampusEntity(int entityID, String name, String location){
        this.entityID = entityID;
        this.name = name;
        this.location = location;
    }

   // abstract method
    abstract double calculateOperationalCost();

   // toString()
    public String toString(){
        return entityID + " " + name + " " + location;
    }

    public int getID() {
        return entityID;
    }
}



