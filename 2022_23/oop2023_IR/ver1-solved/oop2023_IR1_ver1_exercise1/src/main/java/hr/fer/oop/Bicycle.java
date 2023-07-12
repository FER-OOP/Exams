package hr.fer.oop;

public class Bicycle extends AbstractTransport {
	protected int numWheels;
	
	public Bicycle(String name, int numWheels) {
		super(name);
		if(numWheels > 0)
			this.numWheels = numWheels; 
	}

	@Override
	public double calculateCO2(double distance) {
		return 0;
	}

	@Override
	public String toString() {
		return String.format("%s is a bicycle with %d wheel(s)", super.toString(), numWheels);
	}
	
}
