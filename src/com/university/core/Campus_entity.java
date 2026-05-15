package com.university.core;

abstract class Campus_entity{

    // Attributes
    protected int entityID ;
    protected String name;
    protected String location;

    // Constructors
    public Campus_entity(){
    }
    public Campus_entity(int entityID, String name, String location){
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

}



