package hr.fer.oop.jir2024.zad3;

public class SmallPackage extends Package{

	private boolean cashOnDelivery;
	
	public SmallPackage(int weight, int dimensions, String sender, String receiver, Status status, boolean cashOnDelivery) {
		super(weight, dimensions, sender, receiver, status);
		this.cashOnDelivery = cashOnDelivery;
	}

	public boolean isCashOnDelivery() {
		return cashOnDelivery;
	}
	
}
