package com.university.data;

import com.university.AcademicUnit.Course;
import com.university.AcademicUnit.Department;
import com.university.Facility.Cafeteria;
import com.university.Facility.Hostel;
import com.university.Facility.Library;
import com.university.Person.Admin;
import com.university.Person.Student;
import com.university.Person.Teacher;
import com.university.ServiceUnit.HealthCentre;
import com.university.ServiceUnit.SecurityService;
import com.university.ServiceUnit.TransportService;

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

    private final List<Teacher> teachers;

    private final List<Admin> admins;

    private final List<Course> courses;

    private final List<Department> departments;

    private final List<Library> libraries;

    private final List<Cafeteria> cafeterias;

    private final List<Hostel> hostels;

    private final List<TransportService> transportServices;

    private final List<SecurityService> securityServices;

    private final List<HealthCentre> healthCentres;

    /*
     * PRIVATE CONSTRUCTOR
     */

    private DataStore() {

        students = new ArrayList<>();

        teachers = new ArrayList<>();

        admins = new ArrayList<>();

        courses = new ArrayList<>();

        departments = new ArrayList<>();

        libraries = new ArrayList<>();

        cafeterias = new ArrayList<>();

        hostels = new ArrayList<>();

        transportServices = new ArrayList<>();

        securityServices = new ArrayList<>();

        healthCentres = new ArrayList<>();
    }

    /*
     * SINGLETON ACCESS METHOD
     */

    public static DataStore getInstance() {

        if(instance == null) {

            instance = new DataStore();
        }

        return instance;
    }

    /*
     * LOAD SAVED INSTANCE
     */

    public static void setInstance(DataStore loadedData) {

        if(loadedData != null) {

            instance = loadedData;
        }
    }

    /*
     * GETTERS
     */

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public List<Cafeteria> getCafeterias() {
        return cafeterias;
    }

    public List<Hostel> getHostels() {
        return hostels;
    }

    public List<TransportService> getTransportServices() {
        return transportServices;
    }

    public List<SecurityService> getSecurityServices() {
        return securityServices;
    }

    public List<HealthCentre> getHealthCentres() {
        return healthCentres;
    }

    /*
     * ADD METHODS
     */

    public void addStudent(Student student) {

        if(student != null && !students.contains(student)) {

            students.add(student);
        }
    }

    public void addTeacher(Teacher teacher) {

        if(teacher != null && !teachers.contains(teacher)) {

            teachers.add(teacher);
        }
    }

    public void addAdmin(Admin admin) {

        if(admin != null && !admins.contains(admin)) {

            admins.add(admin);
        }
    }

    public void addCourse(Course course) {

        if(course != null && !courses.contains(course)) {

            courses.add(course);
        }
    }

    public void addDepartment(Department department) {

        if(department != null &&
                !departments.contains(department)) {

            departments.add(department);
        }
    }

    public void addLibrary(Library library) {

        if(library != null && !libraries.contains(library)) {

            libraries.add(library);
        }
    }

    public void addCafeteria(Cafeteria cafeteria) {

        if(cafeteria != null &&
                !cafeterias.contains(cafeteria)) {

            cafeterias.add(cafeteria);
        }
    }

    public void addHostel(Hostel hostel) {

        if(hostel != null && !hostels.contains(hostel)) {

            hostels.add(hostel);
        }
    }

    public void addTransportService(
            TransportService transportService) {

        if(transportService != null &&
                !transportServices.contains(transportService)) {

            transportServices.add(transportService);
        }
    }

    public void addSecurityService(
            SecurityService securityService) {

        if(securityService != null &&
                !securityServices.contains(securityService)) {

            securityServices.add(securityService);
        }
    }

    public void addHealthCentre(
            HealthCentre healthCentre) {

        if(healthCentre != null &&
                !healthCentres.contains(healthCentre)) {

            healthCentres.add(healthCentre);
        }
    }

    /*
     * REMOVE METHODS
     */

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    /*
     * SYSTEM STATISTICS
     */

    public int getTotalStudents() {
        return students.size();
    }

    public int getTotalCourses() {
        return courses.size();
    }

    public int getTotalDepartments() {
        return departments.size();
    }

    public int getTotalFacilities() {

        return libraries.size()
                + cafeterias.size()
                + hostels.size();
    }

    /*
     * CLEAR SYSTEM
     */

    public void clearAllData() {

        students.clear();

        teachers.clear();

        admins.clear();

        courses.clear();

        departments.clear();

        libraries.clear();

        cafeterias.clear();

        hostels.clear();

        transportServices.clear();

        securityServices.clear();

        healthCentres.clear();
    }
}