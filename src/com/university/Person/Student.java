package com.university.Person;

import com.university.Interfaces.Identifiable;

import java.io.Serializable;

public class Student implements Identifiable, Serializable {
    protected static int totalStudent = 0;
    protected int id;
    protected String name;
    protected String department;

    public Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
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


    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public int getID() {
        return id;
    }
    @Override
    public String toString() {
        return "Name " + name + ", ID: " + id + ", Department: " + department; }
}

}