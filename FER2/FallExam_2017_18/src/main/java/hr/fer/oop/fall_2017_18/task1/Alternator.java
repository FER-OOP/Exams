package hr.fer.oop.fall_2017_18.task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Alternator<T> implements Iterable<T> {
	private List<Iterable<T>> iterables;
			
	public Alternator(Iterable<T>... iterables) {
		this.iterables = new ArrayList<>(iterables.length);							
		Collections.addAll(this.iterables, iterables);			
	}	
	
	
	@Override
	public Iterator<T> iterator() {		
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<T> {
		private int current = -1;
		private List<Iterator<T>> iterators;		
		public MyIterator() {
			iterators = new ArrayList<>(iterables.size());							
			
			for (Iterable<T> iterable : iterables) {					
				iterators.add(iterable.iterator());				
			}
			//or alternatively iterables.forEach(iterable -> iterators.add(iterable.iterator()));
		}
		@Override
		public boolean hasNext() {
			for(Iterator<T> it : iterators) {
				if (it.hasNext()) {
					return true;
				}
			}
			return false;
		}

		@Override
		public T next() {
			if (hasNext()) {
				T result;
				while(true) {
					current = (current + 1) % iterators.size();
					if (iterators.get(current).hasNext()) {
						result = iterators.get(current).next();						
						break;
					}					
				}				
				return result;
			}
			else {
				throw new NoSuchElementException();
			}
			
		}
		
	}

}
