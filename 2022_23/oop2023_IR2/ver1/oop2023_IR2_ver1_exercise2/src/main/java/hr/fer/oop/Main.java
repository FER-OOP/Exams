/*package hr.fer.oop;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws EnrollmentException {
        Course oop = new Course("OOP101", "Object Oriented Programming", 30);

        String[] studentNames = {"A.B.", "B.C.", "C.C.", "D.K.", "E.T.", "F.R.", "G.P.", "H.C.", "I.M.", "J.J."};
        int[] studentIDs = {12345, 54321, 67890, 98765, 13579, 24680, 11111, 22222, 33333, 44444};

        Student[] students = new Student[studentNames.length];
        for (int i = 0; i < studentNames.length; i++) {
            students[i] = new Student(studentNames[i], studentIDs[i]);
            oop.enrollStudent(students[i]);
        }

        Course testCourse = new Course("T101", "Test course", 2);
        Course course2 = new Course("T2", "Random course for testing", 3);

        Student a = new Student("Student A", 11111);
        Student b = new Student("Student B", 22222);
        Student c = new Student("Student C", 33333);

        List<Student> studentsToEnroll = List.of(a, b, c);

//            try {
//                testCourse.enrollStudent(student);
//           } catch (EnrollmentException e) {
//               System.out.println("Error" + ": " + e.getMessage());
//           }
//        }

        for (Student s : studentsToEnroll) {
            try {
                course2.enrollStudent(s);
            } catch (EnrollmentException e) {
                System.out.println("Error" + ": " + e.getMessage());
            }
        }
        System.out.println("Enrolled students in " + course2.getName() + ": " + course2.getEnrolledStudents());

        Course advancedOopCourse = new Course("AOOP201", "Advanced OOP", 25);

        // Add prerequisites
        advancedOopCourse.addPrerequisite(oop);
        oop.enrollStudent(a);
        advancedOopCourse.enrollStudent(a);
        System.out.println("Enrolled students in " + advancedOopCourse.getName() + ": " + advancedOopCourse.getEnrolledStudents());

        // Enroll student2 in advancedOopCourse (should fail due to missing prerequisite)
//        try {
//            advancedOopCourse.enrollStudent(b);
//   } catch (EnrollmentException e) {
//        System.out.println("Error: " + e.getMessage());
//    }

        System.out.println();
        printCourseInfo(course2);
        System.out.println();
        printStudentCourseInfo(a);
    }

    public static void printCourseInfo(Course course) {
        System.out.println("COURSE INFO:");
        System.out.println(course.getInfo());
        System.out.println("Enrolled Students: " + course.getEnrolledStudents().size());
        System.out.println("Enrolled Student IDs:");
        for (Student student :course.getEnrolledStudents()) {
            System.out.println("- " + student.getStudentID());
        }
    }

    public static void printStudentCourseInfo(Student student) {
        System.out.println("STUDENT INFO:");
        System.out.println("Student: " + student.getStudentName());
        System.out.println("Student ID: " + student.getStudentID());
        System.out.println("Enrolled Courses:");
        for (Course course : student.getEnrolledCourses()) {
            System.out.println("- " + course.getName());
        }
        System.out.println();
    }

}*/