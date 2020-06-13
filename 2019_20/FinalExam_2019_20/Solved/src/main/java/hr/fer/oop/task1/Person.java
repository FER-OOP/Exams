package hr.fer.oop.task1;

import java.time.LocalDate;

public abstract class Person {

	private String name;
	private String oib;
	private LocalDate dateOfBirth;
	public Person(String oib, String name, LocalDate dateOfBirth) {
		this.oib = oib;
		this.name = name;
		this.dateOfBirth = dateOfBirth;		
	}
	public String getName() {
		return name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public String getOib() {
		return oib;
	}
	
	@Override
	public int hashCode() {
		return getOib().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (obj instanceof Person) {
			return getOib().equals(((Person) obj).getOib());
		}
		return false;
	}	
}
