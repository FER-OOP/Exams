package hr.fer.oop;


public class ParseException extends RuntimeException {
	
	public ParseException(String problematicLine) {
		super(problematicLine);
	}

}
