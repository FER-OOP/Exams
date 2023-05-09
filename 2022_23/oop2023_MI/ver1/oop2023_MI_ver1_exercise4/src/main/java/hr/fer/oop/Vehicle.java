package hr.fer.oop;


public class Vehicle {
	private final String name;

	public Vehicle(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
