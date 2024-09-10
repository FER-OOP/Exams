package hr.fer.oop.games;

public class Billiard extends RentableEquipment {

	private BilliardType type;
	private boolean coinOperated;
	@Override
	public double getPrice(boolean isVIP) {
		return getRegularPrice() * (isVIP ? 0.85 : 1);
	}
	public BilliardType getType() {
		return type;
	}
	public void setType(BilliardType type) {
		this.type = type;
	}
	public boolean isCoinOperated() {
		return coinOperated;
	}
	public void setCoinOperated(boolean coinOperated) {
		this.coinOperated = coinOperated;
	}
	
}
