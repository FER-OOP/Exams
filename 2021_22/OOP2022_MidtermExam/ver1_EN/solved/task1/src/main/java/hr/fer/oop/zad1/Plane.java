package hr.fer.oop.zad1;

class Plane extends Aircraft {
	private int capacity;
	private int[] motorsStatus;
	
	public Plane(String model, String dateProduced, int capacity, int[] motorsStatus) {
		super(model, dateProduced);
		this.capacity = capacity;
		this.motorsStatus = motorsStatus;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int[] getMotorsStatus() {
		return motorsStatus;
	}

	public void setMotorsStatus(int[] motorsStatus) {
		this.motorsStatus = motorsStatus;
	}

	@Override
	public Status aircraftStatus() {
		int counter = 0;
		for (int motor : motorsStatus) {
			if (motor < 100) {
				counter++;
				if (motor < 80) return Status.OUT_OF_SERVICE;
			}
		}
		if (counter == 0) return Status.FUNCTIONAL;
		else return Status.NEED_CHECK;
	}
	
	@Override
	public String toString() {
		return String.format("%s and has %d motors and capacity of %d.", super.toString(), motorsStatus.length, capacity);
	}

}
