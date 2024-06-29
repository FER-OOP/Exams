package hr.fer.oop.vehicles;

public class Truck extends Vehicle{
	private int maxLoad;
	@Override
	public double getPrice(boolean isVIP) {
		return getRegularPrice() * (isVIP ? 0.95 : 1);
	}
	public int getMaxLoad() {
		return maxLoad;
	}
	public void setMaxLoad(int maxLoad) {
		this.maxLoad = maxLoad;
	}	
}
