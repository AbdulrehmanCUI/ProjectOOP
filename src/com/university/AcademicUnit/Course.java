package com.university.AcademicUnit;

import com.university.Interfaces.Schedulable;
import com.university.Person.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Schedulable, Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * ATTRIBUTES
     */
    private String courseCode;

    private String courseName;

    private int creditHours;

    private Classroom classroom;

    private String teacherName;

    private String day;

    private String time;

    /*
     * PROPER ENCAPSULATION
     */
    private final List<Student> students =
            new ArrayList<>();

    /*
     * STATIC MEMBER
     */
    protected static int totalCourse = 0;

    /*
     * DEFAULT CONSTRUCTOR
     */
    public Course() {

        totalCourse++;
    }

    /*
     * MAIN CONSTRUCTOR
     */
    public Course(
            String courseCode,
            String courseName,
            int creditHours) {

        try {

            if(courseCode == null ||
                    courseCode.trim().isEmpty()) {

                throw new Exception(
                        "Course code cannot be empty"
                );
            }

            if(courseName == null ||
                    courseName.trim().isEmpty()) {

                throw new Exception(
                        "Course name cannot be empty"
                );
            }

            if(creditHours <= 0) {

                throw new Exception(
                        "Invalid credit hours"
                );
            }

            this.courseCode = courseCode;

            this.courseName = courseName;

            this.creditHours = creditHours;

            totalCourse++;

        }

        catch(Exception e) {

            System.out.println(e.getMessage());

            this.courseCode = "UNKNOWN";

            this.courseName = "UNKNOWN";

            this.creditHours = 0;
        }
    }

    /*
     * CRUD CONSTRUCTOR
     */
    public Course(int courseId, String courseName, String instructor, String schedule) {

        this.courseCode = String.valueOf(courseId);

        this.courseName = courseName;

        this.teacherName = instructor;
        if(schedule != null && schedule.contains("-")) {

            String[] parts = schedule.split("-");

            if(parts.length == 2) {
                this.day = parts[0];
                this.time = parts[1];
            }
        }
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public List<Student> getStudents() {

        return students;
    }



    public int getCourseId() {

        try {

            return Integer.parseInt(courseCode);

        }

        catch(Exception e) {

            return 0;
        }
    }

    public String getInstructor() {

        return teacherName;
    }

    public String getSchedule() {

        return day + "-" + time;
    }

    /*
     * SETTERS
     */

    public void setCourseCode(
            String courseCode) {

        try {

            if(courseCode == null ||
                    courseCode.trim().isEmpty()) {

                throw new Exception(
                        "Invalid course code"
                );
            }

            this.courseCode = courseCode;
        }

        catch(Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    public void setCourseName(
            String courseName) {

        try {

            if(courseName == null ||
                    courseName.trim().isEmpty()) {

                throw new Exception(
                        "Invalid course name"
                );
            }

            this.courseName = courseName;
        }

        catch(Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    public void setCreditHours(
            int creditHours) {

        try {

            if(creditHours <= 0) {

                throw new Exception(
                        "Invalid credit hours"
                );
            }

            this.creditHours = creditHours;
        }

        catch(Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    public void setTeacherName(
            String teacherName) {

        this.teacherName = teacherName;
    }

    public void setDay(String day) {

        this.day = day;
    }

    public void setTime(String time) {

        this.time = time;
    }

    public void setClassroom(
            Classroom classroom) {

        this.classroom = classroom;
    }

    /*
     * STUDENT MANAGEMENT
     */

    public void addStudent(
            Student student) {

        if(student != null &&
                !students.contains(student)) {

            students.add(student);
        }
    }

    public void removeStudent(
            Student student) {

        students.remove(student);
    }

    /*
     * SCHEDULING
     */

    public String generateSchedule(
            ArrayList<Classroom> classrooms) {

        try {

            if(classrooms == null ||
                    classrooms.isEmpty()) {

                throw new Exception(
                        "No classrooms available"
                );
            }

            for(Classroom c : classrooms) {

                if(c != null &&
                        c.isAvailable()) {

                    this.classroom = c;

                    return "Scheduled in "
                            + c.getRoomNumber();
                }
            }

        }

        catch(Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        return "No Slot Available";
    }

    /*
     * INTERFACE METHOD
     */

    @Override
    public String generateSchedule() {

        try {

            if(teacherName == null || day == null || time == null) {
                throw new Exception(
                        "Schedule data missing"
                );
            }
        }
        catch(Exception e) {
            return e.getMessage();
        }




        return "Course: " + courseName +
                "\nTeacher: " + teacherName +
                "\nDay: " + day +
                "\nTime: " + time +
                "\nStudents: " + students.size();
    }

    public boolean conflictsWith(Course other) {

        if(other == null) {
            return false;
        }


        if(this.classroom == null || other.classroom == null) {
            return false;
        }


        boolean sameRoom = this.classroom.equals(other.classroom);

        boolean sameDay = this.day.equals(other.day);

        boolean sameTime =
                this.time.equals(other.time);

        return sameRoom && sameDay && sameTime;
    }

    /*
     * STATIC METHOD
     */

    public static int getTotalCourse() {

        return totalCourse;
    }

    /*
     * toString()
     */

    @Override
    public String toString() {

        return "Course Code: "
                + courseCode
                + " | Name: "
                + courseName
                + " | Credit Hours: "
                + creditHours;
    }
}