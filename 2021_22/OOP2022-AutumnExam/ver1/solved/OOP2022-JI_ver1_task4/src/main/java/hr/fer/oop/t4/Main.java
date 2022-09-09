package hr.fer.oop.t4;

import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		//List<City> list = CityLoader.load("worldcities.csv");
		List<City> list = CityLoader.load("src/main/resources/worldcities.csv");
		
		System.out.println(list.stream().count()); //42905
		
		System.out.println(CityUtils.countBigCitiesInACountry(list.stream(), "Italy"));
		System.out.println(CityUtils.countBigCitiesInACountry(list.stream(), "Croatia"));
		System.out.println(CityUtils.countBigCitiesInACountry(list.stream(), "Hungary"));
		
		System.out.println(CityUtils.northestCityInACountry(list.stream(), "HR"));
		
		Stream<String> s = CityUtils.capitalCitiesStartingWithALetter(list.stream(), 'O');
		
		s.forEach(c -> System.out.println(c));
		
//		for (City c : list)
//			System.out.println(c);

	}

}
