package enumovi;

public class Kolegij {

	private VrstaKolegija vrstaKolegija;
	private String ime;

	public Kolegij(String ime, VrstaKolegija vrstaKolegija) {
		super();
		this.ime = ime;
		this.vrstaKolegija = vrstaKolegija;
	}
	
	public VrstaKolegija getVrstaKolegija() {
		return vrstaKolegija;
	}
	
	public String getIme() {
		return ime;
	}
	
}

