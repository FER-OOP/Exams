package enumovi;

public enum VrstaKolegija {

	TEORIJSKI(1, "Teorijski predmet profila"),
	SPECIJALIZACIJA(2, "Predmet specijalizacije profila"),
	IZBORNI(3, "Izborni predmet profila")
	;
	
	private int tip;
	private String naziv;
	
	private VrstaKolegija(int tip, String naziv) {
		this.tip = tip;
		this.naziv = naziv;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public int getTip() {
		return tip;
	}
	
}
