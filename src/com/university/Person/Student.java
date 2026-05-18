package com.university.Person;

import com.university.Interfaces.Identifiable;

import java.io.Serializable;

public class Student implements Identifiable, Serializable {

    protected static int totalStudent = 0;
    protected int id;
    protected String name;
    protected String department;

    // Constructor
    public Student(int id, String name, String department) {

        try {

            if(id <= 0) {
                throw new Exception("ID must be greater than 0");
            }

            if(name == null || name.trim().isEmpty()) {
                throw new Exception("Name cannot be empty");
            }

            if(department == null || department.trim().isEmpty()) {
                throw new Exception("Department cannot be empty");
            }

            this.id = id;
            this.name = name;
            this.department = department;

            totalStudent++;

        }

        catch(Exception e) {
            System.out.println("Constructor Error: " + e.getMessage());
        }
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public static int getTotalStudent() {
        return totalStudent;
    }


    // Setters with
    public void setName(String name) {

        try {

            if(name == null || name.trim().isEmpty()) {
                throw new Exception("Name cannot be empty");
            }

            this.name = name;
        }

        catch(Exception e) {
            System.out.println("Error in setName: " + e.getMessage());
        }
    }

    public void setDepartment(String department) {

        try {

            if(department == null || department.trim().isEmpty()) {
                throw new Exception("Department cannot be empty");
            }

            this.department = department;
        }

        catch(Exception e) {
            System.out.println("Error in setDepartment: " + e.getMessage());
        }
    }


    @Override
    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Department: " + department;
    }
}


