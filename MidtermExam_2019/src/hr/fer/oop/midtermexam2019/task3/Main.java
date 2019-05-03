package hr.fer.oop.midtermexam2019.task3;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		CD cd1 = new CD("Foo Fighters", "One by One", 2002, 55);
		CD cd2 = new CD("Foo Fighters", "In Your Honor", 2005, 83);
		Vinyl vinyl1 = new Vinyl("The Black Keys", "Rubber Factory", 2004, 41, 12);
		TShirt tshirt1 = new TShirt("Foo Fighters", 2012);
		TShirt tshirt2 = new TShirt("The Black Keys", 2010);
		
		BoxOfMemorabilia<Item> box = new BoxOfMemorabilia<Item>();
		box.add(cd1, cd2, vinyl1, tshirt1, tshirt2, null);
		List<Item> itemsInBox = box.getItems();
		System.out.println("I own " + box.getNumberOfItems() + " memorabilia items.");
		
		BoxOfRecords<CD> boxOfCDs = new BoxOfRecords<>();
		boxOfCDs.add(cd1, cd2);
		System.out.println(boxOfCDs.totalDuration());
		
	}

}
