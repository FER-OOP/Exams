package hr.fer.oop.midterm_2020_21.task4;

import java.io.IOException;

public class VideoGame extends Game {
	
	int sold;
	
	public VideoGame(int numOfCopies, String name) throws NoCopiesException {
		super(numOfCopies, name);
	}

	@Override
	public void buyGame(int num) {
		super.buyGame(num);
		sold += num;		
		System.out.println("Sold " + num + " copies.");
	}
	
	@Override
	public void close() throws IOException {		
		System.out.println("Video game " + name + " deleted.");
		super.close();
	}
}
