package osobe;

public class Zaposlenik extends Osoba {

	private String tvrtka;
	
	public Zaposlenik(String ime, String tvrtka) {
		super(ime);
		this.tvrtka = tvrtka;
	}

	public String getTvrtka() {
		return tvrtka;
	}
	
}
