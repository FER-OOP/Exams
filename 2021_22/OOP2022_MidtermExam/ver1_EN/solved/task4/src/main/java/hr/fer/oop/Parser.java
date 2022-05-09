package hr.fer.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Parser {
	
	public static Reading parseInputString(String inputReadingString) throws ParseReadingException{
		
		Integer deviceId;
		LocalDate timestamp;
		SensorReadingValue [] data;
		
		String [] parts = inputReadingString.split(", ");
		
		if(parts.length < 3)
			throw new IncorrectReadingFormatException();
		
		else {
			
			try {
				deviceId = Integer.parseInt(parts[0].split(":")[1]);
			} catch (Exception e) {
				throw new FormatException(e);
			}
			
			try {
				timestamp = parseDate(parts[1].split(":")[1]);
			} catch (Exception e) {
				throw new FormatException(e);
			}
			
			data = new SensorReadingValue[parts.length-2];
			boolean atLeastOne = false;
			
			//fill sensorReadingValues
			for (int i=2, j=0;i<parts.length;i++,j++) {
				try {
					data[j] = new SensorReadingValue(parts[i].split(":")[0], parts[i].split(":")[1]);
					atLeastOne = true;
				} catch (Exception e) {
					data[j] = null;
				}
			}
			if(!atLeastOne)
				throw new ReadingsFormatException();	
		}
		
		return new Reading(deviceId, data, timestamp);
		
	}
	
	private static LocalDate parseDate (String dateA) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		dtf = dtf.withLocale( Locale.GERMAN );
		LocalDate date = LocalDate.parse(dateA, dtf);
		
		return date;
	}
	
//	public static void main(String[] args) throws ParseReadingException {
//		System.out.println(parseInputString("deviceId:123, timestamp:01-01-2000, temperature:20, humidity:2"));
//	}

}
