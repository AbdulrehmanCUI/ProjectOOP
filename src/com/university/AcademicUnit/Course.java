package com.university.AcademicUnit;

public class Course {

    // Attributes
    private String courseCode;
    private String courseName;
    private int creditHours;
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
        return courseCode + " " + " " + courseName + " " + " " + creditHours;
    }
}