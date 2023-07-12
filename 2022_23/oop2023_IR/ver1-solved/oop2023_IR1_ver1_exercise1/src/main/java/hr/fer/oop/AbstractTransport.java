package hr.fer.oop;

abstract class AbstractTransport implements Transport {
	private String name;
	
	public AbstractTransport(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Transport %s", name );
	}

	@Override
	public String move() {
		return String.format("The %s is moving.", name);
	}

}
