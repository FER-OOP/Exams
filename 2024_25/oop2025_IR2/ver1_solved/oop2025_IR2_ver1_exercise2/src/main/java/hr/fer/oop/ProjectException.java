package hr.fer.oop;

/**
 * The main, parent exception for any problems that may occur
 * when handling projects.
 */
public class ProjectException extends Exception {
    public ProjectException(String message) {
        super(message);
    }
}