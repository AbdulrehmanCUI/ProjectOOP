package com.university.Person;

public class Admin{
    private String role;
    private String office;
    private double salary;

    Admin(String name,int age,String id, String role,String office,double salary) {
        this.role = role;
        this.office = office;
        this.salary = salary;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getOffice()
    {
        return office;
    }

    public void setOffice(String office)
    {
        this.office = office;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public String toString(){
        return role + " " + " " + office + " " + " " + salary;
    }
}
