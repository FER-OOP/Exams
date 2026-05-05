package hr.fer.oop.stack;

public class CapacityException extends RuntimeException {

	private final int capacity;

	public CapacityException(int capacity) {
		super();
		this.capacity = capacity;
	}
	public int getCapacity() {
		return capacity;
	}

}
