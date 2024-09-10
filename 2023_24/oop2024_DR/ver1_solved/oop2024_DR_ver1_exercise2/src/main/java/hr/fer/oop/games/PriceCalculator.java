package hr.fer.oop.games;

public class PriceCalculator {
	public static double rentPrice(Iterable<? extends Equipment> equipment) {
		double price = 0;
		for(Equipment e : equipment) {
			if (e instanceof Rentable r) 
				price += r.getRentingPricePerDay();
		}
		
		return price;
	}
}
