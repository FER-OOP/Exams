package hr.fer.oop;

/**
 * Exception thrown when trying to add a project
 * with an ID that already exists. Inherits ProjectException.
 */
public class DuplicateProjectException extends ProjectException {
    public DuplicateProjectException(String message) {
        super(message);
    }
}