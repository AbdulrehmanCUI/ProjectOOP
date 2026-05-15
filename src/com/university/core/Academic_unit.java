package com.university.core;


import com.university.AcademicUnit.Equipment;

import java.util.ArrayList;

public abstract class Academic_unit extends Campus_entity {

        // Attributes
        protected int establishedYear;
        protected String head;
        ArrayList<Equipment> equipments = new ArrayList<>();
        protected int numberOfStudents;

        // Abstract Method calculateOperationalCost()
        protected abstract double calculateOperationalCost();

        public Academic_unit(int entityID, String name, String location,int numberOfStudents){
            super(entityID, name, location);
            this.numberOfStudents = numberOfStudents;
        }

        // toString method
        public String toString(){
            return establishedYear + " " + " " + head;
    }
    }
