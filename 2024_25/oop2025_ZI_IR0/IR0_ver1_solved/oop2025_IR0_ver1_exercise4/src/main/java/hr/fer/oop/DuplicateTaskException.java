package hr.fer.oop;

/**
 * Custom exception thrown when trying to add a task
 * with an ID that already exists. Inherits TaskException.
 */
public class DuplicateTaskException extends TaskException {
    public DuplicateTaskException(String message) {
        super(message);
    }
}