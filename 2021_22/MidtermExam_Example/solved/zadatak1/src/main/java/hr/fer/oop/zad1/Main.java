package hr.fer.oop.zad1;

public class Main {

	public static void main(String[] args) {
		Cherry cherry = new Cherry("Maraska", 2000, 20, true);
		Peach peach = new Peach("Vinogradarska", 505, 50, 6);

		System.out.println(cherry.isHasWorm());

		System.out.println(cherry.productionPrice(100));
		System.out.println(peach.productionPrice(50));

		System.out.println(cherry.myMarketPrice());
		System.out.println(peach.myMarketPrice());

	}

}
