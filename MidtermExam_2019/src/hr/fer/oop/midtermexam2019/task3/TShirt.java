package hr.fer.oop.midtermexam2019.task3;

public class TShirt extends Item {
	
	private String bandName;
	
	public TShirt(String bandName, int year) {
		super(year);
		this.bandName = bandName;
	}
	public String getBandName() {
		return bandName;
	}
}
