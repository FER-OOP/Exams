package hr.fer.oop.midterm_2020_21.task1;

public class Main {

	public static void main(String[] args) {
		Fruit peach = new Peach("Prunus persica", 150, 298.5, 9);
		Fruit cherry = new Cherry("Prunus avium", 5000, 3121.1, true);
		
		System.out.println("PEACH");
		System.out.println(peach.productionPrice(5));
		System.out.println(peach.myMarketPrice());
		
		System.out.println("CHERRY");
		System.out.println(cherry.productionPrice(10));
		System.out.println(cherry.myMarketPrice());
		
	}

}
