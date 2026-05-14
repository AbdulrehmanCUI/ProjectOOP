package com.university.core;

abstract class Facility extends Campus_entity {
    protected int capacity;
    protected double maintenanceCost;

    abstract double calculateOperationalCost();
}
