package hr.fer.oop.t4;

import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		List<City> list = CityLoader.load("src/main/resources/worldcities20.csv");
		
		System.out.println(list.stream().count()); //20
		
		System.out.println(CityUtils.countBigCitiesInACountry(list.stream(), "Italy")); //2
		System.out.println(CityUtils.countBigCitiesInACountry(list.stream(), "Croatia")); //0
		
		System.out.println(CityUtils.northestCityInACountry(list.stream(), "HR")); //Cakovec
		
		Stream<String> s = CityUtils.capitalCitiesStartingWithALetter(list.stream(), 'Z');
		System.out.println(s.count()); //1

	}

}
