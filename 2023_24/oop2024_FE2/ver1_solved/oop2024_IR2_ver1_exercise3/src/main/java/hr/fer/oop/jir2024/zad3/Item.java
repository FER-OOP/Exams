package hr.fer.oop.jir2024.zad3;

public abstract class Item {
	
	private int weight;
	private int dimensions;
	
	private String sender;
	private String receiver;
	
	public Item(int weight, int dimensions, String sender, String receiver) {
		this.weight = weight;
		this.dimensions = dimensions;
		this.sender = sender;
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}
	
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getWeight() {
		return weight;
	}

	public int getDimensions() {
		return dimensions;
	}

	@Override
	public String toString() {
		return String.format("Item from: %s, to: %s, weight: %d, dim: %d", sender, receiver, weight, dimensions);
	}
	
}
