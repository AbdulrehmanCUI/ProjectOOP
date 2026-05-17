package com.university.core;


import com.university.AcademicUnit.Equipment;
import java.util.ArrayList;


public abstract class AcademicUnit extends CampusEntity {

        // Attributes
        protected int establishedYear;
        protected String head;
        ArrayList<Equipment> equipments = new ArrayList<>();
        protected int numberOfStudents;

        // Constructor
        public AcademicUnit(){}
        public AcademicUnit(int entityID, String name, String location, int numberOfStudents){
            super(entityID, name, location);
            this.numberOfStudents = numberOfStudents;
        }


        // Method calculateOperationalCost()
        protected double calculateOperationalCost(){
            double cost = 0;
            for(Equipment e : equipments){
                cost += e.getOperationalCost();
            }

        }

        catch(NullPointerException e){

            System.out.println(e.getMessage());
        }

        return cost + (numberOfStudents * 5);
    }
    
    @Override
    public String toString(){

        return establishedYear + " " + head;
    }

    }
