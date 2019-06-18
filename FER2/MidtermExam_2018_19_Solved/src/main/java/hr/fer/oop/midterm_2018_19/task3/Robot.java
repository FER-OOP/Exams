package hr.fer.oop.midterm_2018_19.task3;

public class Robot implements Player {
	private String serialNumber;
	private String model;
	private Person contactPerson;
	
	public Robot(String model, String serialNumber) {
		this.model = model;
		this.serialNumber = serialNumber;
	
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public String getModel() {
		return model;
	}
	
	public Person getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(Person contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Override
	public String getNickname() {
		return serialNumber;
	}
	
	
}
