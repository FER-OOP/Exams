package hr.fer.oop.vehicles;

public class Car extends RentableVehicle{
	private String euroStd;
	@Override
	public double getPrice(boolean isVIP) {
		return getRegularPrice() * (isVIP ? 0.9 : 1);
	}
	public String getEuroStd() {
		return euroStd;
	}
	public void setEuroStd(String euroStd) {
		this.euroStd = euroStd;
	}
}
