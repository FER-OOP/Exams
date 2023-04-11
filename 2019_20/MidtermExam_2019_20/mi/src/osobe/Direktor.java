package osobe;

public class Direktor extends Zaposlenik {

	private double bonus;
	
	public Direktor(String ime, String tvrtka, double bonus) {
		super(ime, tvrtka);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}
}
