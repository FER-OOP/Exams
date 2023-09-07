package hr.fer.oop;

public abstract class Toy {
	private int weight;

	public Toy(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
