package com.university.data;

import com.university.AcademicUnit.Course;
import com.university.Facility.Library;
import com.university.Person.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataStore implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * SINGLETON INSTANCE
     */
    private static DataStore instance;

    /*
     * COLLECTIONS
     */
    private final List<Student> students;

    private final List<Course> courses;

    private final List<Library> libraries;

    /*
     * PRIVATE CONSTRUCTOR
     */
    private DataStore() {

        students = new ArrayList<>();

        courses = new ArrayList<>();

        libraries = new ArrayList<>();
    }

    /*
     * SINGLETON ACCESS
     */
    public static DataStore getInstance() {

        if(instance == null) {

            instance = new DataStore();
        }

        return instance;
    }

    /*
     * STUDENT METHODS
     */

    public void addStudent(Student student) {

        if(student == null) {

            throw new IllegalArgumentException(
                    "Student cannot be null"
            );
        }

        if(!students.contains(student)) {

            students.add(student);
        }
    }

    public void removeStudent(Student student) {

        students.remove(student);
    }

    public List<Student> getStudents() {

        return students;
    }

    /*
     * COURSE METHODS
     */

    public void addCourse(Course course) {

        if(course == null) {

            throw new IllegalArgumentException(
                    "Course cannot be null"
            );
        }

        if(!courses.contains(course)) {

            courses.add(course);
        }
    }

    public void removeCourse(Course course) {

        courses.remove(course);
    }

    public List<Course> getCourses() {

        return courses;
    }

    /*
     * LIBRARY METHODS
     */

    public void addLibrary(Library library) {

        if(library == null) {

            throw new IllegalArgumentException(
                    "Library cannot be null"
            );
        }

        if(!libraries.contains(library)) {

            libraries.add(library);
        }
    }

    public void removeLibrary(Library library) {

        libraries.remove(library);
    }

    public List<Library> getLibraries() {

        return libraries;
    }

    /*
     * CLEAR ALL DATA
     */
    public void clearAll() {

        students.clear();

        courses.clear();

        libraries.clear();
    }

    /*
     * SYSTEM SUMMARY
     */
    @Override
    public String toString() {

        return "Students: "
                + students.size()

                + "\nCourses: "
                + courses.size()

                + "\nLibraries: "
                + libraries.size();
    }
}