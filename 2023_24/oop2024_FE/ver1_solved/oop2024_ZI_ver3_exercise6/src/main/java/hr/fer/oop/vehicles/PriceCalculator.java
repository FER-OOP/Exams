package hr.fer.oop.vehicles;

public class PriceCalculator {
	public static double rentPrice(Iterable<? extends Vehicle> vehicles) {
		double price = 0;
		for(Vehicle v : vehicles) {
			if (v instanceof Rentable r) 
				price += r.getRentingPricePerDay();
		}
		
		return price;
	}
}
