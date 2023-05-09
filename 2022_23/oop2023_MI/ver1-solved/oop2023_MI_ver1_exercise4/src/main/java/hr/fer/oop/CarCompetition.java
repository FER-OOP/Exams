package hr.fer.oop;


public class CarCompetition extends Competition<Car> {
	
	@Override
	public double rateA(Car a) {
		return (super.rateA(a)+a.getPower())/2;
	}
	@Override
	public double rateB(Car b) {
		return (super.rateB(b)+b.getPower())/2;
	}

}
