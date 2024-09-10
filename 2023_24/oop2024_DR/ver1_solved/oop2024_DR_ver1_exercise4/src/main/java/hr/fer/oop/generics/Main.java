package hr.fer.oop.generics;

import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Set<LettersAndNumber<Integer>> setI = new TreeSet<>();
		setI.add(new LettersAndNumber<>("C", 5));
		setI.add(new LettersAndNumber<>("C", 2));
		setI.add(new LettersAndNumber<>("A", 1));
		setI.add(new LettersAndNumber<>("D", 4));
		setI.add(new LettersAndNumber<>("D", 6));
		setI.add(new LettersAndNumber<>("B", 7));
		setI.add(new LettersAndNumber<>("D", 4));
		
		for(Pair<String, Integer> p : setI) {
			System.out.println(p);
		}
		
		//the previous loop should print
		//		A-1
		//		B-7
		//		C-2
		//		C-5
		//		D-4
		//		D-6
		
		Set<LettersAndNumber<Double>> setD = new TreeSet<>();
		setD.add(new LettersAndNumber<>("C", 5.5));
		setD.add(new LettersAndNumber<>("C", 2.0));
		setD.add(new LettersAndNumber<>("A", 1.25));
		setD.add(new LettersAndNumber<>("D", 4.0));
		setD.add(new LettersAndNumber<>("D", 6.0));
		setD.add(new LettersAndNumber<>("B", 7.75));
		setD.add(new LettersAndNumber<>("D", 4.0));
		
		System.out.println();
		
		for(Pair<String, Double> p : setD) {
			System.out.println(p);
		}
		
		//the previous loop should print
		//		A-1.25
		//		B-7.75
		//		C-2.0
		//		C-5.5
		//		D-4.0
		//		D-6.0
	}
}
