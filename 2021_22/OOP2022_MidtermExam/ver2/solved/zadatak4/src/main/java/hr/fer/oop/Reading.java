package hr.fer.oop;

import java.time.LocalDate;

public class Reading {
	
	private Integer serialNumber;
	private Double readingValue;
	private LocalDate timestamp;

	public Reading(Integer serialNumber, Double readingValue, LocalDate timestamp) {
		super();
		this.serialNumber = serialNumber;
		this.readingValue = readingValue;
		this.timestamp = timestamp;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Double getReadingValue() {
		return readingValue;
	}

	public void setReadingValue(Double readingValue) {
		this.readingValue = readingValue;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
