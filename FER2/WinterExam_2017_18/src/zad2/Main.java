package zad2;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	public Main() {
		List<EPubBook> books = Books.readFromDefaultLocation();
		
		// b) 1
		List<EPubBook> books2 = books.stream()
				.filter(new Predicate<EPubBook>() {
			            @Override
			            public boolean test(EPubBook t) {
			                return t.getAuthors().equalsIgnoreCase("Mark Twain");
			            }
			        })
				.sorted((b1,b2)->Integer.compare(b1.getYear(), b2.getYear()))
				.collect(Collectors.toList());

		// b) 2
		Map<Integer, List<EPubBook>> map = books.stream()
			.filter(b -> b.getYear() > 1870)
			.collect(Collectors.groupingBy(b->b.getYear()));
        
		// b) 3
		List<String> authors = books.stream()
				.map(t -> t.getAuthors())
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		
		// b) 4
		OptionalDouble optAvg = books.stream()
				.mapToInt(b->b.getYear())
				.average();
		if(optAvg.isPresent()) {
			System.out.printf("Prosječna starost je %f.%n", optAvg.getAsDouble());
		} else {
			System.out.println("Prosječnu starost nije moguće odrediti.");
		}
	}
}
