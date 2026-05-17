package com.university.AcademicUnit;

import java.io.Serializable;

public class Lab implements Serializable {

    // Attributes
    private String labName;
    private int totalComputers;
    private String supervisor;


    public Lab() {
    }
    public Lab(String labName, int totalComputers, String supervisor) {
        this.labName = labName;
        this.totalComputers = totalComputers;
        this.supervisor = supervisor;
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
        this.labName = labName;
    }
    public void setTotalComputers(int totalComputers) {
        this.totalComputers = totalComputers;
    }
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }


    // toString method
    @Override
    public String toString(){
        return labName + " " + " " + totalComputers + " " + " " + supervisor;
    }
}