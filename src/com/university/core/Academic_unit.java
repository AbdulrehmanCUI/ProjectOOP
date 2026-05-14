package com.university.core;

public abstract class Academic_unit extends Campus_entity {
        Department dep;
        Classroom classes;
        Lab lab;

        protected abstract double calculateOperationalCost();
    }
