package hr.fer.oop.midterm_2017_18.task1.items;

import java.time.LocalDate;

public interface IPerishable {
	default public String getInstructions(){
		return "Keep in dry and cool place";
	}
	public LocalDate getBestBefore();
	public void setBestBefore(LocalDate bestBefore);
}
