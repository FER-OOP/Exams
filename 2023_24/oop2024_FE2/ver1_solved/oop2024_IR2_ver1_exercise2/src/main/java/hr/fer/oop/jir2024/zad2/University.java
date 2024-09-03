package hr.fer.oop.jir2024.zad2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class University {

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
	
	
	// 1. Metoda prima listu sveučilišta, a vraća naziv najstarijeg sveučilišta iz liste. 
	// Ako je takvih sveučilišta više, treba vratiti sve nazive, odvojene zarezom i razmakom. 
	// Npr. "UNIZG, OPENUNI".
	public static String getOldestUniversityName(List<University> list) {		
		return list.stream().filter(u -> u.founded== (list.stream().mapToInt(u1 -> u1.founded).min().getAsInt()))
				     .map(u -> u.name)
				     .collect(Collectors.joining(", "));
	}

	
	// 2. Metoda prima listu sveučilišta i raspon ranga (pretpostavite da je prvi broj uvijek manji od drugog) 
	// i vraća tok koji sadrži nazive država (bez duplikata) iz kojih dolaze sveučilišta čiji ARWU rang se nalazi u 
	// navedenom rasponu (uključivo). Tok treba biti poredan abecedno, od A do Z.
	public static Stream<String> getCountries(List<University> list, int startRank, int endRank) {
		return list.stream()
				   .filter(u -> (u.arwurank >= startRank && u.arwurank <= endRank))
				   .map(u -> u.country)
				   .distinct()
				   .sorted();		
	}

	
	// 3. Metoda prima tok podataka sa sveučilištima i naziv države, a vraća naziv sveučilišta koje je najbolje rangirano u toj državi, 
	// i to na sljedeći način: prvo se gleda THE rank, a ako je jednak onda se gleda bolji ARWU rank. Pretpostavite da stream nije prazan
	// i da neće biti više sveučilišta s ista oba ranka. Nemojte zaboraviti da je sveučilište s nižim rangom bolje! 
	public static String getBestForCountry(Stream<University> stream, String countryName) {		
		Comparator<University> BY_THE = (u1, u2)->(Integer.compare(u1.therank, u2.therank));
		Comparator<University> BY_ARWU = (u1, u2)->(Integer.compare(u1.arwurank, u2.arwurank));
		return stream.filter(u -> u.country.equals(countryName))
				     .sorted(BY_THE.thenComparing(BY_ARWU))
				     .findFirst()
				     .get()
				     .name;
	}

	
	// 4. Metoda prima tok podataka sa sveučilištima, a vraća mapu u kojoj je ARWU ključ, a vrijednost je naziv 
	// sveučilišta koje ima taj ranking. Ako više sveučilišta ima isti ranking, trebaju biti odvojeni zarezom i razmakom, npr. "UNIZG, OPENUNI".
	public static Map<Integer, String> getARWUMap(Stream<University> stream) {
		return stream.collect(Collectors.toMap(u -> u.arwurank, u -> u.name, (n1, n2) -> n1 + ", " + n2));
	}
	

	// 5. Metoda prima tok podataka sa sveučilištima i zemlju, a vraća srednju vrijednost THE ranga svih sveučilišta iz te zemlje. 
	// Ako nema ni jednog sveučilišta u toj zemlji, vraća -1.
	public static double getAvgTHEforCountry(Stream<University> stream, String countryName) {
		return stream.filter(u -> u.country.equals(countryName))
				     .mapToInt(u -> u.therank)
				     .average()
				     .orElse(-1);
	}
	
}
