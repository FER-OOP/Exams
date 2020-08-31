package hr.fer.oop.task1;

import java.time.LocalDate;

public class Competitor extends Person implements Identifiable
{
	private int competitorID;
	
	public Competitor(String name, String surname, LocalDate dateOfBirth, int height, int weight, int competitorID)
	{
		super(name, surname, dateOfBirth, height, weight);
		this.competitorID = competitorID;
	}
	
	@Override
	public int createID()
	{
		//TO DO: write a concrete ID generator for Person class
		this.competitorID = 0;
		return 0;
	}
	
	public int getID()
	{
		return competitorID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + competitorID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competitor other = (Competitor) obj;
		if (competitorID != other.competitorID)
			return false;
		return true;
	}	
	
}
