package hr.fer.oop;


public class ResidentialBuilding extends Building {
	public int numberOfParkingSpots;

	public ResidentialBuilding(String address, int numberOfApartments, int energyConsumption, int numberOfParkingSpots) {
        super(address, numberOfApartments, energyConsumption);
        this.numberOfParkingSpots = numberOfParkingSpots;
    }

    
    public int getNumberOfParkingSpots() {
		return numberOfParkingSpots;
	}

    public boolean hasFreeParkingSpots() {
        return numberOfParkingSpots > numberOfApartments;
    }

    @Override
    public String calculateEnergyClass() {
        if (energyConsumption < 50) {
            return "A";
        } else if (energyConsumption < 90) {
            return "B";
        } else {
            return "C";
        }
    }
    
    @Override
    public boolean investigateEnergyEfficiency() {
        String energyClass = calculateEnergyClass();
        return energyClass.equals("A");
    }
}
