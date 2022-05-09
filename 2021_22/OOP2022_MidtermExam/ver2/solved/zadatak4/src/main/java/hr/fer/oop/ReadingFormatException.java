package hr.fer.oop;

public class ReadingFormatException extends ParseReadingException{

	public ReadingFormatException(Throwable cause) {
		super(cause);
	}
	
	public ReadingFormatException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public ReadingFormatException() {
		super();
	}

}
