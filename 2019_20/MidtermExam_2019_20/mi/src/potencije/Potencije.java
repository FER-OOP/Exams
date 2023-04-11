package potencije;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Potencije implements Iterable<Integer> {

	private int baza;
	private int koliko;
	
	public Potencije(int baza, int koliko) {
		super();
		if(baza < 1 ) throw new IllegalArgumentException("Za bazu: " + baza);
		if(koliko < 1) throw new IllegalArgumentException("Za koliko: " + koliko);
		this.baza = baza;
		this.koliko = koliko;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new MojIterator();
	}
	
	private class MojIterator implements Iterator<Integer> {
		private int trenutni = 1;
		private int preostalo = koliko;
		
		@Override
		public boolean hasNext() {
			return preostalo > 0;
		}
		
		@Override
		public Integer next() {
			if(!hasNext()) throw new NoSuchElementException();
			
			int vrijednost = trenutni;
			
			trenutni *= baza;
			preostalo--;
			
			return vrijednost;
		}
	}
	
}
