package com.university.core;


import com.university.AcademicUnit.Equipment;

import java.util.ArrayList;

public abstract class Academic_unit extends Campus_entity {

        // Attributes
        protected int establishedYear;
        protected String head;
        ArrayList<Equipment> equipments = new ArrayList<>();

        // Abstract Method calculateOperationalCost()
        protected abstract double calculateOperationalCost();

        // toString method

        public String toString(){
            return establishedYear + " " + " " + head;
    }
    }
