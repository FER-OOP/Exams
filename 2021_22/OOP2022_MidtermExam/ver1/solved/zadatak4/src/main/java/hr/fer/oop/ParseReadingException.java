package hr.fer.oop;

abstract public class ParseReadingException extends Exception{

	public ParseReadingException(Throwable cause) {
		super(cause);
	}
	
	public ParseReadingException() {
		super();
	}
}
