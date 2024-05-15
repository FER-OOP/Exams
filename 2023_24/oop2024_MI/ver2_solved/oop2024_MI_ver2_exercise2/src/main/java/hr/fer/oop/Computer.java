package hr.fer.oop;


public abstract class Computer {
	
	public String model;
	
	private double mhz;

	public Computer(String model, double speed) {
		this.model = model;
		this.mhz = speed;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	public double gigahertz() {
		return mhz / 1000;
	}


}
