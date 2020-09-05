package hr.fer.oop.task1;

public class FruitIcecream extends Icecream implements DietProduct{

	private String fruitType;
	
	private int noOfCalories;
	private boolean sugarFree;

	@Override
	public int getNoOfCalories() {
		return noOfCalories;
	}

	@Override
	public boolean isSugarFree() {
		return sugarFree;
	}
	
}
