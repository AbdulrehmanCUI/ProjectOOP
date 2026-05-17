package com.university.Person;

public class Teacher {
    private String subject;
    private String department;
    private double salary;

    Teacher(String name,int age,String id,
            String subject,String department,double salary)
    {

        this.subject = subject;
        this.department = department;
        this.salary = salary;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Subject " + subject + ", Department: " + department + ", Salary " + salary; }
}
