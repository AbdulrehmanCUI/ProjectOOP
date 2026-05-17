package com.university.AcademicUnit;
import com.university.Interfaces.Schedulable;
import com.university.Person.Student;

import java.io.Serializable;
import java.util.ArrayList;


public class Course implements Schedulable, Serializable {

    // Attributes
    private String courseCode;
    private String courseName;
    private int creditHours;
    private Classroom classroom;
    private String teacherName;
    private String day;
    private String time;
    private ArrayList<Student> students = new ArrayList<>();
    protected static int totalCourse = 0;

    // Constructors
    public Course (){
    }
    public Course(String courseCode, String courseName, int creditHours) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        totalCourse++;
    }

    // Getters & Setters
    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }


    // Overridden toString()
    @Override
    public String toString(){
        return "Course code " +courseCode + " " + "Name" + courseName + " " + "Credit hours:" + creditHours;
    }

    public String generateSchedule(ArrayList<Classroom> classrooms) {

        if (classrooms == null || classrooms.isEmpty()) {
            return "No Slot Available";
        }

        for (Classroom c : classrooms) {

            if (c != null && c.isAvailable()) {

                this.classroom = c;

                // optional: reserve slot if you use slot tracking
                // c.addOccupiedSlot("ASSIGNED");

                return "Scheduled";
            }
        }

        return "No Slot Available";
    }

    @Override
    public void generateSchedule() {
        
        if(classroom != null && !classroom.isAvailable()) {

            System.out.println("Schedule conflict detected!");

            day = "Tuesday";
            time = "11:00 AM";

            System.out.println("Schedule updated automatically.");
        }

        String schedule = "Course: " + courseName + "\n"
                + "Teacher: " + teacherName + "\n"
                + "Classroom: " + classroom + "\n"
                + "Day: " + day + "\n"
                + "Time: " + time + "\n"
                + "Total Students: " + students.size();

        System.out.println(schedule);
    }
}