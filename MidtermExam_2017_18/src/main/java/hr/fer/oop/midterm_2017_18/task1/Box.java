package hr.fer.oop.midterm_2017_18.task1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Box<T> {
	protected List<T> items;
	
	public Box(){
		items = new LinkedList<>();
	}
	
	public void add(T... items){
		for(T item : items) {
			this.items.add(item);
		}
	}
	
	public Collection<T> getItems(){
		return items;
	}	
}	
