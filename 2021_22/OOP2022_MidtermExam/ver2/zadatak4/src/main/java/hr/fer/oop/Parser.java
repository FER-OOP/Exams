package hr.fer.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Parser {

	public static Reading parseInputString(String input) throws ParseReadingException {
		
	}
	
	private static LocalDate parseDateForManufacturerA (String dateA) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		dtf = dtf.withLocale( Locale.GERMAN );
		LocalDate date = LocalDate.parse(dateA, dtf);
		
		return date;
	}
	
	private static LocalDate parseDateForManufacturerB (String dateB) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM dd yyyy");
		dtf = dtf.withLocale( Locale.GERMAN );
		LocalDate date = LocalDate.parse(dateB, dtf);
		
		return date;
	}

}
