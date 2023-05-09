package hr.fer.oop;


public class RacingCar extends Car {
	
	private final int nitro;

	public RacingCar(String model, int power, int nitro) {
		super(model, power);
		this.nitro = nitro;
	}
	
	public int getNitro() {
		return nitro;
	}
	
	@Override
	public String toString() {
		return super.toString()+"-"+nitro;
	}

}
