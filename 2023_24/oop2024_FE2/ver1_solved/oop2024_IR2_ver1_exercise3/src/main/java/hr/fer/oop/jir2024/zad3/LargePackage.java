package hr.fer.oop.jir2024.zad3;

public class LargePackage extends Package implements Trackable{
	
	private PackagingType packagingType; 
	private int trackingNumber=-1;

	public LargePackage(int weight, int dimensions, String sender, String receiver, Status status, PackagingType packagingType) {
		super(weight, dimensions, sender, receiver, status);
		this.packagingType = packagingType;
	}

	public PackagingType getPackagingType() {
		return packagingType;
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
