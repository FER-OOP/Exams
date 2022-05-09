package hr.fer.oop.zad1;

// add and fix everything except toString method

Aircraft {

	@Override
	public String toString() {
		return String.format("Aircraft model %s is produced %s", model, dateProduced);
	}
	
}

