package hr.fer.oop.jir2024.zad2;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<University> list = UniversityData.load();

		//1
		System.out.println("getOldestUniversityName :");
		System.out.println(University.getOldestUniversityName(list));
		
		//2
		System.out.println("\ngetCountries :");
		University.getCountries(list,1,500).forEach(u -> System.out.println(u));
				
		//3
		System.out.println("\ngetBestForCountry :");
		System.out.println(University.getBestForCountry(list.stream(), "Croatia"));
		
		//4
		System.out.println("\ngetARWUMap :");
		University.getARWUMap(list.stream()).entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
		
		//5
		System.out.println("\ngetAvgTHEforCountry :");
		System.out.println(University.getAvgTHEforCountry(list.stream(), "USA"));
		System.out.println(University.getAvgTHEforCountry(list.stream(), "Narnia"));
		
	}

}
