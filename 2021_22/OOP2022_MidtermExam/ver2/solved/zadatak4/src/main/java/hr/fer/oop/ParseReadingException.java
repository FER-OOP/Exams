package hr.fer.oop;

public abstract class ParseReadingException extends Exception{

	public ParseReadingException(Throwable cause) {
		super(cause);
	}

	public ParseReadingException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public ParseReadingException() {
		super();
	}

}
