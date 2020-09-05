package hr.fer.oop.task1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class SweetBox extends Item implements DietProduct{

	private List<Item> items;
	private int noOfCalories;
	private boolean sugarFree;
	
	public void addItems(Item ... items) {
		this.items.addAll(Arrays.asList(items));
	}

	@Override
	public double getPrice() {
		return items.stream().mapToDouble(i -> i.getPrice()).sum();
	}
	
	@Override
	public LocalDate getExpDate() {
		return items.stream().map(i -> i.getExpDate()).min(LocalDate::compareTo).get();
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
