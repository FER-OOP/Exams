package hr.fer.oop;

public class IncorrectArgumentNumberException extends ParseReadingException{
	
	public IncorrectArgumentNumberException(Throwable cause) {
		super(cause);
	}

	public IncorrectArgumentNumberException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public IncorrectArgumentNumberException() {
		super();
	}

}
