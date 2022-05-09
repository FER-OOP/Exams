package hr.fer.oop.zad1;

abstract class Aircraft {
	private final String model;
	private final String dateProduced;

	public Aircraft(String model, String dateProduced) {
		this.model = model;
		this.dateProduced = dateProduced;
	}

	public String getModel() {
		return model;
	}

	public String getDateProduced() {
		return dateProduced;
	}
	
	public abstract Status aircraftStatus();

	@Override
	public String toString() {
		return String.format("Aircraft model %s is produced %s", model, dateProduced);
	}
	
}

