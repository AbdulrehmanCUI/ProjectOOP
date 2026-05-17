package com.university;

import com.university.core.Facility;
import com.university.core.ServiceUnit;

import java.io.Serializable;
import java.util.ArrayList;

public class CampusZone implements Serializable {

    private String zoneName;
    private  ArrayList<Facility> facilities = new ArrayList<>();
    private ArrayList<ServiceUnit> services = new ArrayList<>();

    public CampusZone(String zoneName) {
        this.zoneName = zoneName;
    }

    public void addFacility(Facility f) {
        facilities.add(f);
    }

    public void addService(ServiceUnit s) {
        services.add(s);
    }

    public void removeFacility(int id) {
        for(int i = 0; i < facilities.size();i++){
            if(facilities.get(i).getID() == id){
                facilities.remove(i);
                return;
            }
        }
    }

    public void removeService(int id) {
        for(int i = 0; i < services.size(); i++){
            if(services.get(i).getID() == id){
                services.remove(i);
                return;
            }
        }
    }

    public double calculateOperationalCost() {
        double total = 0;

        for (Facility f : facilities) {
            total += f.calculateOperationalCost();
        }

        for (ServiceUnit s : services) {
            total += s.calculateOperationalCost();
        }
        return total;
    }


    public String getZoneName() {
        return zoneName;
    }

    public ArrayList<Facility> getFacilities() {
        return facilities;
    }

    public ArrayList<ServiceUnit> getServices() {
        return services;
    }

    @Override
    public String toString() {
        return "Zone: " + zoneName + "\nFacilities: " + facilities.size() + "\nServices: " + services.size() + "\nTotal Cost: " + calculateOperationalCost();
    }
}