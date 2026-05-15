package com.university.AcademicUnit;

public class Equipment {

    // Attributes
    private int equipmentId;
    private String equipmentName;
    private String status;
    private int operationalCost;

    // Constructors
    public Equipment() {
    }
    public Equipment(int equipmentId, String equipmentName, String status, int operationalCost) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.status = status;
        this.operationalCost = operationalCost;
    }


    // Getters & Setters
    public int getEquipmentId() {
        return equipmentId;
    }
    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }
    public String getEquipmentName() {
        return equipmentName;
    }
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setOperationalCost(int operationalCost) {
        this.operationalCost = operationalCost;
    }


    // getOperationalCost
    public int getOperationalCost(){
        return operationalCost;
    }


    // toString method
    public String toString(){
        return equipmentId + " " + " " + equipmentName + " " + " " + status;
    }
}