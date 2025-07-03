package hr.fer.oop;

/**
 * Custom exception thrown when attempting to mark a task as completed,
 * and it has already been completed. Inherits TaskException.
 */
public class TaskAlreadyCompletedException extends TaskException {
    public TaskAlreadyCompletedException(String message) {
        super(message);
    }
}

