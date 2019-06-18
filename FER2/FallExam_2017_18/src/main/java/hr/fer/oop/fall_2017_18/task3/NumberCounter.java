package hr.fer.oop.fall_2017_18.task3;


import java.util.List;

public class NumberCounter {
	public static int countNumbers(List<String> lines) {
		int count = 0;			
		for(String s : lines) {
			for(int i=0; i<s.length(); i++) {				
				if (Character.isDigit(s.charAt(i))) {
					++count;
				}					
			}
		}
		return count;
	}
}
