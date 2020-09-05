package hr.fer.oop.task3;

import java.util.Objects;

public class Drink {

	private String name;
	private int amountInMl;
	private boolean containsAlcohol;
	
	public Drink() {
	}
	
	public Drink(String name, int amountInMl, boolean containAlcohol) {
		super();
		this.name = name;
		this.amountInMl = amountInMl;
		this.containsAlcohol = containAlcohol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmountInMl() {
		return amountInMl;
	}

	public void setAmountInMl(int amountInMl) {
		this.amountInMl = amountInMl;
	}

	public boolean isContainingAlcohol() {
		return containsAlcohol;
	}

	public void setContainsAlcohol(boolean containAlcohol) {
		this.containsAlcohol = containAlcohol;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Drink drink = (Drink) o;
		return amountInMl == drink.amountInMl &&
				containsAlcohol == drink.containsAlcohol &&
				Objects.equals(name, drink.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, amountInMl, containsAlcohol);
	}
}
