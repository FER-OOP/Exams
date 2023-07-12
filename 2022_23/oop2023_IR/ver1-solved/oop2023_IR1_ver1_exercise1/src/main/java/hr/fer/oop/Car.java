package hr.fer.oop;

class Car extends AbstractTransport {
	public double fuelEfficiency;
	public static final double CO2_EMISSIONS = 2.3;

	Car(String name, double fuelEfficiency) {
		super(name);
		if (fuelEfficiency > 0)	
			this.fuelEfficiency = fuelEfficiency;
		else
			this.fuelEfficiency = 10;
	}

	@Override
	public double calculateCO2(double distance) {
		if (distance >= 0)
			return (fuelEfficiency/100*distance*CO2_EMISSIONS);
		else
			return 0;
	}

	@Override
	public String toString() {
		return String.format("%s is a car that spends %.2f liters per 100 kilometers", super.toString(), fuelEfficiency);
	}

}
