package hr.fer.oop.jir2024.zad3;

public interface Trackable {
	
	public int getTrackingNumber();
	public void setTrackingNumber(int trackingNumber);
	
	default String getTrackingInformation() {
		if (getTrackingNumber()!=-1)
			return "Tracking number: " + getTrackingNumber();
		else 
			return "Tracking information not available";
	}
}
