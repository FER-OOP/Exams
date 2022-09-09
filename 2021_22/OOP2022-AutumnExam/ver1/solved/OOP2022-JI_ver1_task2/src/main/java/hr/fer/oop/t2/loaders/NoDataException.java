package hr.fer.oop.t2.loaders;

public class NoDataException extends Exception {
	public NoDataException(String string) {
		super(string);
	}
	public NoDataException(Exception e) {
		super(e);
	}
}
