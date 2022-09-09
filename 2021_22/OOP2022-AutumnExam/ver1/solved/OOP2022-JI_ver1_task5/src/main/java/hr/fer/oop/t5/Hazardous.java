package hr.fer.oop.t5;

public interface Hazardous {
	
	public default String storageInstructions() {
		return "away from flamable material!";
	};

}
