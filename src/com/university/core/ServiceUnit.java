package com.university.core;

public abstract class ServiceUnit extends CampusEntity {

    // Attributes
    protected int serviceHours;
    protected int staffCount;

    // Constructor with exception handling
    public ServiceUnit(int entityID, String name, String location, int serviceHours, int staffCount) {

        super(entityID, name, location);

        try {
            if (serviceHours <= 0) {
                throw new Exception("Service hours must be greater than 0");
            }

            if (staffCount <= 0) {
                throw new Exception("Staff count must be greater than 0");
            }

            this.serviceHours = serviceHours;
            this.staffCount = staffCount;

        } catch (Exception e) {
            System.out.println("Constructor Error: " + e.getMessage());
        }
    }

    // Method
    public double calculateOperationalCost() {
        try {
            if (serviceHours < 0 || staffCount < 0) {
                throw new Exception("Invalid values for calculation");
            }

            return staffCount * serviceHours * 20;

        } catch (Exception e) {
            System.out.println("Error in calculateOperationalCost: " + e.getMessage());
            return 0;
        }
    }

    // Getters
    public int getServiceHours() {
        return serviceHours;
    }

    public int getStaffCount() {
        return staffCount;
    }

    // Setters
    public void setServiceHours(int serviceHours) {
        try {
            if (serviceHours <= 0) {
                throw new Exception("Service hours must be greater than 0");
            }

            this.serviceHours = serviceHours;

        } catch (Exception e) {
            System.out.println("Error in setServiceHours: " + e.getMessage());
        }
    }

    public void setStaffCount(int staffCount) {
        try {
            if (staffCount <= 0) {
                throw new Exception("Staff count must be greater than 0");
            }

            this.staffCount = staffCount;

        } catch (Exception e) {
            System.out.println("Error in setStaffCount: " + e.getMessage());
        }
    }

    // toString method
    public String toString() {
        return serviceHours + " " + staffCount;
    }
}
