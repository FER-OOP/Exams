package hr.fer.oop.zad1;

abstract class Fruit {
	private String species;
	private int numberOfFruits;
	private double productionPrice;

	public Fruit(String species , int numberOfFruits , double productionPrice ) {
		this.species = species;
		this.numberOfFruits = numberOfFruits;
		this.productionPrice = productionPrice;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getNumberOfFruits() {
		return numberOfFruits;
	}

	public void setNumberOfFruits(int numberOfFruits) {
		this.numberOfFruits = numberOfFruits;
	}

	public double getProductionPrice() {
		return productionPrice;
	}

	public void setProductionPrice(double productionPrice) {
		this.productionPrice = productionPrice;
	}

	public abstract double myMarketPrice();

	public final double productionPrice(int numberOfTrees) {
		return productionPrice * numberOfTrees;
	}
}
