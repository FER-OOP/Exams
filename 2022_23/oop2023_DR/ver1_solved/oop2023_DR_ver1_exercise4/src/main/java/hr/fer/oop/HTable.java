package hr.fer.oop;

import java.util.LinkedList;
import java.util.List;

public class HTable<T> {
	private List<TableEntry<List<T>>> list;

	public HTable() {
		list = new LinkedList<TableEntry<List<T>>>();
	}

	public void add(T newElement) {
		int hash = newElement.hashCode();
		//nadji u listi TableEntry ciji first je hash
		for (TableEntry<List<T>> e : list)
			if (e.getFirst().equals(hash)) {
				List<T> innerList = e.getSecond();
				if (innerList.contains(newElement))
					throw new DuplicateElementException("Element is already in HTable");
				innerList.add(newElement);
				return;
			}
		//ako sam dosao do ovdje onda nema tog hasha u tablici
		List<T> innerList = new LinkedList<>();
		innerList.add(newElement);
		list.add(new TableEntry<List<T>>(hash, innerList));
	}
	
	public boolean contains(T needle) {
		int hash = needle.hashCode();
		for (TableEntry<List<T>> e : list)
			if (e.getFirst().equals(hash)) {
				List<T> innerList = e.getSecond();
				return innerList.contains(needle);
			}
		return false;
	}

	public void print() {
		for (TableEntry<List<T>> e : list) {
			System.out.print(e.getFirst() + " -> ");
			for (T el : e.getSecond())
				System.out.print(el + " ; ");
			System.out.println();
		}
	}
	
}
