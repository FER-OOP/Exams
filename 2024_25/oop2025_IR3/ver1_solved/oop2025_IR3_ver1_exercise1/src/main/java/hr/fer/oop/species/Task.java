package hr.fer.oop.species;

import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

public class Task {
	public static int count(Stream<Set<String>> taxa) {
		return taxa.mapToInt(s -> s.size()).sum();
	}

	public static Stream<Pair<String, Integer>> genera(Stream<Entry<String, Set<String>>> taxa) {
		return taxa.map(e -> new Pair<>(e.getKey(), e.getValue().size()));
	}

	public static Stream<String> species(Stream<Entry<String, Set<String>>> entries) {
		return entries.flatMap(e -> e.getValue()
									 .stream()
									 .map(s -> e.getKey() + " " + s));
	}
}
