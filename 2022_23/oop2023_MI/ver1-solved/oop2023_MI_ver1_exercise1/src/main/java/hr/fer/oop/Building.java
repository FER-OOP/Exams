package hr.fer.oop;


public abstract class Building implements EnergyEfficiency {
	protected final String address;
	protected final int numberOfApartments;
	protected final int energyConsumption;

	public Building(String address, int numberOfApartments, int energyConsumption) {
        this.address = address;
        this.numberOfApartments = numberOfApartments;
        this.energyConsumption = energyConsumption;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfApartments() {
        return numberOfApartments;
    }
    public int getEnergyConsumption() {
	return energyConsumption;
    }
    
    public abstract String calculateEnergyClass();
    
    
}
