package hr.fer.oop.zad1;

class Regional extends Airline {
	private int numberOfPremiumMembers;
	private int numberOfExternalSponsors;

	public Regional(String name, String[] fleet, int numberOfPremiumMembers, int numberOfExternalSponsors) {
		super(name, fleet);
		this.numberOfPremiumMembers = numberOfPremiumMembers;
		this.numberOfExternalSponsors = numberOfExternalSponsors;
	}

	public int getNumberOfPremiumMembers() {
		return numberOfPremiumMembers;
	}

	public void setNumberOfPremiumMembers(int numberOfPremiumMembers) {
		this.numberOfPremiumMembers = numberOfPremiumMembers;
	}

	public int getNumberOfExternalSponsors() {
		return numberOfExternalSponsors;
	}

	public void setNumberOfExternalSponsors(int numberOfExternalSponsors) {
		this.numberOfExternalSponsors = numberOfExternalSponsors;
	}

	@Override
	public boolean availabilityOfPromotionalPrices() {
		if (numberOfPremiumMembers > 10 && numberOfExternalSponsors > 0) return true;
		else return false;
	}

	@Override
	public String covid19Info() {
		return "Contact the regional COVID info number.";
	}

}
