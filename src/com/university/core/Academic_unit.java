package com.university.core;



public abstract class Academic_unit extends Campus_entity {

        // Attributes
        protected int establishedYear;
        protected String head;

        // Abstract Method calculateOperationalCost()
        protected abstract double calculateOperationalCost();

        // toString method

        public String toString(){
            return establishedYear + " " + " " + head;
    }
    }
