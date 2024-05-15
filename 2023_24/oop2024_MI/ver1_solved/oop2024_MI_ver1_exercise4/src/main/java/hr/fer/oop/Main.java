package hr.fer.oop;


public class Main {

	public static void main(String[] args) {
		FruitSaladPreparator saladMaker = new FruitSaladPreparator();
		
		System.out.println("FRUIT INGREDIENTS:");
		Fruit banana = new Fruit("2 bananas", 2, 54, 1);
		System.out.println(banana);
		Fruit passionFruit = new Fruit("passion fruit", 5, 55, 2);
		System.out.println(passionFruit);
		
		Meal meal = saladMaker.prepare(banana, passionFruit);
		
		System.out.println("RESULTING MEAL:");
		System.out.println(meal);
		

	}

}
