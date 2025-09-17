package hr.fer.oop.wearables;

import java.util.LinkedList;
import java.util.List;

public abstract class Storage {
	private final MaterialType material;
	private final int capacity;
	private final List<Wearable> list = new LinkedList<>();

	protected Storage(MaterialType material, int capacity) {
		this.material = material;
		this.capacity = capacity;
	}

	public int getWeight() {
		int weight = 0;
		for(Wearable thing: list) {
			weight += thing.getWeight();
		}
		return weight;
	}

	public int getCapacity() {
		return capacity;
	}

	public MaterialType getMaterial() {
		return material;
	}
	
	public List<Wearable> wearables() {
		return List.copyOf(list);
	}
	
	public boolean removeWearable(String wearableId) {
		for(int i=0;i<list.size(); i++) {
			if (list.get(i).getId().equals(wearableId)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean addWearable(Wearable thing) {
		int totalVolume = 0;
		for(int i=0;i<list.size(); i++) {
			if (list.get(i).getId().equals(thing.getId())) {
				return false;
			}
			totalVolume += thing.getVolume();
		}
		if (totalVolume + thing.getVolume() > capacity)
			return false;
		list.add(thing);
		return true;
	}
}
