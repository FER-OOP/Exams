package hr.fer.oop;

/**
 * Exception thrown when a project with the requested ID is not found.
 * Inherits ProjectException.
 */
public class ProjectNotFoundException extends ProjectException {
    public ProjectNotFoundException(String message) {
        super(message);
    }
}