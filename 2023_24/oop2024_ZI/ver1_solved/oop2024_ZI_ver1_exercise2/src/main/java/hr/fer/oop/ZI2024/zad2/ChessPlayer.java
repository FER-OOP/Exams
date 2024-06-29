package hr.fer.oop.ZI2024.zad2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ChessPlayer implements Comparable<ChessPlayer>{
	private String firstname;
	private String lastname;
	private Country country;
	private int rating;
	private int birthyear;
	
	public static final Comparator<ChessPlayer> BY_LASTNAME = (o1, o2) -> o1.lastname.compareTo(o2.lastname);
	public static final Comparator<ChessPlayer> BY_FIRSTNAME = (o1, o2) -> o1.firstname.compareTo(o2.firstname);
	public static final Comparator<ChessPlayer> BY_BIRTHYEAR = (o1, o2) -> Integer.compare(o1.birthyear, o2.birthyear);	
	
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
	
	// @Override
	public int compareTo(ChessPlayer o) {
		Comparator<ChessPlayer> cNatural = BY_LASTNAME.thenComparing(BY_FIRSTNAME).thenComparing(BY_BIRTHYEAR.reversed());
		
		return cNatural.compare(this,  o);
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

	@Override
	public int hashCode() {
		return Objects.hash(birthyear, firstname, lastname);
	}
	
	@Override
	// Generirao Eclipse
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChessPlayer other = (ChessPlayer) obj;
		return birthyear == other.birthyear && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname);
	}

	public static void main(String[] args) {
		List<ChessPlayer> lplayers = ChessPlayerData.loadChessPlayersSmall();
		ChessPlayer testplayer1 = new ChessPlayer("Tom", "Cruise", Country.USA, 1600, 1992);
		ChessPlayer testplayer2 = new ChessPlayer("Tom", "Cruise", Country.USA, 1605, 2024);
		
		System.out.println("\nPLAYERS (ListTest):");
		System.out.println(lplayers.contains(testplayer1) ? "true" : "false");
		System.out.println(lplayers.contains(testplayer2) ? "true" : "false");
		
		System.out.println("\nPLAYERS (HashSetTest):");
		Set<ChessPlayer> splayers1 = new HashSet<>(lplayers);
		System.out.println(splayers1.contains(testplayer1) ? "true" : "false");
		System.out.println(splayers1.contains(testplayer2) ? "true" : "false");
		
		System.out.println("\nPLAYERS (TreeSetTest):");
		Set<ChessPlayer> splayers2 = new TreeSet<>(lplayers);
		for (ChessPlayer player : splayers2) {
			System.out.println(player);
		}
	}
}


