package hr.fer.oop;


public class Car implements MotorVehicle {
	public Car(String manufacturer, String model, int yearOfManufacture, FuelType fuelType, int horsePower) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.yearOfManufacture = yearOfManufacture;
		this.fuelType = fuelType;
		this.horsePower = horsePower;
	}
	protected String manufacturer;
	private String model;
	private int yearOfManufacture;
	protected FuelType fuelType;
	private int horsePower;

	@Override
	public int getHorsePower() {
		return this.horsePower;
	}

	@Override
	public FuelType getFuelType() {
		return this.fuelType;
	}
	@Override
	public String getModel() {
		return model;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %d with %d hp", manufacturer, model, yearOfManufacture, horsePower);
	}
}
