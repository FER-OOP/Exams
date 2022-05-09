package hr.fer.oop.zad1;

class CameraDrone extends Aircraft implements Unmanned {
	private final int range; //km
	private int[] qualities;

	public CameraDrone(String model, String dateProduced, int range, int[] qualities) {
		super(model, dateProduced);
		this.range = range;
		this.qualities = qualities;
	}

	public int[] getQualities() {
		return qualities;
	}

	public void setQualities(int[] qualities) {
		this.qualities = qualities;
	}

	public int getRange() {
		return range;
	}

	@Override
	public double coverArea(Number height) {
		return height.doubleValue() * range;
	}

	@Override
	public Status aircraftStatus() {
		double sum = 0;
		for (int quality : qualities) {
			sum += quality;
		}
		double average = sum / qualities.length;
		if (average < 50) return Status.OUT_OF_SERVICE;
		else if (average >= 50 && average <= 70) return Status.NEED_CHECK;
		else return Status.FUNCTIONAL;
	}

	@Override
	public String toString() {
		return String.format("%s and has %d elements.", super.toString(), qualities.length);
	}

}
