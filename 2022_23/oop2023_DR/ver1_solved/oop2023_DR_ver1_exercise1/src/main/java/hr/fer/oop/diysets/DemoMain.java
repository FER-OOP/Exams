package hr.fer.oop.diysets;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class DemoMain {

	public static void main(String[] args) {
		Map<String, List<Offer>> offers = new HashMap<>();
				
		List<Offer> list = List.of(
				new Offer("ACME", 10),		
				new Offer("HERO", 12),
				new Offer("MANGO", 15));			
		offers.put("A7", list);
		
		list = List.of(
				new Offer("MANGO", 27),		
				new Offer("LUMEN", 28),
				new Offer("ACME", 30));			
		offers.put("B1-14", list);
		
		list = List.of(new Offer("ACME", 20));			
		offers.put("B1-15", list);
		
		list = List.of(new Offer("HERO", 25), new Offer("ACME", 25));			
		offers.put("105", list);
		
		
		list = List.of(new Offer("ACME", 10));			
		offers.put("041", list);
		
		for(var entry : offers.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		System.out.println();
		
		List<String> stringDefinitions = new LinkedList<>();
		stringDefinitions.add("MUNJA;Set of 50 parts;45 x B1-15;5 x B1-14");
		stringDefinitions.add("123;Set with id 123 consisting of 12 parts;3 x 114;5 x 105;2 x 041;2 x 042");
		stringDefinitions.add("A-52-14;Set A-52-14 with 30 parts;5 x 114;20 x A7;5 x B1-14");
		stringDefinitions.add("STRUJA 2;Set of 50 parts;40 x B1-15;5 x B1-14;5 x A7");
		stringDefinitions.add("STRUJA 1;Set of 50 parts;40 x B5-15;5 x B1-14;5 x A7");
		stringDefinitions.add("STRUJA 3;Set of 50 parts;40 x B5-15;10 x B1-14");
		DIY.parse(stringDefinitions.stream())
		   .forEach(System.out::println);
		
		System.out.println();
		DIY.parse(stringDefinitions.stream())
		   .forEach(s -> System.out.println(s.id() + " " + s.calculatePrice(offers)));
	}
}
