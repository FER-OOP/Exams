package hr.fer.oop.t3.items;

import java.time.LocalDate;

public interface Perishable {
	default public String getInstructions(){
		return "Keep in dry and cool place";
	}
	public LocalDate getBestBefore();
	public void setBestBefore(LocalDate bestBefore);
}
