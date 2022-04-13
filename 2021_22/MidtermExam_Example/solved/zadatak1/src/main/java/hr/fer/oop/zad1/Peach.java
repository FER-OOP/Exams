package hr.fer.oop.zad1;

class Peach extends Fruit {
	private int peachDiameter;

	public Peach(String species, int numberOfFruits, double productionPrice, int peachDiameter) {
		super(species, numberOfFruits, productionPrice);
		this.peachDiameter = peachDiameter;
	}

	public int getPeachDiameter() {
		return peachDiameter;
	}

	public void setPeachDiameter(int peachDiameter) {
		this.peachDiameter = peachDiameter;
	}

	public double myMarketPrice() {
		double myPrice = this.getProductionPrice() / this.getNumberOfFruits();
		return (peachDiameter>=2 && peachDiameter<=8) ? myPrice*1.4 : myPrice*1.3;
	}

}
