package hr.fer.oop.zad1;

public interface SpecialRequirements {
	public String covid19Info();
	
	public static boolean canIFlyCovid19(Status[] statusList, int fromCountryZone, int toCountryZone) {
		if (fromCountryZone <= toCountryZone)  
			return true;
		else if (fromCountryZone == 2 && toCountryZone == 1)
			return statusList.length != 0 ? true : false;	
		else if ((fromCountryZone == 3) && (toCountryZone == 2 || toCountryZone == 1)) {
			int flagTested = 0;
			boolean flagOther = false;
			for (Status s : statusList){
				if (s.equals(Status.TESTED)) flagTested++;
				else if (s.equals(Status.VACCINATED) || s.equals(Status.RECOVERED)) flagOther = true;
			}
			if (flagOther && flagTested > 0) return true;
			else if (flagTested > 1) return true;
		}
		return false;			
	}
}
