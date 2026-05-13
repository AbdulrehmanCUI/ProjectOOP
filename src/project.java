abstract class CampusEntity{
    protected int entityID ;
    protected String name;
    protected String location;

    
    public CampusEntity(){
    }

    public CampusEntity(int entityID, String name, String location){
        this.entityID = entityID;
        this.name = name;
        this.location = location;
    }

    abstract void calculateOperaƟonalCost();

}

class AcademicUnit extends CampusEntity{

    Department dep;
    Classroom classes;
    Lab lab;

    void calculateOperaƟonalCost(){
        System.out.println("based on number of students and equipment");
// number of student x cost of equipments
    }
}

// Department in academic unit   
class Department{
    Course[] courses;
    private String name;
    private String id;
    
public Department() {
    }

public Department(Course[] courses, String name, String id) {
    this.courses = courses;
    this.name = name;
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}


}
class Course {
    Student stu;
    Assignment[] assignments;
}
class Student{
    private int studentid;
    private String sname;
    static int numofstudents = 0;
    public Student() {
        numofstudents++;
    }
    public Student(int studentid, String sname) {
        this.studentid = studentid;
        this.sname = sname;
        numofstudents++;
    }
    public int getStudentid() {
        return studentid;
    }
    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }

    
}
class Assignment{
    private String issuedate;
    private String duedate;
    private int marks;
    public Assignment() {
    }
    public Assignment(String issuedate, String duedate, int marks) {
        this.issuedate = issuedate;
        this.duedate = duedate;
        this.marks = marks;
    }
    public String getIssuedate() {
        return issuedate;
    }
    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }
    public String getDuedate() {
        return duedate;
    }
    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void display(){
        System.out.println("Issue date" + issuedate);
        System.out.println("Due date "+ duedate);
        System.out.println("Marks "+ marks);
    }
}
// Department in academic unit


// classroom in academic unit
class Classroom{
    private int classroomno;
    private int capacityofstudents;
    
    public Classroom(int classroomno, int capacityofstudents) {
        this.classroomno = classroomno;
        this.capacityofstudents = capacityofstudents;
    }

    public int getClassroomno() {
        return classroomno;
    }

    public void setClassroomno(int classroomno) {
        this.classroomno = classroomno;
    }

    public int getCapacityofstudents() {
        return capacityofstudents;
    }

    public void setCapacityofstudents(int capacityofstudents) {
        this.capacityofstudents = capacityofstudents;
    }
    
}
// lab in academic unit

class Lab{
    private int labno;
    private int studentcapacity;
   
    public Lab(int labno, int studentcapacity) {
        this.labno = labno;
        this.studentcapacity = studentcapacity;
    }
    public int getLabno() {
        return labno;
    }
    public void setLabno(int labno) {
        this.labno = labno;
    }
    public int getStudentcapacity() {
        return studentcapacity;
    }
    public void setStudentcapacity(int studentcapacity) {
        this.studentcapacity = studentcapacity;
    }
    

}
// class Fcilty extend campus entity

class Facility extends CampusEntity{
    Library library;
    Hostel Hostel;
    Cafeteria cafeteria;

    void calculateOperaƟonalCost(){
        System.out.println("based on maintainance and usage frequency");
    }
    
}
class Library{
    private String bookname;
    private String idate;
    private String rdate;
    public Library() {
    }
    public Library(String bookname, String idate, String rdate) {
        this.bookname = bookname;
        this.idate = idate;
        this.rdate = rdate;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getIdate() {
        return idate;
    }
    public void setIdate(String idate) {
        this.idate = idate;
    }
    public String getRdate() {
        return rdate;
    }
    public void setRdate(String rdate) {
        this.rdate = rdate;
    }
    }
    class Hostel{
        private int hostelrooms;
        
    }