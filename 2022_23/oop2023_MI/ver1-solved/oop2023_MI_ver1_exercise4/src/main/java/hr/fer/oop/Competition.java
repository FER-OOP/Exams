package hr.fer.oop;


public class Competition<T extends Vehicle> implements Duel<T, T> {

	@Override
	public double rateA(T a) {
		return a.getName().length();
	}
	
	@Override
	public double rateB(T b) {
		return b.getName().length();
	}
	@Override
	public String battle(T a, T b) {
		int result = -Double.compare(rateA(a), rateB(b));
		if(result == 0) return "DRAW";
		if(result<0) return a.toString();
		return b.toString();
	}
	




}
