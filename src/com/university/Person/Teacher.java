package com.university.Person;

import java.io.Serializable;

public class Teacher implements Serializable {

    private String subject;
    private String department;
    private double salary;

    // Constructor
    Teacher(String name, int age, String id,
            String subject, String department, double salary) {

        try {

            if(subject == null || subject.trim().isEmpty()) {
                throw new Exception("Subject cannot be empty");
            }

            if(department == null || department.trim().isEmpty()) {
                throw new Exception("Department cannot be empty");
            }

            if(salary < 0) {
                throw new Exception("Salary cannot be negative");
            }

            this.subject = subject;
            this.department = department;
            this.salary = salary;
        }

        catch(Exception e) {
            System.out.println("Constructor Error: " + e.getMessage());
        }
    }


    // Getter

    public String getSubject() {
        return subject;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }


    // Setters

    public void setSubject(String subject) {

        try {

            if(subject == null || subject.trim().isEmpty()) {
                throw new Exception("Subject cannot be empty");
            }

            this.subject = subject;
        }

        catch(Exception e) {
            System.out.println("Error in setSubject: " + e.getMessage());
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

    public void setSalary(double salary) {

        try {

            if(salary < 0) {
                throw new Exception("Salary cannot be negative");
            }

            this.salary = salary;
        }

        catch(Exception e) {
            System.out.println("Error in setSalary: " + e.getMessage());
        }
    }


    @Override
    public String toString() {
        return "Subject: " + subject + ", Department: " + department + ", Salary: " + salary;
    }
}