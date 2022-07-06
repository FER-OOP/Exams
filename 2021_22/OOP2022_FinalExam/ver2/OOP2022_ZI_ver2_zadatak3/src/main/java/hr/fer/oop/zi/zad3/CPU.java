package hr.fer.oop.zi.zad3;

public class CPU {

	private final int id;
	private final String name;
	private double clockSpeed = 1.0;
	private int cores = 1;
	private boolean hyperthreading;
	private int cost = 1;
	
	public CPU(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public CPU(int id, String name, double clockSpeed, int cores, int cost,
			boolean hyperthreading) {
		this(id, name);
		this.clockSpeed = clockSpeed;
		this.cores = cores;
		this.hyperthreading = hyperthreading;
		this.cost = cost;
	}

	public CPU(int id, String name, double clockSpeed, double overclockedSpeed, int cores, int cost) {
		this(id, name, clockSpeed, cores, cost, false);
	}

	public double getClockSpeed() {
		return clockSpeed;
	}

	public void setClockSpeed(double clockSpeed) {
		this.clockSpeed = clockSpeed;
	}


	public int getCores() {
		return cores;
	}

	public void setCores(int cores) {
		this.cores = cores;
	}

	public boolean hasHyperthreading() {
		return hyperthreading;
	}

	public void setHyperthreading(boolean hyperthreading) {
		this.hyperthreading = hyperthreading;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return name + ": clockSpeed=" + clockSpeed + ", cores=" + cores + ", hyperthreading="
				+ hyperthreading + ", cost=" + cost;
	}
	
	
}
