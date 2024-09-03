package hr.fer.oop.jir2024.zad3;

public abstract class Package extends Item {

	private Status status;
	
	public Package(int weight, int dimensions, String sender, String receiver, Status status) {
		super(weight, dimensions, sender, receiver);
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}
	
}
