package hr.fer.oop.task3;

import java.util.HashMap;
import java.util.Map;

public class Bar {

	
	private Map<Drink, Double> priceList;
	private Map<Drink, Integer> drinksSold;

	public Bar() {
		priceList = new HashMap<>();
		drinksSold = new HashMap<>();
	}

	public void loadDrink(Drink d, Double price) {
		priceList.put(d, price);
	}
	
	public void buyDrink(Drink d, int amount) {
		if(!drinksSold.containsKey(d))
			drinksSold.put(d, amount);
		else
			drinksSold.put(d, drinksSold.get(d) + amount);
	}

	public Map<Drink, Double> getPriceList() {
		return priceList;
	}

	public void setPriceList(Map<Drink, Double> priceList) {
		this.priceList = priceList;
	}

	public Map<Drink, Integer> getTotalDailyReceipt() {
		return drinksSold;
	}

	public void setTotalDailyReceipt(Map<Drink, Integer> totalDailyReceipt) {
		this.drinksSold = totalDailyReceipt;
	}
}
