package hr.fer.oop.task2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		List<Vehicle> list =  VehicleCatalog.loadVehicles();
		//
		System.out.println(list.contains(new Vehicle(1000, 80, "Fiat Punto"))); //true
		System.out.println(list.contains(new Vehicle(1100, 80, "Fiat Punto"))); //false
		
		//add them to hashset
		Set<Vehicle> set = new HashSet<>(list);
		System.out.println(set.contains(new Vehicle(1000, 80, "Fiat Punto"))); //true
		
		//add them to tree set
		set = new TreeSet<>(list);
		
		//print all cars from set
		set.stream()		   
		   .forEach(System.out::println);
		
		System.out.println();
		
		List<Comparator<Vehicle>> comparators = new LinkedList<>();		
		comparators.add(Vehicle.BY_HP);
		comparators.add(Vehicle.BY_NAME);
		comparators.add(Vehicle.BY_WEIGHT);

		for(var comparator : comparators) {
			list.stream()
			   	.sorted(comparator)
			   	.forEach(System.out::println);
			
			System.out.println();
		}		
	}

}
