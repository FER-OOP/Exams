package hr.fer.oop.stacklang.exception;

public class UnsupportedCommandException extends StackLangException {

	private final String unsupportedCommand;

	public UnsupportedCommandException(int line, String command) {
		super(line);
		this.unsupportedCommand = command;
	}

	public String getUnsupportedCommand() {
		return unsupportedCommand;
	}

}
