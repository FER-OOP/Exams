package hr.fer.oop;


public final class Laptop extends Computer {
	
	private int batteryCapacity;
	
	public Laptop(String model, double mhz, int batteryCapacity) {
		super(model, mhz);
		this.batteryCapacity = batteryCapacity;
	}
	
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	
}
