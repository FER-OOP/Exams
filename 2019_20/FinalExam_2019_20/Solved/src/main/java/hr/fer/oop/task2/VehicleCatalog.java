package hr.fer.oop.task2;

import java.util.ArrayList;
import java.util.List;

public class VehicleCatalog {
	public static List<Vehicle> loadVehicles(){
		List<Vehicle> list = new ArrayList<>();
		
		list.add(new Vehicle(2000, 150, "Fiat Multipla"));
		list.add(new Vehicle(1050, 150, "VW Golf"));
		list.add(new Vehicle(1500, 200, "Škoda Superb"));
		list.add(new Vehicle(1100, 65, "Škoda Felicia"));
		list.add(new Vehicle(1300, 65, "Škoda Fabia"));
		list.add(new Vehicle(1200, 65, "Fiat Punto"));
		list.add(new Vehicle(1000, 80, "Fiat Punto"));
								
		return list;
	}
}
