package hr.fer.oop.games;

public abstract class Equipment {
	private String name;
	private double regularPrice;
	public double getRegularPrice() {
		return regularPrice;
	}
	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract double getPrice(boolean isVIP);
}
