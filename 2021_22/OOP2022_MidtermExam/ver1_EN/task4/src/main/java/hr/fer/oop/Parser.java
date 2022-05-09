package hr.fer.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Parser {
	
	public static Reading parseInputString(String inputReadingString) throws ParseReadingException{
		
	}
	
	private static LocalDate parseDate (String dateA) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		dtf = dtf.withLocale( Locale.GERMAN );
		LocalDate date = LocalDate.parse(dateA, dtf);
		
		return date;
	}

}
