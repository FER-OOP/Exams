package hr.fer.oop.diysets;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Stream;

public record DIY(String id, String description, Map<String, Integer> parts) {

	public static Stream<DIY> parse(Stream<String> definitions) {
		Function<String, DIY> mapper = s -> {
			String[] arr = s.split(";");
			Map<String, Integer> parts = new HashMap<>();
			for(int i=2 ; i<arr.length ; i++) {
				int ind = arr[i].indexOf(" x ");
				parts.put(arr[i].substring(ind + 3), Integer.parseInt(arr[i].substring(0, ind)));
			}
			return new DIY(arr[0], arr[1], parts);
		};
		
		Function<DIY, Integer> partsCounter = d -> d.parts().values().stream().mapToInt(i -> i).sum();
		Comparator<DIY> comparator = (a, b) -> partsCounter.apply(a) - partsCounter.apply(b);
		
		comparator = comparator.reversed().thenComparing(DIY::id);
		
		return definitions.map(mapper)
						  .sorted(comparator);
				
	}
	
	public Pair<Integer, OptionalInt> calculatePrice(Map<String, List<Offer>> offers) {
		int min = 0; int max = 0;
		boolean missing = false;
		for(var part : parts.entrySet()) {
			List<Offer> list = offers.get(part.getKey());
			if (list == null) {
				missing = true;
			}
			else {
				min += part.getValue() * list.get(0).price();
				max += part.getValue() * list.get(list.size() - 1).price();
			}
		}
		return new Pair<>(min, missing ? OptionalInt.empty() : OptionalInt.of(max));
	}
}
