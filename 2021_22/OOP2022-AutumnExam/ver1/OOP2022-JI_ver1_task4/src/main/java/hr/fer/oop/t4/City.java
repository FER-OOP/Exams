package hr.fer.oop.t4;

public class City {

	private String name;
	private String asciiName;
	private double lat;
	private double lng;
	private String countryName;
	private String countryISO2;
	private String countryISO3;
	private CityType capitalType;
	private int population;
	private int id;
	
	public City(String name, String asciiName, double lat, double lng, String countryName, String countryISO2,
			String countryISO3, CityType capitalType, int population, int id) {
		this.name = name;
		this.asciiName = asciiName;
		this.lat = lat;
		this.lng = lng;
		this.countryName = countryName;
		this.countryISO2 = countryISO2;
		this.countryISO3 = countryISO3;
		this.capitalType = capitalType;
		this.population = population;
		this.id = id;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAsciiName() {
		return asciiName;
	}

	public void setAsciiName(String asciiName) {
		this.asciiName = asciiName;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryISO2() {
		return countryISO2;
	}

	public void setCountryISO2(String countryISO2) {
		this.countryISO2 = countryISO2;
	}

	public String getCountryISO3() {
		return countryISO3;
	}

	public void setCountryISO3(String countryISO3) {
		this.countryISO3 = countryISO3;
	}

	public CityType getCapitalType() {
		return capitalType;
	}

	public void setCapitalType(CityType capitalType) {
		this.capitalType = capitalType;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", asciiName=" + asciiName + ", lat=" + lat + ", lng=" + lng + ", countryName="
				+ countryName + ", countryISO2=" + countryISO2 + ", countryISO3=" + countryISO3 + ", capitalType="
				+ capitalType + ", population=" + population + ", id=" + id + "]";
	}
	
}
