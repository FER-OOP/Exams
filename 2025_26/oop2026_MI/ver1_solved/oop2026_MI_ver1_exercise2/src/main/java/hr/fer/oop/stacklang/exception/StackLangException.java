package hr.fer.oop.stacklang.exception;

public abstract class StackLangException extends Exception {

	private final int line;

	public StackLangException(int line) {
		super();
		this.line = line;
	}

	public StackLangException(Throwable cause, int line) {
		super(cause);
		this.line = line;
	}

	public int getLine() {
		return line;
	}

}
