package hr.fer.oop;


public class Car extends Vehicle {
	private int power;

	public Car(String model, int power) {
		super(model);
		this.power = power;
	}
	
	public int getPower() {
		return power;
	}
	
	@Override
	public String toString() {
		return super.toString()+"-"+power;
	}
	

}
