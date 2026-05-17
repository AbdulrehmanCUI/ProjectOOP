package com.university.core;


import com.university.AcademicUnit.Equipment;
import java.util.ArrayList;

public abstract class AcademicUnit extends CampusEntity {

    protected int establishedYear;
    protected String head;
    ArrayList<Equipment> equipments = new ArrayList<>();
    protected int numberOfStudents;

    public AcademicUnit() {
    }

    public AcademicUnit(int entityID, String name,
                        String location, int numberOfStudents) {

        super(entityID, name, location);

        try {
            if (numberOfStudents < 0) {
                System.out.println("Number of students cannot be negative");
            }
            this.numberOfStudents = numberOfStudents;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.numberOfStudents = 0;
        }
    }

    protected double calculateOperationalCost() {
        double cost = 0;
        try {
            for (Equipment e : equipments) {
                if (e == null) {
                    System.out.println("Equipment object is missing");
                }
                cost += e.getOperationalCost();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return cost + (numberOfStudents * 5);
    }


    @Override
    public String toString() {

        return establishedYear + " " + head;
    }
}