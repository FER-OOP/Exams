package hr.fer.oop.t3;

import java.time.LocalDate;

import hr.fer.oop.t3.items.Beverage;
import hr.fer.oop.t3.items.Perishable;

public class ItemsUtil {	
	public static <V extends Beverage> double totalVolume(Box<V> box){
		double volume = 0;
		for(Beverage item : box.boxContent()) {
			volume += item.getVolume();
		}
		return volume;
	}
	
	public static LocalDate useBefore(Box<? extends Perishable> box){
		Perishable min = null;
		for(Perishable item : box.boxContent()) {
			if (min == null || item.getBestBefore().isBefore(min.getBestBefore())) {
				min = item;
			}
		}
		return min == null ? null : min.getBestBefore();
	}
}
