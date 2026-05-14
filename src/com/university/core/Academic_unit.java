package com.university.core;

import com.university.AcademicUnit.Equipment;

public abstract class Academic_unit extends Campus_entity {
        protected int establishedYear;
        protected String head;


        protected abstract double calculateOperationalCost();
    }
