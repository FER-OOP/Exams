package hr.fer.oop;

import java.util.Objects;


public class DisabilityRecord {
	
	private String personName;

	private Disability disability;

	private double rating;
	
	public DisabilityRecord(String personName, Disability disability, double rating) {
		super();
		this.personName = personName;
		this.disability = disability;
		this.rating = rating;
	}


	public String getPersonName() {
		return personName;
	}

	public Disability getDisability() {
		return disability;
	}

	public void setDisability(Disability disability) {
		this.disability = disability;
	}

	public double getRating() {
		return rating;
	}
	
	@Override
	public String toString() {
		return String.format("%s -> %s (%.1f%%)", personName, disability, rating);
	}



	@Override
	public int hashCode() {
		return Objects.hash(disability, personName, rating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisabilityRecord other = (DisabilityRecord) obj;
		return disability == other.disability && Objects.equals(personName, other.personName)
				&& Math.abs(rating- other.rating)< 1e-8;
	}
	
	
	
	
	
	

}
