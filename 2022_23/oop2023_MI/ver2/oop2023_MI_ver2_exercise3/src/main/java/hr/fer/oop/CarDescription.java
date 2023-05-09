package hr.fer.oop;

import java.util.Objects;


public class CarDescription {
	private Brand brand;
	private String model;
	private int year;
	
	
	public CarDescription(Brand brand, String model, int year) {
		super();
		this.brand = brand;
		this.model = model;
		this.year = year;
	}
	public CarDescription() {
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public void setYear(int year) {
		this.year = year;
	}



	

	public Brand getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	
	
	@Override
	public String toString() {
		return String.format("%s %s (%s)");
	}
	@Override
	public int hashCode() {
		return Objects.hash(brand, model, year);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarDescription other = (CarDescription) obj;
		return brand == other.brand && Objects.equals(model, other.model) && year == other.year;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
