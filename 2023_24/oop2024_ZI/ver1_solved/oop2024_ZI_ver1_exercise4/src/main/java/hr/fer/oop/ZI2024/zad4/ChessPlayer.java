package hr.fer.oop.ZI2024.zad4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.TreeMap;
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
	
	// Chess players born on given year or earlier, sorted by rating
	public static Stream<ChessPlayer> getOldChessPlayers(List<ChessPlayer> lplayers, int year) {
		return lplayers.stream()
				.filter((cp) -> cp.birthyear < year)
				.sorted((cp1, cp2) -> cp1.rating - cp2.rating);
	}
	
	// get max rating for a given country, if no such players return -1
	public static int getBestRating(Stream<ChessPlayer> cpstream, Country country) {
		OptionalInt maxrating = cpstream.filter(cp -> cp.country == country)
			.mapToInt(cp -> cp.rating)
			.max();
		
		if (maxrating.isPresent()) return maxrating.getAsInt();
		else return -1;
	}
	
	// Return a String with a list of players with rating above a threshold, the string should be of format
	// lastname1, firstname1; lastname2, firstname2; ...
	public static String getGoodPlayers(Stream<ChessPlayer> cpstream, int ratingthreshold) {
		return cpstream.filter(cp -> cp.rating > ratingthreshold)
				.map(cp -> cp.lastname + ", " + cp.firstname)
				.collect(Collectors.joining("; "));
	}
	
	// Return a map where key is the country and value represents a number of players from that country
	public static Map<Country, Integer> getPlayersForCountry(Stream<ChessPlayer> cpstream) {
		Map<Country, Integer> cplayers = new HashMap<>();
		
		cpstream.forEach(cp -> cplayers.compute(cp.country, (k, v) -> (v==null)?1:v+1));
		
		return cplayers;
	}

	/* KK: Thanks to Ema Smolić, solution with groupingBy
	 * Does not work now!!!
	public static Map<Country, Long> getPlayersForCountry(Stream<ChessPlayer> cpstream) {
		return cpstream.collect(Collectors.groupingBy(
   				cp -> cp.getCountry(),
   				Collectors.counting()));
	}
	*/
	
	public static void main(String[] args) {
		List<ChessPlayer> players = ChessPlayerData.loadChessPlayersTop();

		Stream<ChessPlayer> cpstream = getOldChessPlayers(players, 1990);
		System.out.println("Chess players born before 1990:");
		cpstream.forEach(cp -> System.out.println(cp));
		
		int maxratingusa =  getBestRating(players.stream(), Country.USA);
		int maxratinggermany =  getBestRating(players.stream(), Country.GERMANY);
		
		System.out.printf("\nBest rating in USA: %d", maxratingusa);
		System.out.printf("\nBest rating in Germany: %d", maxratinggermany);
		
		String goodplayers = getGoodPlayers(players.stream(), 2800);
		System.out.println("\n\nVery good players: " + goodplayers);
		
		System.out.println("\nCountry map:");
		Map<Country, Integer> cplayers = getPlayersForCountry(players.stream());
		cplayers.forEach((k,v) -> System.out.println(k + ": " + v));


	}
}


