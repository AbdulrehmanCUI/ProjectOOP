package com.university.core;

abstract class ServiceUnit extends Campus_entity
{
    protected int serviceHours;
    protected int staffCount;

    abstract double calculateOperationalCost();
    public String toString(){
        return serviceHours + " " + " " + staffCount;
    }
}
