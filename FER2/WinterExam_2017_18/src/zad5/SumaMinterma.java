package zad5;

import java.util.Arrays;

public class SumaMinterma extends BooleovaFormula {

	private int[] mintermi;
	
	public SumaMinterma(String[] varijable, int[] mintermi) {
		super(varijable);
		// bolja praksa: iskopirati polje, ali ovdje necemo to kaznjavati
		this.mintermi = mintermi;
	}

	@Override
	public boolean vrijednostZa(boolean[] vrijednosti) {
		// ...
		return false;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(mintermi);
	}
}
