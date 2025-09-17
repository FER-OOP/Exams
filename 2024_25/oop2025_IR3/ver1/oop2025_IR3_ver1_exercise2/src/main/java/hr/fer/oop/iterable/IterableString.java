package hr.fer.oop.iterable;

import java.util.Collections;
import java.util.Iterator;

public class IterableString implements Iterable<Pair<Character, Integer>> {

	private String s;
	private Iterator<Integer> iterator;

	public IterableString(String s, Iterator<Integer> iterator) {
		this.s = s;
		this.iterator = iterator;		
	}
	
	//TO DO: Implement iterator method correctly	
	@Override
	public Iterator<Pair<Character, Integer>> iterator() {			
		return Collections.emptyIterator();
	}		
	//
}
