package hr.fer.oop.games;

public class MiniGolf extends Equipment{
	private int holes;
	@Override
	public double getPrice(boolean isVIP) {
		return getRegularPrice() * (isVIP ? 0.95 : 1);
	}
	public int getHoles() {
		return holes;
	}
	public void setHoles(int holes) {
		this.holes = holes;
	}	
}
