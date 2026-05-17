package com.university.core;

public abstract class Facility extends CampusEntity {

    // Attributes
    protected int capacity;
    protected double maintenanceCost;
    protected static int totalFacilityUsage = 0;

    // Default Constructor
    public Facility() {
        try {
            totalFacilityUsage++;
        } catch (Exception e) {
            System.out.println("Error in default constructor: " + e.getMessage());
        }
    }

    // Parameterized Constructor with validation
    public Facility(int entityID, String name, String location, double maintenanceCost) {
        super(entityID, name, location);

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
            if (maintenanceCost < 0) {
                throw new Exception("Maintenance cost cannot be negative");
            }

            this.maintenanceCost = maintenanceCost;
            totalFacilityUsage++;

        } catch (Exception e) {
            System.out.println("Constructor Error: " + e.getMessage());
        }
    }

    // Abstract/Overridden method logic
    public double calculateOperationalCost() {
        try {
            if (maintenanceCost < 0) {
                throw new Exception("Invalid maintenance cost state");
            }
            return maintenanceCost + (totalFacilityUsage * 10);
        } catch (Exception e) {
            System.out.println("Error in calculateOperationalCost: " + e.getMessage());
            return 0;
        }
    }

    // Getters
    public int getCapacity() {
        return capacity;
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public static int getTotalFacilityUsage() {
        return totalFacilityUsage;
    }

    // Setters with exception handling

    public void setCapacity(int capacity) {
        try {
            if (capacity <= 0) {
                throw new Exception("Capacity must be greater than 0");
            }
            this.capacity = capacity;
        } catch (Exception e) {
            System.out.println("Error in setCapacity: " + e.getMessage());
        }
    }

    public void setMaintenanceCost(double maintenanceCost) {
        try {
            if (maintenanceCost < 0) {
                throw new Exception("Maintenance cost cannot be negative");
            }
            this.maintenanceCost = maintenanceCost;
        } catch (Exception e) {
            System.out.println("Error in setMaintenanceCost: " + e.getMessage());
        }
    }

    // toString()
    public String toString() {
        try {
            return "Capacity: " + capacity + ", Maintenance Cost: " + maintenanceCost;
        } catch (Exception e) {
            return "Error displaying Facility data";
        }
    }
}