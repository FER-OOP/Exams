package hr.fer.oop.jir2024.zad4;

import java.util.ArrayList;
import java.util.List;

public class UniversityData {

	public static List<University> load() {
		
		List<University> list = new ArrayList<>();
		
		list.add(new University("UNIZG", "Croatia", 1669, 1001, 401));
		list.add(new University("OPENUNI", "UK", 1969, 101, 601));
		list.add(new University("UNIRI", "Croatia", 1973, 1501, 999));
		list.add(new University("UNIHW", "USA", 1861, 3, 1));
		list.add(new University("UNIHW", "USA", 1861, 3, 1));
		list.add(new University("UNIAT", "Greece", 1210, 93, 801));
		list.add(new University("UNIAT", "Greece", 2023, 999, 999));
		list.add(new University("UNIAt", "Greece", 1211, 93, 801));	
		list.add(new University("ETH", "Switzerland", 1855, 11, 21));
		list.add(new University("MIT", "USA", 1861, 3, 1));
				
		return list;
	}
	
}
