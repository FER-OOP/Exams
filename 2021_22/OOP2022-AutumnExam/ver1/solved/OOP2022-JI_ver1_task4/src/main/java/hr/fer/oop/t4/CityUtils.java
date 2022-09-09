package hr.fer.oop.t4;

import java.util.stream.Stream;

public class CityUtils {
	
	//big city == population > 1 000 000
	public static long countBigCitiesInACountry(Stream<City> cities, String countryName) {
		return cities.filter(c -> c.getCountryName().equals(countryName))
				     .filter(c -> c.getPopulation()>1000000)
				     .count();
	}
	
	// northest City == city with max lat
	public static City northestCityInACountry(Stream<City> cities, String countryISO2) {
		return cities.filter(c -> c.getCountryISO2().equals(countryISO2))
					 .max( (c1,c2) -> (Double.compare(c1.getLat(), c2.getLat())))
					 .get();
	}
	
	// returns ascii name!
	public static Stream<String> capitalCitiesStartingWithALetter(Stream<City> cities, char letter) {
		return cities.filter(c -> c.getName().startsWith(Character.toString(letter)))
					 .filter(c -> c.getCapitalType().equals(CityType.PRIMARY))
					 .map(c -> c.getAsciiName());

	}

}
