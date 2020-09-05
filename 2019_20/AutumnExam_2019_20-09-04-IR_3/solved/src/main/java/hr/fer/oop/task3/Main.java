package hr.fer.oop.task3;

import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		Drink cola = new Drink("cola", 250, false);
		Drink juice = new Drink("juice", 330, false);
		Drink coffee = new Drink("coffee", 100, false);
		Drink irishCoffee = new Drink("Irish coffee", 150, true);
		Drink wine = new Drink("wine", 100, true);
		Drink beer = new Drink("beer", 500, true);

		Bar bar = new Bar();
		bar.loadDrink(cola, 15.00);
		bar.loadDrink(juice, 16.50);
		bar.loadDrink(coffee, 9.00);
		bar.loadDrink(irishCoffee, 13.00);
		bar.loadDrink(wine, 15.50);
		bar.loadDrink(beer, 18.00);

		bar.buyDrink(cola, 2);
		bar.buyDrink(beer, 10);

		System.out.println(getNumberOfAlcoholicDrinks(bar));
		Map<String, Double> map = getPricePerMlOfDrink(bar);
		for (String s : map.keySet()) {
			System.out.println(s + " : " + map.get(s));
		}

		System.out.println(getDailyReceipts(bar));
	}

	public static long getNumberOfAlcoholicDrinks(Bar bar) {

		return bar.getPriceList().entrySet().stream().
				filter(entry -> entry.getKey().isContainingAlcohol() == true).count();
	}

	public static double getDailyReceipts(Bar bar) {

		return bar.getTotalDailyReceipt().entrySet().stream()
				.mapToDouble(entry -> entry.getValue() * bar.getPriceList().get(entry.getKey())).sum();
	}

	public static Map<String, Double> getPricePerMlOfDrink(Bar bar) {

		return bar.getPriceList().entrySet().stream().collect(Collectors.toMap((entry -> entry.getKey().getName()),
				(entry -> entry.getValue() / entry.getKey().getAmountInMl())));
	}

}
