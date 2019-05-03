package hr.fer.oop.midtermexam2019.task3;

public class Vinyl extends Record{

	private int size;
	
	public Vinyl(String artistName, String albumName, int year, int duration, int size) {
		super(artistName, albumName, year, duration);
		this.size = size;
	}

	public int getSize() {
		return size;
	}
	
}

