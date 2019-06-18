package hr.fer.oop.midtermexam2019.task2;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Concert {

	private String city;
	private String country;
	private LocalDate concertDate;
	private Set<String> supportingBands;
	
	public Concert(String city, String country, LocalDate concertDate) {
		this.city = city;
		this.country = country;
		this.concertDate = concertDate;
		this.supportingBands = new LinkedHashSet<>();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getConcertDate() {
		return concertDate;
	}

	public void setConcertDate(LocalDate concertDate) {
		this.concertDate = concertDate;
	}

	public Set<String> getSupportingBands() {
		return supportingBands;
	}

	public void setSupportingBands(Set<String> supportingBands) {
		this.supportingBands = supportingBands;
	}

	@Override
	public String toString() {
		return "Concert [city=" + city + ", country=" + country + ", concertDate=" + concertDate + ", supportingBands="
				+ supportingBands + "]";
	}
	
}
