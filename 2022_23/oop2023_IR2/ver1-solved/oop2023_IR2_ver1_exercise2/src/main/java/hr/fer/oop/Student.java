package hr.fer.oop;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String studentName;
    private int studentID;
    private List<Course> enrolledCourses;

    public Student(String studentName, int studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
    }


    public boolean isEnrolledIn(Course course) {
        return enrolledCourses.contains(course);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + studentName + '\'' +
                ", studentID=" + studentID +
                '}';
    }



}

