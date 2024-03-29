package hr.fer.oop;

import java.util.Objects;

public class Consumer {
	
	private String firstName;
	private String lastName;
	private int rewardPoints;
	private int membershipYears;

	public Consumer(String firstName, String lastName, int rewardPoints, int membershipYears) {
    	this.firstName = firstName;
		this.lastName = lastName;
    	this.rewardPoints = rewardPoints;
    	this.membershipYears = membershipYears;	
	}
		
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getRewardPoints() {
		return rewardPoints;
	}
	
	public int getMembershipYears()  {
		return membershipYears;
	}	
	
	@Override
	public boolean equals(Object o) { //generated by IDE!!!
		if (this == o) return true;
		if (o == null) return false;
		if (!(o instanceof Consumer)) return false;
		Consumer consumer = (Consumer) o;
		return firstName.equals(consumer.firstName) && lastName.equals(consumer.lastName);
	}
	
    @Override
    public int hashCode() { //generated by IDE!!!
        return Objects.hash(firstName, lastName);
    }

	@Override
	public String toString() {
		return String.format("%s %s [points: %d, years: %d]", firstName, lastName, rewardPoints, membershipYears);
	}	
	
}
