package hr.fer.oop.wearables;

public class Purse extends Bag {
	public Purse(String id, int volume, int weight, MaterialType material) {
		super(id, volume, weight, material);		
	}
	
	@Override
	public boolean addWearable(Wearable thing) {
		if (thing instanceof Backpack) {
			throw new IllegalArgumentException("Cannot add Backpack into Purse");
		}
		return super.addWearable(thing);
	}
}
