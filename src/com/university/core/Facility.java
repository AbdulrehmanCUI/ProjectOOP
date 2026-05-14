package com.university.core;

abstract class Facility {
    protected int capacity;
    protected double maintenanceCost;

    abstract double calculateOperationalCost();
}
