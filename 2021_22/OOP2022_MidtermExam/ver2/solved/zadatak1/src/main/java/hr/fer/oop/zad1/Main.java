package hr.fer.oop.zad1;

public class Main {

	public static void main(String[] args) {
		FlagCarriers croatiaAirlines = new FlagCarriers("Croatia Airlines", new String[]{"Airbus A 320 - 200", "Airbus A 319 - 100", "Dash 8-Q400"}, 60);
		System.out.println(croatiaAirlines.toString());
		System.out.println(croatiaAirlines.covid19Info());
		System.out.println("PROMOTIONAL PRICES:");
		System.out.println(croatiaAirlines.availabilityOfPromotionalPrices());
		croatiaAirlines.setAverageFleetOccupancy(20);
		System.out.println(croatiaAirlines.availabilityOfPromotionalPrices());
		
		System.out.println();
		
		Regional airCanadaExpress = new Regional("Air Canada Express", new String[] {"Bombardier CRJ200ER", "Embraer 175"}, 15, 2);
		System.out.println(airCanadaExpress.toString());
		System.out.println(airCanadaExpress.covid19Info());
		System.out.println("PROMOTIONAL PRICES:");
		System.out.println(airCanadaExpress.availabilityOfPromotionalPrices());
		airCanadaExpress.setNumberOfExternalSponsors(0);
		System.out.println(airCanadaExpress.availabilityOfPromotionalPrices());
		
		System.out.println("\nCan I fly - COVID19:");
		System.out.println(SpecialRequirements.canIFlyCovid19(new Status[]{Status.TESTED}, 1, 2));
		System.out.println(SpecialRequirements.canIFlyCovid19(new Status[]{Status.VACCINATED}, 3, 1));
		System.out.println(SpecialRequirements.canIFlyCovid19(new Status[]{Status.TESTED, Status.TESTED}, 3, 1));
	}

}
