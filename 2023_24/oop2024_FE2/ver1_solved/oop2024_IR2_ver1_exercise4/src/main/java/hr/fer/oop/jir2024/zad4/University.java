package hr.fer.oop.jir2024.zad4;

import java.util.Comparator;
import java.util.Objects;

public class University implements Comparable<University> {

	private String name; // - naziv sveučilišta
	private String country; // - država u kojoj se sveučilište nalazi
	private int founded; //- godina osnivanja (cijeli broj)
	private int therank; // - trenutni rang sveučilišta na Times Higher Education World University Rankings listi (cijeli broj)
	private int arwurank; // - trenutni rang sveučilišta prema Academic Ranking of World Universities, tzv. "Šangajskoj listi" (cijeli broj)
	
	public University(String name, String country, int founded, int therank, int arwurank) {
		this.name = name;
		this.country = country;
		this.founded = founded;
		this.therank = therank;
		this.arwurank = arwurank;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public int getFounded() {
		return founded;
	}

	public int getTherank() {
		return therank;
	}

	public int getArwurank() {
		return arwurank;
	}
	
	public String toString() {
		return String.format("%s (%s, %d) THE: %d ARWU: %d", name, country, founded, therank, arwurank);
	}

	// Implementirajte metode koje su potrebne da bi se klasa University mogla ispravno koristiti u Javinim kolekcijama
	
	@Override
	public int hashCode() {
		return Objects.hash(name, country, founded);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		University other = (University) obj;
		return Objects.equals(country, other.country) && founded == other.founded && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(University other) {
		Comparator<University> c = 	BY_NAME.
									thenComparing(BY_COUNTRY).
									thenComparing((u1,u2) -> 
										Integer.compare(u2.founded, u1.founded));
		return c.compare(this,  other);
	}	

	//- komparator po nazivu, od manjeg prema većem (A do Z)
	public static final Comparator<University> BY_NAME = (u1, u2) -> u1.name.compareTo(u2.name);
	
	//– komparator po nazivu države (A - Z)
	public static final Comparator<University> BY_COUNTRY = (u1, u2) -> u1.country.compareTo(u2.country);
	
	//– komparator po Times Higher Education World University Rankings listi, od manjeg prema većem
	public static final Comparator<University> BY_THE = (u1, u2) -> Integer.compare(u1.therank, u2.therank);
	
	//– komparator po Academic Ranking of World Universities listi, od manjeg prema većem
	public static final Comparator<University> BY_ARWU = (u1, u2) -> Integer.compare(u1.arwurank, u2.arwurank);
	
}
