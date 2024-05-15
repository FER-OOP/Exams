package hr.fer.oop;

import java.util.Objects;


public class Meal implements Nutritional {
	private String name;

	private int protein;
	private int carbs;
	private int fat;

	public Meal(int protein, int carbs, int fat) {
		super();
		this.protein = protein;
		this.carbs = carbs;
		this.fat = fat;
	}

	public Meal(String name, int protein, int carbs, int fat) {
		super();
		this.name = name;
		this.protein = protein;
		this.carbs = carbs;
		this.fat = fat;
	}

	public String getName() {
		return name;
	}

	public int getProtein() {
		return protein;
	}

	public int getCarbs() {
		return carbs;
	}

	public int getFat() {
		return fat;
	}

	@Override
	public String toString() {
		return "Meal [name=" + name + ", protein=" + protein + ", carbs=" + carbs + ", fat=" + fat + ", calories="
				+ getCalories() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carbs, fat, name, protein);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meal other = (Meal) obj;
		return carbs == other.carbs && fat == other.fat && Objects.equals(name, other.name) && protein == other.protein;
	}

}
