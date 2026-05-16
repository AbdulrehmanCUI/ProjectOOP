package com.university.core;


import com.university.AcademicUnit.Equipment;
import java.util.ArrayList;


public abstract class Academic_unit extends Campus_entity {

        // Attributes
        protected int establishedYear;
        protected String head;
        ArrayList<Equipment> equipments = new ArrayList<>();
        protected int numberOfStudents;

        // Constructor
        public Academic_unit(){}
        public Academic_unit(int entityID, String name, String location,int numberOfStudents){
            super(entityID, name, location);
            this.numberOfStudents = numberOfStudents;
        }


        // Method calculateOperationalCost()
        protected double calculateOperationalCost(){
            double cost = 0;
            for(Equipment e : equipments){
                cost += e.getOperationalCost();
            }
            return cost + (numberOfStudents * 5);
        }

        // toString method
        public String toString(){
            return establishedYear + " " + " " + head;
    }


    }
