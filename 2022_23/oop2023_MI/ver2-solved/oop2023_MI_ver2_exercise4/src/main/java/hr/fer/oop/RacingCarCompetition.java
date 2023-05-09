package hr.fer.oop;


public class RacingCarCompetition extends Competition<RacingCar,RacingCar> {
	
	@Override
	public double rateA(RacingCar a) {
		return (1.0d)*(super.rateA(a)+a.getNitro()+a.getPower())/3.0;
	}
	

}
