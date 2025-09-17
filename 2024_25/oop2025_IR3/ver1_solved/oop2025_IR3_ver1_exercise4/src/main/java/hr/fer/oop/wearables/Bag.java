package hr.fer.oop.wearables;

public class Bag extends WearableStorage implements Wearable {
	private final String id;
	private final int volume;
	private final int weight;
	private final MaterialType material;

	public Bag(String id, int volume, int weight, MaterialType material) {
		super(material, volume);
		switch(material) {
			case Metal:
			case Gold:
			case Silver:
			case Glass:
				throw new IllegalArgumentException("Invalid material type: " + material);
			default:
				break;
		}
		this.id = id;
		this.volume = volume;
		this.weight = weight;
		this.material = material;
		
	}

	public int getVolume() {
		return volume;
	}

	public int getWeight() {
		return weight;
	}

	public String getId() {
		return id;
	}
	
	public MaterialType getMaterial() {
		return material;
	}
}
