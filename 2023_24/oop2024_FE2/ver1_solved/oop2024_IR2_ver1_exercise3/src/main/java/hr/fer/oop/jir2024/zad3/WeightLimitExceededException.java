package hr.fer.oop.jir2024.zad3;

public class WeightLimitExceededException extends Exception {

	private static final long serialVersionUID = 1L;

	public WeightLimitExceededException() {
		super("Weight limit exceeded!");
	}

}
