package hr.fer.oop.t3;
import java.time.LocalDate;
import java.util.List;

import hr.fer.oop.t3.items.*;

public class Main3 {

	public static void main(String[] args) {
		Beverage b =  new Beverage("23", "Coca cola", 10, 2);			
		Food f = new Food("777", "CaoCao", 2.5, LocalDate.of(2016,5, 11));		
		Cloth c = new Cloth("045", "Simple T-shirt", 350, 54);
		Milk m1 = new Milk("888", "Tonka", 8, 1, MilkType.COW , LocalDate.of(2022, 10, 25));
		Milk m2 = new Milk("999", "Ronka", 12, 1, MilkType.SHEEP , LocalDate.of(2022, 9, 25));
		Milk m3 = new Milk("777", "Tonka", 12, 1.5, MilkType.COW , LocalDate.of(2022, 9, 20));
		FreshJuice j = new FreshJuice("1234", "Strawberry", 20, 1, LocalDate.of(2022, 9, 15));
		
		Box<Object> box1 = new Box<>(List.of("some string", 123, f, c, m1, m2, m3));
		System.out.println(box1.boxContent().size()); //7
		
		Box<Item> box2 = new Box<>(List.of(f, c, m1, m2, m3));
		System.out.println(box2.boxContent().size()); //5
		
		Box<Milk> box3 = new Box<Milk>(List.of(m1, m2, m3));
		System.out.println(ItemsUtil.totalVolume(box3));//3.5
		System.out.println(ItemsUtil.useBefore(box3));//2022-09-20
		
		MilkBox milkBox = new MilkBox(m1);
		System.out.println(milkBox.boxContent().size());//1
		System.out.println(milkBox.add(m2));//false
		System.out.println(milkBox.boxContent().size());//1
		System.out.println(milkBox.add(m3));//true
		System.out.println(milkBox.boxContent().size());//2
		
		var box4 = new Box<Perishable>(List.of(m1, m2, j, m3));		
		//System.out.println(ItemsUtil.totalVolume(box4));// compile error
		System.out.println(ItemsUtil.useBefore(box4));//2022-09-15		
		
		var box5 = new Box<Beverage>(List.of(m1, m2, j, m3));		
		System.out.println(ItemsUtil.totalVolume(box5));// 4.5
		//System.out.println(ItemsUtil.useBefore(box5));// compile error
	}

}
