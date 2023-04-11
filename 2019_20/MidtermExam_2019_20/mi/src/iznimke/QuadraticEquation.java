package iznimke;

public class QuadraticEquation {

	private double a;
	private double b;
	private double c;
	private double d;
	
	public QuadraticEquation(double a, double b, double c) {
		if(Math.abs(a)<1E-6) throw new IllegalArgumentException("a ne smije biti nula.");
		this.a = a;
		this.b = b;
		this.c = c;
		d = b*b-4*a*c;
	}

	public double getA() {
		return a;
	}
	
	public double getB() {
		return b;
	}
	
	public double getC() {
		return c;
	}
	
	public double getUniqueSolution() throws NoRealSolutionsException, NoUniqueSolutionException {
		if(d<0) throw new NoRealSolutionsException(this);
		if(d>1E-6) throw new NoUniqueSolutionException(this);
		
		return -b/(2*a);
	}
	
	public Solutions getTwoSolutions() throws NoRealSolutionsException, NoMultipleSolutionsException {
		if(d<0) throw new NoRealSolutionsException(this);
		if(d<=1E-6) throw new NoMultipleSolutionsException(this);
		
		double sqrtd = Math.sqrt(d);
		return new Solutions((-b-sqrtd)/(2*a), (-b+sqrtd)/(2*a));
	}
}
