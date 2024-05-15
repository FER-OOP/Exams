package hr.fer.oop;


public final class Desktop extends Computer {
	
	protected String location;
	
	public Desktop(String model, double mhz, String location) {
		super(model, mhz);
		this.location = location;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
