package com.university.core;

class Campus_entity{
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
}



