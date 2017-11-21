package hr.fer.oop.midterm_2017_18.task1;
import hr.fer.oop.midterm_2017_18.task1.items.*;

public class ItemBox<T extends Item> extends Box<T> {
			
	public double boxValue(){
		double value = 0;
		for(Item item : items) {
			value += item.getNetSalePrice();
		}
		return value;
	}
}	
