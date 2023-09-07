package hr.fer.oop;

public interface Registrable {
        public String getId();
        public String getName();
        public String getInfo();
        public void enrollStudent(Student student) throws EnrollmentException;

}
