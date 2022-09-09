package hr.fer.oop.t3.items;

import java.time.LocalDate;

public final class FreshJuice extends Beverage implements Perishable {
	
	private LocalDate bestBefore;	
	
	@Override
	public LocalDate getBestBefore() {
		return bestBefore;
	}
	@Override
	public void setBestBefore(LocalDate bestBefore) {
		this.bestBefore = bestBefore;
	}
				
	public FreshJuice(String sku, String name, double price, double volume, LocalDate bestBefore){
		super(sku, name, price, volume);
		this.bestBefore = bestBefore;
	}
}
