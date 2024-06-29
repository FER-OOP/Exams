package hr.fer.oop.vehicles;

public abstract class RentableVehicle extends Vehicle implements Rentable {
	@Override
	public double getRentingPricePerDay() {
		return 0.001 * getPrice(true);
	}
}
