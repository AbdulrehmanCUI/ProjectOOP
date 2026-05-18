package com.university.AcademicUnit;

import java.io.Serializable;

public class Equipment implements Serializable {

    // Attributes
    private int equipmentId;
    private String equipmentName;
    private String status;
    private int operationalCost;


    // Constructors
    public Equipment() {
    }

    public Equipment(int equipmentId, String equipmentName, String status, int operationalCost) {

        try{

            if(equipmentId <= 0){
                throw new Exception("Invalid equipment ID");
            }

            if(equipmentName == null || equipmentName.isEmpty()){

                throw new Exception("Equipment name cannot be empty");
            }

            if(status == null || status.isEmpty()){

                throw new Exception("Status cannot be empty");
            }

            if(operationalCost < 0){

                throw new Exception("Invalid operational cost");
            }


            this.equipmentId = equipmentId;
            this.equipmentName = equipmentName;
            this.status = status;
            this.operationalCost = operationalCost;
        }

        catch(Exception e){

            System.out.println(e.getMessage());

            this.equipmentId = 0;
            this.equipmentName = "Unknown";
            this.status = "Unavailable";
            this.operationalCost = 0;
        }
    }



    // Getters & Setters

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {

        try{

            if(equipmentId <= 0){
                throw new Exception("Invalid ID");
            }

            this.equipmentId = equipmentId;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {

        try{

            if(equipmentName == null || equipmentName.isEmpty()){

                throw new Exception("Invalid equipment name");
            }

            this.equipmentName = equipmentName;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {

        try{

            if(status == null || status.isEmpty()){

                throw new Exception("Invalid status");
            }

            this.status = status;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public void setOperationalCost(int operationalCost) {

        try{

            if(operationalCost < 0){
                throw new Exception("Invalid cost");
            }

            this.operationalCost = operationalCost;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }

    // getOperationalCost

    public int getOperationalCost(){

        return operationalCost;
    }

    // toString method

    public String toString(){

        return equipmentId + " " + equipmentName + " " + status;
    }
}