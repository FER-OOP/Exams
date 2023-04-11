package iznimke;

public class QuadraticException extends Exception {

	private QuadraticEquation quadraticEquation;

	public QuadraticException(QuadraticEquation quadraticEquation) {
		super();
		this.quadraticEquation = quadraticEquation;
	}
	
	public QuadraticEquation getQuadraticEquation() {
		return quadraticEquation;
	}
}
