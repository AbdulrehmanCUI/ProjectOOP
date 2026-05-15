package com.university.core;



public abstract class Academic_unit extends Campus_entity {
        protected int establishedYear;
        protected String head;


        protected abstract double calculateOperationalCost();

        public String toString(){
            return establishedYear + " " + " " + head;
    }
    }
