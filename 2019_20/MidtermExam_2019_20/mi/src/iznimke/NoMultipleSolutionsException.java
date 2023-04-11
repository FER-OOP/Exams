package iznimke;

public class NoMultipleSolutionsException extends QuadraticException {

	public NoMultipleSolutionsException(QuadraticEquation quadraticEquation) {
		super(quadraticEquation);
	}

}
