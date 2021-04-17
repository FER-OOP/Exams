package hr.fer.oop.midterm_2020_21.task1;

public class Cherry extends Fruit {
	private boolean hasWorm;
	
	public Cherry(String species, int numberOfFruits, double productionPrice, boolean hasWorm) {
		super(species, numberOfFruits, productionPrice);
		this.hasWorm = hasWorm;
	}

	@Override
	public double myMarketPrice() {
		double myPrice = this.getProductionPrice() / this.getNumberOfFruits();
		return myPrice * (hasWorm ? 1.2 : 1.5); 
	}

	public boolean isHasWorm() {
		return hasWorm;
	}

	public void setHasWorm(boolean hasWorm) {
		this.hasWorm = hasWorm;
	}

}
