package hr.fer.oop.fall_2017_18.task2;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Result> results = new LinkedList<>();
		results.add(new Result("Ivana", 100));		
		results.add(new Result("Klara", 150));
		results.add(new Result("Petar", 100));
		results.add(new Result("Ivana", 105));
		results.add(new Result("Vinko", 150));
		results.add(new Result("Klara", 180));
		results.add(new Result("Ivana", 105));
		results.add(new Result("Davor", 100));
		results.add(new Result("Ivana", 80));
		results.add(new Result("Zlatko", 95));
		results.add(new Result("Zlatko", 90));		
		results.add(new Result("Davor", 95));
		results.add(new Result("Lucija", 100));
		results.add(new Result("Ivana", 70));
		results.add(new Result("Ana", 80));
		results.add(new Result("Ana", 90));
		results.add(new Result("Eva", 90));
		HighScore.print(results);
	}

}
