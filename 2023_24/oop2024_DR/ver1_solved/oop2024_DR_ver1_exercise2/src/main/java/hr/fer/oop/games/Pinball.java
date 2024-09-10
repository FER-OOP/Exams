package hr.fer.oop.games;

public class Pinball extends RentableEquipment{
	private String manufacturer;
	private String genre;
	@Override
	public double getPrice(boolean isVIP) {
		return getRegularPrice() * (isVIP ? 0.9 : 1);
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
