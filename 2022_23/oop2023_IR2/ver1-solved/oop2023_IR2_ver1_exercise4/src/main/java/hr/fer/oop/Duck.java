package hr.fer.oop;

public class Duck extends Toy {
	private String color;

	public Duck(int weight, String color) {
		super(weight);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
