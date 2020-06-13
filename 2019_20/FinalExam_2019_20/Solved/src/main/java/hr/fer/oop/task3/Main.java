package hr.fer.oop.task3;

import java.util.List;

import hr.fer.oop.task2.Vehicle;
import hr.fer.oop.task2.VehicleCatalog;

public class Main {

	public static void main(String[] args) {
		List<Vehicle> list =  VehicleCatalog.loadVehicles();
		VehicleCollection col = new VehicleCollection();
		for(var vehicle : list) {
			col.add(vehicle);
			col.add(vehicle);
		}
		
		col.add(list.get(0), list.get(1),  list.get(1), list.get(2));
		col.remove(list.get(3));

		for(Pair<Vehicle, Integer> pair : col) {			
			System.out.printf("%s --> %d occurances in collection%n", pair.getFirst(), pair.getSecond());
		}		
	}

}
