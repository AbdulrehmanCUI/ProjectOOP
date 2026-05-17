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

        try{

            if(courseCode == null || courseCode.isEmpty()){
                throw new Exception("Course code cannot be empty");
            }

            if(courseName == null || courseName.isEmpty()){
                throw new Exception("Course name cannot be empty");
            }

            if(creditHours <= 0){
                throw new Exception("Invalid credit hours");
            }

            this.courseCode = courseCode;
            this.courseName = courseName;
            this.creditHours = creditHours;

            totalCourse++;
        }

        catch(Exception e){

            System.out.println(e.getMessage());

            this.courseCode = "Unknown";
            this.courseName = "Unknown";
            this.creditHours = 0;
        }
    }


    // Getters & Setters

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public int getCreditHours() {
        return creditHours;
    }


    public void setCourseCode(String courseCode) {

        try{

            if(courseCode == null || courseCode.isEmpty()){
                throw new Exception("Invalid course code");
            }

            this.courseCode = courseCode;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public void setCourseName(String courseName) {

        try{

            if(courseName == null || courseName.isEmpty()){
                throw new Exception("Invalid course name");
            }

            this.courseName = courseName;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public void setCreditHours(int creditHours) {

        try{

            if(creditHours <= 0){
                throw new Exception("Invalid credit hours");
            }

            this.creditHours = creditHours;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    // Overridden toString()

    @Override
    public String toString(){

        return "Course code "
                + courseCode + " " + "Name " + courseName + " " + "Credit hours:" + creditHours;
    }



    public String generateSchedule(
            ArrayList<Classroom> classrooms) {

        try{

            if(classrooms == null || classrooms.isEmpty()){

                throw new Exception("No classroom available");
            }


            for(Classroom c : classrooms){

                if(c != null && c.isAvailable()){

                    this.classroom = c;
                    return "Scheduled";
                }
            }

        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }

        return "No Slot Available";
    }



    @Override
    public String generateSchedule() {

        try{

            if(teacherName == null || day == null || time == null){
                throw new Exception("Schedule data missing");
            }

        }

        catch(Exception e){

            return e.getMessage();
        }


        String schedule = "Course: " + courseName + "\n" + "Teacher: " + teacherName + "\n" + "Day: " + day + "\n" + "Time: " + time + "\n" + "Total Students: " + students.size();

        return schedule;
    }
}