package hr.fer.oop.t5;

public abstract class Container {

	private String id;
	private int volume;
	private int occupiedVolume;
	
	public Container(String id, int volume) {
		this.id = id;
		this.volume = volume;
		this.occupiedVolume = 0;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getId() {
		return id;
	}

	public int getOccupiedVolume() {
		return occupiedVolume;
	}

	public void setOccupiedVolume(int occupiedVolume) {
		this.occupiedVolume = occupiedVolume;
	}
	
	public boolean add(int v) {
		// TO-DO...
		return false;
	}
	
	// TO-DO...
	public void empty() {
		// TO-DO...
	}
	
	@Override
	public String toString() {
		return "Container [id=" + id + ", volume=" + volume + "]";
	}
	
}
