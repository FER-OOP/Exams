package hr.fer.oop;

import java.util.*;

public class Course extends GeneralInformation{
    protected int maxStudents;
    private List<Student> enrolledStudents;
    private List<Course> prerequisites;


    public Course(String courseCode, String courseName, int maxStudents) {
        super(courseCode, courseName);
        this.maxStudents = maxStudents;
        this.enrolledStudents = new ArrayList<>();
        this.prerequisites = new ArrayList<>();
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public void enrollStudent(Student student) throws EnrollmentException {
            if (enrolledStudents.size() < maxStudents && hasMetPrerequisites(student)) {
                enrolledStudents.add(student);
                student.enrollInCourse(this);
            } else {
                throw new EnrollmentException("Failed to enroll student " + student.getStudentName());
            }

    }


    @Override
    public String getInfo() {
        return super.getInfo() + ", Max Students: " + maxStudents;
    }

    public void addPrerequisite(Course prerequisite) {
        prerequisites.add(prerequisite);
    }

    public boolean hasMetPrerequisites(Student student) {
        for (Course prerequisite : prerequisites) {
            if (!student.isEnrolledIn(prerequisite)) {
                return false;
            }
        }
        return true;
    }
    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public int getMaxStudents() {
        return maxStudents;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Course course = (Course) obj;
        return Objects.equals(getId(), course.getId()) &&
                Objects.equals(getName(), course.getName());
    }
}








