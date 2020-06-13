package hr.fer.oop.task1;

public class Robot implements Resource {
	private String id;
	private int hours = 0;

	public Robot(String id) {
		this.id = id;
		
	}
	
	public String getId() {
		return id;
	}

	@Override
	public int getHours() {
		return hours;
	}

	@Override
	public void addHours(int hours) {
		this.hours += hours;		
	}

	@Override
	public void resetHours() {
		hours = 0;
	}
	
	public void doJob(byte[] program) {	
	}
}
