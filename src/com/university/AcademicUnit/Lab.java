package com.university.AcademicUnit;

import java.io.Serial;
import java.io.Serializable;

public class Lab implements Serializable {

    // Attributes
    private String labName;
    private int totalComputers;
    private String supervisor;


    // Constructors
    public Lab() {
    }

    public Lab(String labName, int totalComputers, String supervisor) {

        try{

            if(labName == null || labName.isEmpty()){

                throw new Exception("Lab name cannot be empty");
            }

            if(totalComputers < 0){

                throw new Exception("Invalid computer count");
            }

            if(supervisor == null || supervisor.isEmpty()){

                throw new Exception("Supervisor name missing");
            }

            this.labName = labName;
            this.totalComputers = totalComputers;
            this.supervisor = supervisor;
        }

        catch(Exception e){

            System.out.println(e.getMessage());

            this.labName = "Unknown";
            this.totalComputers = 0;
            this.supervisor = "Not Assigned";
        }
    }



    // Getters & Setters

    public String getLabName() {
        return labName;
    }

    public int getTotalComputers() {
        return totalComputers;
    }

    public String getSupervisor() {
        return supervisor;
    }


    public void setLabName(String labName) {

        try{

            if(labName == null || labName.isEmpty()){

                throw new Exception("Invalid lab name");
            }

            this.labName = labName;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public void setTotalComputers(
            int totalComputers) {

        try{

            if(totalComputers < 0){

                throw new Exception("Invalid computer count");
            }

            this.totalComputers = totalComputers;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public void setSupervisor(
            String supervisor) {

        try{

            if(supervisor == null || supervisor.isEmpty()){

                throw new Exception("Invalid supervisor");
            }

            this.supervisor = supervisor;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }



    // toString method
    @Override
    public String toString(){
        return labName + " " + totalComputers + " " + supervisor;
    }
}