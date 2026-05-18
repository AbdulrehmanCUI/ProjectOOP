package com.university.data;

import com.university.AcademicUnit.Course;
import com.university.Facility.Library;
import com.university.Person.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataStore implements Serializable {

    private static final long serialVersionUID = 1L;

    private static DataStore instance;

    private final List<Student> students;
    private final List<Course> courses;
    private final List<Library> libraries;

    private DataStore() {

        students = new ArrayList<>();
        courses = new ArrayList<>();
        libraries = new ArrayList<>();
    }

    public static DataStore getInstance() {

        if(instance == null) {
            instance = new DataStore();
        }

        return instance;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Library> getLibraries() {
        return libraries;
    }
}
