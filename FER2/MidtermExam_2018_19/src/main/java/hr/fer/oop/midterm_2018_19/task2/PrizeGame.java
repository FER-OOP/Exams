package hr.fer.oop.midterm_2018_19.task2;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class PrizeGame {
	private String name;
	private LocalDate drawDate;
	private Collection<Prize> prizes;
	
	public PrizeGame(String name, LocalDate drawDate) {
		this.name = name;
		this.drawDate = drawDate;
		this.prizes = new LinkedList<>();
	}
	

	public String getName() {
		return name;
	}
	
	public LocalDate getDrawDate() {
		return drawDate;
	}

	public Iterable<Prize> getPrizes() {
		return prizes;
	}

	public Prize addPrize(String description, double value) {
		Prize p = new Prize("16L gaziranih sokova", 250);
		this.prizes.add(p);
		return p;		
	}
}
