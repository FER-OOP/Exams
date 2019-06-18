package zad5;

public class AlgebarskiZapis extends BooleovaFormula implements Provjerivo {

	private String zapis;
	
	public AlgebarskiZapis(String zapis) {
		super(izvadiVarijable(zapis));
		this.zapis = zapis;
	}

	private static String[] izvadiVarijable(String zapis) {
		// ...
		return null;
	}
	
	@Override
	public boolean vrijednostZa(boolean[] vrijednosti) {
		// ...
		return false;
	}
	
	@Override
	public String toString() {
		return zapis;
	}
	
	
	@Override
	public boolean provjeri() {
		// ...
		return false;
	}

}
