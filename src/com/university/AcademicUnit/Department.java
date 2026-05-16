package com.university.AcademicUnit;

import com.university.Interfaces.Reportable;
import com.university.core.AcademicUnit;
import com.university.Person.Student;

import java.util.ArrayList;

public class Department extends AcademicUnit implements Reportable {

    private String deptName;
    private String hodName;
    private int totalStudents;

    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Assignment> assignments = new ArrayList<>();

    public Department() {}

    public Department(String deptName, String hodName, int totalStudents) {
        this.deptName = deptName;
        this.hodName = hodName;
        this.totalStudents = totalStudents;
    }

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

    // calculateOperationalCost
    @Override
    public double calculateOperationalCost() {
        return totalStudents * 500;
    }


    // Implemented generateReport from Reportable
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
        courses.add(c);
    }


    // Handle Classroom Availability
    public void handleClassroomUnavailable(Classroom classroom) {

        if (classroom == null) {
            System.out.println("Invalid classroom");
            return;
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
}


