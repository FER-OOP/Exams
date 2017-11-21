package hr.fer.oop.midterm_2017_18.task1;

import java.time.LocalDate;
import hr.fer.oop.midterm_2017_18.task1.items.*;


public class Main {

	public static void main(String[] args) {			
		Beverage cola = new Beverage("23", "Coca cola", 10, 2);		
		Beverage beer = new Beverage("11", "Wheat beer", 15, 0.33);
		Milk milk1 = new Milk("501", "Milk", 6, 1, MilkType.COW, LocalDate.of(2017,11, 29));
		Milk milk2 = new Milk("502", "Milk 1.75", 10, 1.75, MilkType.COW, LocalDate.of(2017,12,13));
		Food caocao = new Food("777", "CaoCao",3 , LocalDate.of(2018,5, 11));		
		Cloth shirt = new Cloth("045", "Simple T-shirt", 50, 54);
		
		Box<Item> box = new Box<>();
		box.add(caocao, shirt, cola, cola,  beer, milk1);
		for(Item item : box.getItems()){
			System.out.print(item.getSku() + " ");
		} //prints 777 045 23 23 11 501
		System.out.println();
		
						
		ItemBox<Beverage> beverageBox = new ItemBox<>();
		beverageBox.add(cola, beer, beer, milk1, milk2);
		System.out.println(beverageBox.boxValue());	// should write 56	
	}	
}
