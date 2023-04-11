package iznimke;

public class Demo {

	public static void main(String[] args) {
		QuadraticEquation qe = new QuadraticEquation(2, 4, -30);

		// Kada bismo bilo koji od dva retka ispod odkomentirali, kod se ne bi preveo!
		//qe.getUniqueSolution();
		//qe.getTwoSolutions();

		try {
			double x = qe.getUniqueSolution();
			System.out.println("x = " + x);
		} catch(QuadraticException e) {
			info(e);
		}
		
		try {
			Solutions sol = qe.getTwoSolutions();
			System.out.println("Manje rješenje je:" + sol.getSmaller());
			System.out.println("Veće rješenje je:" + sol.getBigger());
		} catch(QuadraticException e) {
			info(e);
		}

		try {
			qe.getUniqueSolution();
		} catch(NoUniqueSolutionException ex) {
			System.out.println("Ovo očekujemo!");
		} catch(NoRealSolutionsException ex) {
			System.out.println("X!");
		}

		try {
			qe.getTwoSolutions();
		} catch(NoMultipleSolutionsException ex) {
			System.out.println("Y!");
		} catch(NoRealSolutionsException ex) {
			System.out.println("Z!");
		}
	}

	private static void info(QuadraticException e) {
		System.out.println("Iznimka: " + e.getClass().getName());
		QuadraticEquation qe = e.getQuadraticEquation();
		System.out.printf("  a=%f, b=%f, c=%f%n", qe.getA(), qe.getB(), qe.getC());
	}

}
