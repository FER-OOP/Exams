package hr.fer.oop;


public class Limousine extends Car {
	protected int passengerCapacity;
	
	public Limousine(String manufacturer, String model, int yearOfManufactue, FuelType fuelType, int horsePower, int passengerCapacity) {
        super(manufacturer, model, yearOfManufactue, fuelType, horsePower);
        this.passengerCapacity = passengerCapacity;
    }

	@Override
    public String toString() {
    	return String.format("%s and with the passenger capacity of %d", super.toString(), passengerCapacity);
    }

}
