package zad5;

public abstract class BooleovaFormula {

	private String[] varijable;

	public BooleovaFormula(String[] varijable) {
		super();
		// bolja praksa: iskopirati polje, ali ovdje necemo to kaznjavati
		this.varijable = varijable;
	}

	public String[] getVarijable() {
		return varijable;
	}
	
	public abstract boolean vrijednostZa(boolean[] vrijednosti);
}
