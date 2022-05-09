package hr.fer.oop.zad1;

import java.util.Arrays;

abstract class Airline implements SpecialRequirements {
	private String name;
	private String[] fleet;
	
	public Airline(String name, String[] fleet) {
		this.name = name;
		this.fleet = fleet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getFleet() {
		return fleet;
	}

	public void setFleet(String[] fleet) {
		this.fleet = fleet;
	}
	
	public abstract boolean availabilityOfPromotionalPrices();
		
	@Override
	public String toString() {
		return String.format("Airline %s has fleet: %s.", name, Arrays.toString(fleet));
	}
}
