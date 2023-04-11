package iznimke;

public class NoUniqueSolutionException extends QuadraticException {

	public NoUniqueSolutionException(QuadraticEquation quadraticEquation) {
		super(quadraticEquation);
	}

}
