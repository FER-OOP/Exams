package hr.fer.oop;

public class Ball extends Toy {
	private int diameter;

	public Ball(int weight, int diameter) {
		super(weight);
		this.diameter = diameter;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
}
