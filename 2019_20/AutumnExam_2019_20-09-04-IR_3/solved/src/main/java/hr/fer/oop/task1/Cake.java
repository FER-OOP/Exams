package hr.fer.oop.task1;

public class Cake extends Item implements DietProduct {

	private Preparation preparation;
	private int noOfCalories;
	private boolean sugarFree;
	
	public Preparation getPreparation() {
		return preparation;
	}

	public void setPreparation(Preparation preparation) {
		this.preparation = preparation;
	}

	@Override
	public int getNoOfCalories() {
		return noOfCalories;
	}

	@Override
	public boolean isSugarFree() {
		return sugarFree;
	}
	
}
