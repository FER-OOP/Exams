package hr.fer.oop.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableString implements Iterable<Pair<Character, Integer>> {

	private String s;
	private Iterator<Integer> iterator;

	public IterableString(String s, Iterator<Integer> iterator) {
		this.s = s;
		this.iterator = iterator;		
	}
	
	@Override
	public Iterator<Pair<Character, Integer>> iterator() {		
		return new MyIterator();		
	}
	
	private class MyIterator implements Iterator<Pair<Character, Integer>> {
		int pos = 0;
		Integer numberToUse = null;

		@Override
		public boolean hasNext() {
			return pos < s.length();
		}

		@Override
		public Pair<Character, Integer> next() {
			if (!hasNext()) throw new NoSuchElementException();
			
			if (iterator.hasNext()) {
				numberToUse = iterator.next();
			}
			
			return new Pair<>(s.charAt(pos++), numberToUse);
		}
	}
}
