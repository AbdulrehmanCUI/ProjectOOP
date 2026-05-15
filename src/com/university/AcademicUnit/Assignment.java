package com.university.AcademicUnit;

public class Assignment {
    private String title;
    private int marks;
    private String deadline;

    public Assignment() {
    }
    public Assignment(String title, int marks, String deadline) {
        this.title = title;
        this.marks = marks;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String toString(){
        return title + " " + " " + marks + " " + " " + deadline;
    }
}
