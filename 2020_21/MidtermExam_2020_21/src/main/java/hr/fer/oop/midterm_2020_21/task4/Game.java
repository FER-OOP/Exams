package hr.fer.oop.midterm_2020_21.task4;

import java.io.Closeable;
import java.io.IOException;

public class Game implements Closeable {	
	String name;
	int numberOfCopies;
	
	public Game(int numberOfCopies, String name) throws NoCopiesException {		
		this.name = name;
		System.out.println(name);
		if (numberOfCopies <= 0)
			throw new NoCopiesException("Number of copies must be at least 1!");
		else
			this.numberOfCopies = numberOfCopies;
	}

	public void buyGame(int num) {
		if (num > numberOfCopies)
			throw new IllegalArgumentException("Not enough copies!");
		else {
			System.out.println("Number of copies purchased: " + num);
			numberOfCopies = numberOfCopies - num;
		}
	}

	public int getNumOfCopies() {
		return numberOfCopies;
	}

	@Override
	public void close() throws IOException {
		System.out.println(name + " removed");
	}
}
