package hr.fer.oop;

/**
 * Exception thrown when attempting to mark a project as complete,
 * when it has already been completed. Inherits ProjectException.
 */
public class ProjectAlreadyCompletedException extends ProjectException {
    public ProjectAlreadyCompletedException(String message) {
        super(message);
    }
}