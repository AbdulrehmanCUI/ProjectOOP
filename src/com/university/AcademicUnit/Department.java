package com.university.AcademicUnit;

import com.university.Interfaces.Reportable;
import com.university.core.Academic_unit;
import com.university.Person.Student;

import java.util.ArrayList;

public class Department extends Academic_unit implements Reportable {
    private String deptName;
    private String hodName;
    private int totalStudents;
    ArrayList<Course> courses;
    ArrayList<Student> students;
    ArrayList<Assignment> assignments;

    public Department() {
    }
    public Department(String deptName, String hodName, int totalStudents) {
        this.deptName = deptName;
        this.hodName = hodName;
        this.totalStudents = totalStudents;
    }


    // Getter and Setter
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {

        this.deptName = deptName;
    }
    public String getHodName() {
        return hodName;
    }
    public void setHodName(String hodName) {
        this.hodName = hodName;
    }
    public int getTotalStudents() {
        return totalStudents;
    }
    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }


    public double calculateOperationalCost(){
        return totalStudents * 500;
    }

    public String generateReport(){
        return "Department Students: " + totalStudents;
    }

    public String toString(){
        return deptName+ " " + " " + hodName + " " + " " + totalStudents;
    }
}
