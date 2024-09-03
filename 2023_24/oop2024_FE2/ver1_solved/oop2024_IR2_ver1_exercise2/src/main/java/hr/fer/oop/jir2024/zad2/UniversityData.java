package hr.fer.oop.jir2024.zad2;

import java.util.ArrayList;
import java.util.List;

public class UniversityData {

	public static List<University> load() {
		
		List<University> list = new ArrayList<>();
		list.add(new University("MIT", "USA", 1861, 3, 3));
		list.add(new University("Harvard", "USA", 1636, 4, 1));		
		list.add(new University("ETH", "Switzerland", 1855, 11, 21));
		list.add(new University("UNIZG", "Croatia", 1669, 1001, 401));
		list.add(new University("UNIRI", "Croatia", 1973, 1001, 1001));
		list.add(new University("OPENUNI", "UK", 1969, 101, 601));		
		list.add(new University("Bologna", "Italy", 1088, 155, 201));
		list.add(new University("UNIBologna", "Italy", 1088, 155, 201));
		list.add(new University("UNIAT", "Greece", 1211, 930, 801));	
				
		return list;
	}
	
}
