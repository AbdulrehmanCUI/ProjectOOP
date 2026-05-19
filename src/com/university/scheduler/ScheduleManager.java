package com.university.scheduler;

import com.university.AcademicUnit.Course;

import java.util.List;

public class ScheduleManager {

    public static boolean hasConflict(
            Course newCourse,
            List<Course> existingCourses) {

        for(Course course : existingCourses) {

            boolean sameClassroom = course.getClassroom().equals(newCourse.getClassroom());
            boolean sameTime = course.getSchedule().equals(newCourse.getSchedule());

            if(sameClassroom && sameTime) {
                return true;
            }
        }
        return false;
    }
}
