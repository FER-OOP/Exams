package hr.fer.oop.finalexam_2018_19.task1;

public class Car {
	
	private String manufacturer;
	private String model;
	private int yearOfManufacture;
	private int numberOfKilometers;
	private String color;
	private int horsepower;
	private double gasConsumption;
	
	public Car(String manufacturer, String model, int yearOfManufacture, int numberOfKilometers, String color,
			int horsepower, double gasConsumption) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.yearOfManufacture = yearOfManufacture;
		this.numberOfKilometers = numberOfKilometers;
		this.color = color;
		this.horsepower = horsepower;
		this.gasConsumption = gasConsumption;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYearOfManufacture() {
		return yearOfManufacture;
	}
	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}
	public int getNumberOfKilometers() {
		return numberOfKilometers;
	}
	public void setNumberOfKilometers(int numberOfKilometers) {
		this.numberOfKilometers = numberOfKilometers;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getHorsepower() {
		return horsepower;
	}
	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}
	public double getGasConsumption() {
		return gasConsumption;
	}
	public void setGasConsumption(double gasConsumption) {
		this.gasConsumption = gasConsumption;
	}
	
	
}
