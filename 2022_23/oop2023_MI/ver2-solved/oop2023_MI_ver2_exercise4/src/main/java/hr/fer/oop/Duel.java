package hr.fer.oop;


public interface Duel<A,B> {
	
	public double rateA(A a);
	public double rateB(B b);
	public String battle(A a, B b);
}
