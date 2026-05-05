package hr.fer.oop.stacklang.exception;

import hr.fer.oop.stacklang.StackLangCommand;

public class CommandException extends StackLangException {

	private final StackLangCommand command;

	public CommandException(Throwable cause, int line, StackLangCommand command) {
		super(cause, line);
		this.command = command;
	}

	public StackLangCommand getCommand() {
		return command;
	}

}
