package hr.fer.oop.midtermexam2019.task2;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TourManager {
	
	public static void addSupportingBandsByCountry(Tour tour, Set<String> supportingBands, Set<String> countries) {
		for (Concert concert: tour.getConcerts()) {
			if (countries.contains(concert.getCountry())) {
				TreeSet<String> newSupportingBands = new TreeSet<String>(concert.getSupportingBands());
				newSupportingBands.addAll(supportingBands);
				concert.setSupportingBands(newSupportingBands);
			}
		}
	}
	
	public static void printSupportingBandsFromTimespan(Tour tour, LocalDate startDate, LocalDate endDate) {
		Set<String> supportingBands = new HashSet<>();
		
		for (Concert concert: tour.getConcerts()) {
			if (!concert.getConcertDate().isBefore(startDate) && !concert.getConcertDate().isAfter(endDate)) {
				supportingBands.addAll(concert.getSupportingBands());
			}
		}
		
		for (String band: supportingBands) {
			System.out.println(band);
		}
	}
	
}
