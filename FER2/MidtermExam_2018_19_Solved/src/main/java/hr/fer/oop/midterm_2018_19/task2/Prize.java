package hr.fer.oop.midterm_2018_19.task2;

import java.util.LinkedList;
import java.util.List;

public class Prize {
	private String description;
	private double value;
	private List<String> winners;	
	
	public Prize(String description, double value) {
		this.description = description;
		this.value = value;		
		winners = new LinkedList<>();
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public List<String> getWinners() {
		return winners;
	}
	public void setWinners(List<String> winners) {
		this.winners = winners;
	}
}
