package com.university.AcademicUnit;

public class Lab {
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


    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public int getTotalComputers() {
        return totalComputers;
    }

    public void setTotalComputers(int totalComputers) {
        this.totalComputers = totalComputers;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }


    public String toString(){
        return labName + " " + " " + totalComputers + " " + " " + supervisor;
    }
}
