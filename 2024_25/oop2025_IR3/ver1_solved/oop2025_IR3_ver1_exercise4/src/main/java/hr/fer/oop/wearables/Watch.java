package hr.fer.oop.wearables;

public class Watch implements Wearable {
	private final String id;
	private final int volume;
	private final int weight;

	public Watch(String id, int volume, int weight) {
		this.id = id;
		this.volume = volume;
		this.weight = weight;
		
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
}
