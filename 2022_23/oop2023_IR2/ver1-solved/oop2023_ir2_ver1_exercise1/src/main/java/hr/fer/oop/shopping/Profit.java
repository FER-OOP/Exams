package hr.fer.oop.shopping;

import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.Stream;

public record Profit(String town, String country, OptionalInt profit) {

	public static Stream<Profit> sorted(Stream<TownTransactions> stream) {
		Comparator<Profit> comparator = (a, b) -> {
			int r = a.country.compareTo(b.country);
			if (r == 0) {
				if (a.profit.isPresent()) {
					r = b.profit.isPresent() ? b.profit.getAsInt() - a.profit.getAsInt() : -1;
				}
				else {
					r = b.profit.isPresent() ? 1 : 0;
				}
			}
			if (r == 0) {
				r = a.town.compareTo(b.town);
			}
			return r;
		};
		return stream.map(t -> new Profit(t.town(), t.country(), 
									t.amounts().isEmpty() ? OptionalInt.empty() : OptionalInt.of(t.amounts().stream().mapToInt(a -> a).sum()) 
									))
					.sorted(comparator);
	}
}