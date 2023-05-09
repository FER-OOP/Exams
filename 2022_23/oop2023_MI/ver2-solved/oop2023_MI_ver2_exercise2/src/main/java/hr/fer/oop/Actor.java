package hr.fer.oop;


public class Actor implements Person {
	private String name;
	private int birthYear;
	private int appearances;

	public Actor(String name, int birthYear, int appearances) {
		this.name = name;
		this.birthYear = birthYear;
		if(appearances>=0)
		this.appearances = appearances;
	}

	@Override
	public String toString() {
		return "Actor "+name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getBirthYear() {
		return birthYear;
	}

	public int getAppearances() {
		return appearances;
	}
}
