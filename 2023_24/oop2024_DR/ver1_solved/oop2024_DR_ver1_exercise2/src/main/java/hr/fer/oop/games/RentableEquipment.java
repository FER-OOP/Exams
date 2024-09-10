package hr.fer.oop.games;

public abstract class RentableEquipment extends Equipment implements Rentable {
	@Override
	public double getRentingPricePerDay() {
		return 0.001 * getPrice(true);
	}
}
