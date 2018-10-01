package hr.fer.oop.fall_2017_18.task1;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> list1 =  Arrays.asList("Ana", "Ivana", "Marija");		
		List<String> list2 =  Arrays.asList("Petar", "Zoran", "Filip", "Denis", "Miho");
		List<String> list3 =  Arrays.asList("jabuka", "gljiva", "breskva", "salata");		
		Alternator<String> alternator = new Alternator<>(list1, list2, list3);
		for (String s : alternator) {
			System.out.print(s + " ");
		}
		System.out.println();
		for (String s : alternator) {
			System.out.print(s + " ");
		}
	}
}
