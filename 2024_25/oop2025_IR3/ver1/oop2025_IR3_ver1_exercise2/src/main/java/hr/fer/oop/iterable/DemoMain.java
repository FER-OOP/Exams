package hr.fer.oop.iterable;

import java.util.Iterator;
import java.util.List;

public class DemoMain {
	
	public static void main(String[] args) {
		List<Integer> ids = List.of(1, 2, 3);
		IterableString s = new IterableString("ABCDE", ids.iterator());
		for(Pair<Character, Integer> p : s) {
			System.out.println(p.first() + " -> " + p.second());
		} //output should be (in each line) A -> 1, B -> 2, C -> 3, D -> 3, E -> 3
		System.out.println();
		
		Iterator<Integer> it = List.of(1, 2, 3, 4).iterator();
		IterableString s1 = new IterableString("K", it);
		IterableString s2 = new IterableString("LM", it);
		IterableString s3 = new IterableString("NOP", it);	
		for(Pair<Character, Integer> p : s1) {
			System.out.println(p.first() + " -> " + p.second()); // K -> 1			
		}
		for(Pair<Character, Integer> p : s2) {
			System.out.println(p.first() + " -> " + p.second()); // L -> 2
			break; //after the first character!
		}
		for(Pair<Character, Integer> p : s3) {
			System.out.println(p.first() + " -> " + p.second()); // N -> 3, O -> 4, P -> 4			
		}
		
		IterableString s4 = new IterableString("R", it);
		for(Pair<Character, Integer> p : s4) {
			System.out.println(p.first() + " -> " + p.second()); // R -> null			
		}	
		
		IterableString s5 = new IterableString("ABC", List.of(1, 2, 3, 4, 5).iterator());
		for(Pair<Character, Integer> p : s5) {
			System.out.println(p.first() + " -> " + p.second()); // A -> 1, B -> 2, C -> 3			
		}
		for(Pair<Character, Integer> p : s5) {
			System.out.println(p.first() + " -> " + p.second()); // A -> 4, B -> 5, C -> 5			
		}
	}
}
