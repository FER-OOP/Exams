package hr.fer.oop;

public class LogFullException extends RuntimeException {

    private final int capacity;

    public LogFullException(int capacity) {
        super("Catch log is full, capacity: " + capacity);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
