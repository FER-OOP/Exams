package hr.fer.oop;


public class Competition<A extends Vehicle, B extends RacingCar> implements Duel<A, B> {

	@Override
	public double rateA(A a) {
		return a.getName().length();
	}
	
	@Override
	public double rateB(B b) {
		return 1.0*(b.getName().length() + b.getNitro()+b.getPower())/3.0;
	}
	@Override
	public String battle(A a, B b) {
		int result = -Double.compare(rateA(a), rateB(b));
		if(result == 0) return "DRAW";
		if(result<0) return a.toString();
		return b.toString();
	}
	




}
