package hr.fer.oop.vehicles;

public abstract class Vehicle {
	private String model;
	private int power;
	private double regularPrice;
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public double getRegularPrice() {
		return regularPrice;
	}
	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public abstract double getPrice(boolean isVIP);
}
