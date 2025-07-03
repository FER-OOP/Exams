package hr.fer.oop;

/**
* The main, parent exception for any problems that may occur
* when handling tasks.
*/
public class TaskException extends Exception {
    public TaskException(String message) {
        super(message);
    }
}