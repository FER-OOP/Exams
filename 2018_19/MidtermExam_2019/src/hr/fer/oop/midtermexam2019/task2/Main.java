package hr.fer.oop.midtermexam2019.task2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Concert concert1 = new Concert("Pula", "Croatia", LocalDate.of(2019, 6, 18));
		Set<String> supportingBandsCro = new LinkedHashSet<String>(Arrays.asList("Frank Carter & The Rattlesnakes"));
		concert1.setSupportingBands(supportingBandsCro);

		Concert concert2 = new Concert("Pula", "Croatia", LocalDate.of(2019, 6, 19));
		concert2.setSupportingBands(supportingBandsCro);
		
		Concert concert3 = new Concert("Horsens", "Denmark", LocalDate.of(2019, 6, 25));
		Set<String> supportingBandsDk = new LinkedHashSet<String>(Arrays.asList("The Minds of 99", "Frank Carter & The Rattlesnakes"));
		concert3.setSupportingBands(supportingBandsDk);
		
		Concert concert4 = new Concert("Bergen", "Norway", LocalDate.of(2019, 6, 27));
		Set<String> supportingBandsNo = new LinkedHashSet<String>(Arrays.asList("Kvelertak", "Frank Carter & The Rattlesnakes"));
		concert4.setSupportingBands(supportingBandsNo);
		
		Tour tour = new Tour("Europe 2019", LocalDate.of(2019, 6, 15), LocalDate.of(2019, 8, 21));
		tour.addConcert(concert1);
		tour.addConcert(concert2);
		tour.addConcert(concert3);
		tour.addConcert(concert4);		
		
		TourManager.printSupportingBandsFromTimespan(tour, LocalDate.of(2019, 6, 18), LocalDate.of(2019, 6, 27));
		
		Set<String> supportingBandsNew = new LinkedHashSet<String>(Arrays.asList("Slaves"));
		Set<String> countries = new LinkedHashSet<String>(Arrays.asList("Croatia", "Denmark"));
		TourManager.addSupportingBandsByCountry(tour, supportingBandsNew, countries);
		
		for (Concert concert: tour.getConcerts()) {
			System.out.println(concert);
		}
	}

}

