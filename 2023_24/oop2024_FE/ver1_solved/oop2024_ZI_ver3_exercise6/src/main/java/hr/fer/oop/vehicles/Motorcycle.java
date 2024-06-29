package hr.fer.oop.vehicles;

public class Motorcycle extends RentableVehicle {

	private MotorcycleType type;
	@Override
	public double getPrice(boolean isVIP) {
		return getRegularPrice() * (isVIP ? 0.85 : 1);
	}
	public MotorcycleType getType() {
		return type;
	}
	public void setType(MotorcycleType type) {
		this.type = type;
	}
	
}
