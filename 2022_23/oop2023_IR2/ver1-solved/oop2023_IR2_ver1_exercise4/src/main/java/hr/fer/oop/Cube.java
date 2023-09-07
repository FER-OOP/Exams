package hr.fer.oop;

public class Cube extends Toy {
	private int width;

	public Cube(int weight, int width) {
		super(weight);
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
