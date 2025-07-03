package hr.fer.oop;

/**
* Custom exception thrown when a task with the requested ID is not found.
* Inherits TaskException.
*/
public class TaskNotFoundException extends TaskException {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
