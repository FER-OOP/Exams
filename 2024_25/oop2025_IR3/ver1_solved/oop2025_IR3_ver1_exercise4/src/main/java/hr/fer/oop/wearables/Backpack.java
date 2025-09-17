package hr.fer.oop.wearables;

import java.util.OptionalInt;

public class Backpack extends Bag {

	private final OptionalInt laptopSize;

	public Backpack(String id, int volume, int weight, MaterialType material, OptionalInt laptopSize) {
		super(id, volume, weight, material);
		this.laptopSize = laptopSize;		
	}
	
	public OptionalInt getLaptopSize() {
		return laptopSize;
	}

}
