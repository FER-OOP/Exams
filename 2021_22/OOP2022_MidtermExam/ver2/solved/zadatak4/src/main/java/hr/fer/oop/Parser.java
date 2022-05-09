package hr.fer.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Parser {

	public static Reading parseInputString(String input) throws ParseReadingException {
		
		String [] parts = input.split(", ");
		
		
		if (parts.length == 3)
			return processTypeA(parts);

		else {
			parts = input.split(";");
			
			if (parts.length != 3)
				throw new IncorrectArgumentNumberException();
			else
				return processTypeB(parts);
		}	
		
	}
	
	public static Reading processTypeA(String [] parts) throws ReadingFormatException {
		Integer serialNo;
		Double readingValue;
		LocalDate date;
		
		try {
			serialNo = Integer.parseInt(parts[0].split(": ")[1]);
		} catch (Exception e) {
			throw new ReadingFormatException(e);
		}
		
		try {
			date = parseDateForManufacturerA(parts[1].split(": ")[1]);
		} catch (Exception e) {
			throw new ReadingFormatException(e);
		}
		
		try {
			readingValue = Double.parseDouble(parts[2].split(": ")[1].substring(0, parts[2].split(": ")[1].length()-1));
		} catch (Exception e) {
			throw new ReadingFormatException(e);
		}

		return new Reading(serialNo, readingValue, date);
	
	}
	
	public static Reading processTypeB (String [] parts) throws ReadingFormatException {
		Integer serialNo;
		Double readingValue;
		LocalDate date;
		
		try {
			serialNo = Integer.parseInt(parts[0]);
		} catch (Exception e) {
			throw new ReadingFormatException(e);
		}
		
		try {
			date = parseDateForManufacturerB(parts[1]);
		} catch (Exception e) {
			throw new ReadingFormatException(e);
		}
		
		try {
			readingValue = Double.parseDouble(parts[2]);
		} catch (Exception e) {
			throw new ReadingFormatException(e);
		}

		return new Reading(serialNo, readingValue, date);
		
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

//	public static void main(String[] args) throws ParseReadingException {
//
//
//			parseInputString(
//				"{serialNumber : 2223s, timestamp : 05-12-1992, currentReading : 284.3}");
//			
////			parseInputString(
////					"2223;12 13 1992;284.3");
//		
//		}

}
