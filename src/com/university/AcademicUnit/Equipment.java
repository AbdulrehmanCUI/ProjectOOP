package com.university.AcademicUnit;

public class Equipment {
    private int equipmentId;
    private String equipmentName;
    private String status;

    public Equipment() {
    }
    public Equipment(int equipmentId, String equipmentName, String status) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.status = status;
    }


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

    public double getOperationalCost() {

    }

    public String toString(){
        return equipmentId + " " + " " + equipmentName + " " + " " + status;
    }
}

