package com.university.Person;

public class Admin {

    private String role;
    private String office;
    private double salary;

    // Constructor
    Admin(String name, int age, String id, String role, String office, double salary) {

        try {

            if(role == null || role.trim().isEmpty()) {
                throw new Exception("Role cannot be empty");
            }

            if(office == null || office.trim().isEmpty()) {
                throw new Exception("Office cannot be empty");
            }

            if(salary < 0) {
                throw new Exception("Salary cannot be negative");
            }

            this.role = role;
            this.office = office;
            this.salary = salary;
        }

        catch(Exception e) {
            System.out.println("Constructor Error: " + e.getMessage());
        }
    }


    // Getter & Setter

    public String getRole() {
        return role;
    }

    public void setRole(String role) {

        try {

            if(role == null || role.trim().isEmpty()) {
                throw new Exception("Role cannot be empty");
            }

            this.role = role;
        }

        catch(Exception e) {
            System.out.println("Error in setRole: " + e.getMessage());
        }
    }


    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {

        try {

            if(office == null || office.trim().isEmpty()) {
                throw new Exception("Office cannot be empty");
            }

            this.office = office;
        }

        catch(Exception e) {
            System.out.println("Error in setOffice: "
                    + e.getMessage());
        }
    }


    public double getSalary() {
        return salary;
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

    // toString()
    public String toString() {
        return role + " " + office + " " + salary;
    }
}