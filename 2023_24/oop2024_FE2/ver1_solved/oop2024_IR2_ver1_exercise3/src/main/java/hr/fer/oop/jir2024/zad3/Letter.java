package hr.fer.oop.jir2024.zad3;

public class Letter extends Item implements Trackable{

	private int trackingNumber=-1;
	
	public Letter(int weight, int dimensions, String sender, String receiver) throws WeightLimitExceededException {
		super(weight, dimensions, sender, receiver);
		if (weight > 500)
			throw new WeightLimitExceededException();
	}

	@Override
	public int getTrackingNumber() {
		return trackingNumber;
	}

	@Override
	public void setTrackingNumber(int trackingNumber) {
		this.trackingNumber = trackingNumber;		
	}

}
