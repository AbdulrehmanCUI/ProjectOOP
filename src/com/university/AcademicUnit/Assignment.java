package com.university.AcademicUnit;

import java.util.InputMismatchException;

public class Assignment {


    // Attributes
    private String title;
    private int marks;
    private String deadline;

    // Constructors
    public Assignment() {
    }

    public Assignment(String title, int marks, String deadline) {

        try{

            if(title == null || title.isEmpty()){
                throw new Exception("Title cannot be empty");
            }

            if(marks < 0){
                throw new Exception("Marks cannot be negative");
            }

            this.title = title;
            this.marks = marks;
            this.deadline = deadline;
        }

        catch(Exception e){

            System.out.println(e.getMessage());

            this.title = "Unknown";
            this.marks = 0;
            this.deadline = "Not Set";
        }
    }


    // Getters & Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        try{

            if(title == null || title.isEmpty()){
                throw new Exception("Invalid title");
            }

            this.title = title;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {

        try{

            if(marks < 0){
                throw new Exception("Marks cannot be negative");
            }

            this.marks = marks;
        }

        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }


    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }


    @Override
    public String toString(){

        return "Title " + title + " " + "Marks: " + marks + " " + "Deadline: " + deadline;
    }
}




