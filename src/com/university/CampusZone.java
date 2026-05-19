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
        try{
            this.zoneName = zoneName;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addFacility(Facility f) {
        try{
            facilities.add(f);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addService(ServiceUnit s) {
        try{
            services.add(s);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void removeFacility(int id) {
        try{
            for(int i = 0; i < facilities.size();i++){
                if(facilities.get(i).getID() == id){
                    facilities.remove(i);
                    return;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void removeService(int id) {
        try {
            for(int i = 0; i < services.size(); i++){
                if(services.get(i).getID() == id){
                    services.remove(i);
                    return;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public double calculateOperationalCost() {
        try{
            double total = 0;

            for (Facility f : facilities) {
                total += f.calculateOperationalCost();
            }
            for (ServiceUnit s : services) {
                total += s.calculateOperationalCost();
            }

            return total;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }




    public String getZoneName() {
        try{
            return zoneName;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    public ArrayList<Facility> getFacilities(){
        try{
            return facilities;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<ServiceUnit> getServices() {
        try{
            return services;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public String toString() {
        try{
            return "Zone: " + zoneName + "\nFacilities: " + facilities.size() + "\nServices: " + services.size() + "\nTotal Cost: " + calculateOperationalCost();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "";
    }
}