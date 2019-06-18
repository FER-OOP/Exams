package hr.fer.oop.task1;

import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Car> list =  CarCatalog.loadCars();
		
		//print all cars sorted descending by price
		list.stream()
			.sorted(Comparator.comparing(Car::getPrice).reversed())
			.forEach(System.out::println);
		
		System.out.println();
		//print average price of petrol cars (if such exist)
		list.stream()
			.filter(c -> c.getType() == CarType.PETROL)
			.mapToDouble(c -> c.getPrice())
			.average()
			.ifPresent(v -> System.out.println("Average price of petrol car is: " + v));

	}

}
