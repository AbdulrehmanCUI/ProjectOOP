package com.university.core;
import com.university.Interfaces.Identifiable;

import java.io.Serializable;

abstract class CampusEntity implements Identifiable, Serializable {

    // Attributes
    protected int entityID;
    protected String name;
    protected String location;

    // Default Constructor
    public CampusEntity() {
        try {
            this.entityID = 0;
            this.name = "";
            this.location = "";
        } catch (Exception e) {
            System.out.println("Error in default constructor: " + e.getMessage());
        }
    }

    // Parameterized Constructor
    public CampusEntity(int entityID, String name, String location) {
        try {
            if (entityID <= 0) {
                throw new Exception("Entity ID must be greater than 0");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("Name cannot be empty");
            }
            if (location == null || location.trim().isEmpty()) {
                throw new Exception("Location cannot be empty");
            }

            this.entityID = entityID;
            this.name = name;
            this.location = location;

        } catch (Exception e) {
            System.out.println("Constructor Error: " + e.getMessage());
        }
    }

    // Abstract method
    abstract double calculateOperationalCost();

    // Getters
    public int getID() {
        return entityID;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setEntityID(int entityID) {
        try {
            if (entityID <= 0) {
                throw new Exception("Entity ID must be greater than 0");
            }
            this.entityID = entityID;
        } catch (Exception e) {
            System.out.println("Error in setEntityID: " + e.getMessage());
        }
    }

    public void setName(String name) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("Name cannot be empty");
            }
            this.name = name;
        } catch (Exception e) {
            System.out.println("Error in setName: " + e.getMessage());
        }
    }

    public void setLocation(String location) {
        try {
            if (location == null || location.trim().isEmpty()) {
                throw new Exception("Location cannot be empty");
            }
            this.location = location;
        } catch (Exception e) {
            System.out.println("Error in setLocation: " + e.getMessage());
        }
    }

    // toString()
    public String toString() {
        return entityID + " " + name + " " + location;
    }
}

