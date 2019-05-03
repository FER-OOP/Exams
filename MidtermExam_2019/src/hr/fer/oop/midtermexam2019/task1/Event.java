package hr.fer.oop.midtermexam2019.task1;

public abstract class Event {

	private final String name;
	private final String location; 
	private String date;
	
	public Event(String name, String location, String date) {
		this.name = name;
		this.location = location;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
}
