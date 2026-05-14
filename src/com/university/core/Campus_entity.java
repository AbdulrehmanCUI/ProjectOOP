package com.university.core;

abstract class Campus_entity{
    protected int entityID ;
    protected String name;
    protected String location;


    public Campus_entity(){
    }
    public Campus_entity(int entityID, String name, String location){
        this.entityID = entityID;
        this.name = name;
        this.location = location;
    }

    abstract double calculateOperationalCost();

    public String toString(){
        return entityID + " " + name + " " + location;
    }

}



