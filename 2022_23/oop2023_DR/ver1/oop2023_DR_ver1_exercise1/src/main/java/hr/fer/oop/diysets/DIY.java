package hr.fer.oop.diysets;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Stream;

public record DIY(String id, String description, Map<String, Integer> parts) {

	public static Stream<DIY> parse(Stream<String> definitions) {
		//TO DO
		return null;
				
	}
	
	public Pair<Integer, OptionalInt> calculatePrice(Map<String, List<Offer>> offers) {
		//TO DO
		return null;
	}
}
