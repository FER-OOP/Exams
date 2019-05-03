package hr.fer.oop.midtermexam2019.task2;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class Tour {
	
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private Collection<Concert> concerts;
	
	public Tour(String name, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.concerts = new LinkedList<>();
	}

	public String getName() {
		return name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public Iterable<Concert> getConcerts() {
		return concerts;
	}
	
	public void addConcert(Concert concert) {
		concerts.add(concert);
	}
}
