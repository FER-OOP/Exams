package hr.fer.oop.stacklang.exception;

public class NotEnoughArgumentsException extends RuntimeException {

	private final int numOfArguments;
	private final int expectedNumOfArguments;

	public NotEnoughArgumentsException(int numOfArguments, int expectedNumOfArguments) {
		this.numOfArguments = numOfArguments;
		this.expectedNumOfArguments = expectedNumOfArguments;
	}

	public NotEnoughArgumentsException(int expectedNumOfArguments) {
		this(0, expectedNumOfArguments);
	}

	public int getNumOfArguments() {
		return numOfArguments;
	}

	public int getExpectedNumOfArguments() {
		return expectedNumOfArguments;
	}

}
