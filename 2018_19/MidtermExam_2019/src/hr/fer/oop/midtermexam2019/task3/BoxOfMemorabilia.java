package hr.fer.oop.midtermexam2019.task3;


import java.util.ArrayList;
import java.util.List;

public class BoxOfMemorabilia<T> {

	private List<T> items = new ArrayList<T>();
	
	public void add(T... items) {
		if (items == null) {
			return;
		}
		for(T item : items) {
			if (item != null) {
	            this.items.add(item);
			}
        }
	}
	
	public List<T> getItems() {
		return items;
	}
	
	public int getNumberOfItems() {
		return items.size();
	}

}