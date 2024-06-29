package hr.fer.oop.ZI2024.zad4;

import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChessPlayer{
	private String firstname;
	private String lastname;
	private Country country;
	private int rating;
	private int birthyear;

	public ChessPlayer(String firstname, String lastname, Country country, int rating, int birthyear) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.country = country;
		this.rating = rating;
		this.birthyear = birthyear;
	}
	
	public String toString() {
		return String.format("(%s) %s %s %d: %d", country, firstname, lastname, birthyear, rating);
	}
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public Country getCountry() {
		return country;
	}

	public int getRating() {
		return rating;
	}

	public int getBirthyear() {
		return birthyear;
	}
	
	// Chess players with rating above given threshold, sorted by year of birth from older to younger
	public static Stream<ChessPlayer> getGoodChessPlayers(List<ChessPlayer> lplayers, int ratingthreshold) {
		return lplayers.stream()
				.filter((cp) -> cp.rating > ratingthreshold)
				.sorted((cp1, cp2) -> - (cp1.birthyear - cp2.birthyear));
	}
	
	// get avg rating for a given country, if no such players return 0
	public static double getAvgRating(Stream<ChessPlayer> cpstream, Country country) {
		OptionalDouble avgrating = cpstream.filter(cp -> cp.country == country)
			.mapToInt(cp -> cp.rating)
			.average();
		
		if (avgrating.isPresent()) return avgrating.getAsDouble();
		else return 0.0;
	}
	
	// Return a String with a list of players that satisfy a condition defined with a predicate
	// The string should be of format:
	// lastname1, firstname1; lastname2, firstname2; ...
	public static String getFilteredPlayers(Stream<ChessPlayer> cpstream, Predicate<ChessPlayer> filter) {
		return cpstream.filter(filter)
				.map(cp -> cp.lastname + ", " + cp.firstname)
				.collect(Collectors.joining("; "));
	}
	
	// Return a map where key is the country and value represents maximum player rating for players from that country
	// More complex compute
	public static Map<Country, Integer> getMaxRatingForCountry(Stream<ChessPlayer> cpstream) {
		Map<Country, Integer> cplayers = new HashMap<>();
		
		cpstream.forEach(cp -> cplayers.compute(cp.country, 
							(k, v) -> {
								if (v == null) return cp.rating;
								else return cp.rating > v ? cp.rating : v;
							}
						));
		
		return cplayers;
	}
	
	/* KK: Thanks to Ema Smolić, solution with groupingBy
	public static Map<Country, Long> getPlayersForCountry(Stream<ChessPlayer> cpstream) {
		return cpstream.collect(Collectors.groupingBy(
   				cp -> cp.getCountry(),
   				Collectors.counting()));
	}
	*/
	
	public static void main(String[] args) {
		List<ChessPlayer> players = ChessPlayerData.loadChessPlayersTop();

		Stream<ChessPlayer> cpstream = getGoodChessPlayers(players, 2770);
		System.out.println("Chess players with rating over 2770:");
		cpstream.forEach(cp -> System.out.println(cp));
		
		double avgratingusa =  getAvgRating(players.stream(), Country.USA);
		double avgratinggermany =  getAvgRating(players.stream(), Country.GERMANY);
		
		System.out.printf("\nAverage rating in USA: %.2f", avgratingusa);
		System.out.printf("\nAverage rating in Germany: %.2f", avgratinggermany);
		
		String filteredplayers = getFilteredPlayers(players.stream(), cp -> cp.country == Country.CHINA);
		System.out.println("\n\nPlayers from China: " + filteredplayers);
		
		String youngplayers = getFilteredPlayers(players.stream(), cp -> cp.birthyear > 2004);
		System.out.println("\n\nPlayers from China: " + youngplayers);
		
		System.out.println("\nCountry map:");
		Map<Country, Integer> cplayers = getMaxRatingForCountry(players.stream());
		cplayers.forEach((k,v) -> System.out.println(k + ": " + v));
	}
}


