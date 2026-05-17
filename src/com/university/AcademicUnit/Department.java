package com.university.AcademicUnit;

import com.university.Interfaces.Reportable;
import com.university.core.AcademicUnit;
import com.university.Person.Student;

import java.io.Serializable;
import java.util.ArrayList;

public class Department extends AcademicUnit implements Reportable, Serializable {

    private String deptName;
    private String hodName;
    private int totalStudents;

    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Assignment> assignments = new ArrayList<>();


    public Department() {}

    public Department(String deptName, String hodName, int totalStudents) {

        try{

            if(deptName == null || deptName.isEmpty()){
                throw new Exception("Department name cannot be empty");
            }

            if(hodName == null || hodName.isEmpty()){
                throw new Exception("HOD name cannot be empty");
            }

            if(totalStudents < 0){
                throw new Exception("Invalid student count");
            }

            this.deptName = deptName;
            this.hodName = hodName;
            this.totalStudents = totalStudents;
        }

        catch(Exception e){

            System.out.println(e.getMessage());

            this.deptName = "Unknown";
            this.hodName = "Unknown";
            this.totalStudents = 0;
        }
    }


    // Getters

    public String getDeptName() {
        return deptName;
    }

    public String getHodName() {
        return hodName;
    }

    public int getTotalStudents() {
        return totalStudents;
    }


    // Setters

    public void setDeptName(String deptName) {

        try{

            if(deptName == null || deptName.isEmpty()){
                throw new Exception("Invalid department name");
            }

            this.deptName = deptName;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public void setHodName(String hodName) {

        try{

            if(hodName == null || hodName.isEmpty()){
                throw new Exception("Invalid HOD name");
            }

            this.hodName = hodName;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public void setTotalStudents(int totalStudents) {

        try{

            if(totalStudents < 0){
                throw new Exception("Student count cannot be negative");
            }

            this.totalStudents = totalStudents;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    // calculateOperationalCost
    @Override
    public double calculateOperationalCost() {
        return totalStudents * 500;
    }


    @Override
    public String generateReport() {
        return "Department Students: " + totalStudents;
    }


    // toString method
    @Override
    public String toString() {
        return deptName + " " + hodName + " " + totalStudents;
    }


    // Add Course
    public void addCourse(Course c) {

        try{

            if(c == null){
                throw new Exception("Course cannot be null");
            }

            courses.add(c);
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    // Handle Classroom Availability
    public void handleClassroomUnavailable(Classroom classroom) {

        try{

            if(classroom == null){
                throw new Exception("Invalid classroom");
            }

            System.out.println("Classroom " + classroom.getRoomNo() + " is now unavailable. Rescheduling affected courses...");

            classroom.markUnavailable();

            for (Course course : courses) {

                if (course.getClassroom() == classroom) {

                    System.out.println("Rescheduling: " + course.getCourseName());

                    String result = course.generateSchedule();

                    if (result.equals("No Slot Available")) {

                        System.out.println("WARNING: Could not reschedule " + course.getCourseName());
                    }
                }
            }

        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }
}