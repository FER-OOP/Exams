package hr.fer.oop.shopping;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DemoMain {

	public static void main(String[] args) {			
		List<Transaction> transactions = new LinkedList<>();
		transactions.add(new Transaction("Zagreb", LocalDate.of(2023, 1, 15), 100));
		transactions.add(new Transaction("Zagreb", LocalDate.of(2023, 1, 16), 100));
		transactions.add(new Transaction("Split", LocalDate.of(2023, 1, 15), 100));
		transactions.add(new Transaction("Zadar", LocalDate.of(2023, 1, 15), -50));
		transactions.add(new Transaction("Madrid", LocalDate.of(2023, 2, 10), 300));
		transactions.add(new Transaction("London", LocalDate.of(2023, 3, 5), 150));
		transactions.add(new Transaction("Madrid", LocalDate.of(2023, 2, 11), -400));
		transactions.add(new Transaction("London", LocalDate.of(2023, 3, 6), 100));
		
		Map<String, String> towns = new HashMap<>();
		towns.put("Zagreb", "Croatia");
		towns.put("Split", "Croatia");
		towns.put("Zadar", "Croatia");
		towns.put("Pula", "Croatia");
		towns.put("Sinj", "Croatia");
		towns.put("Madrid", "Spain");
		towns.put("Valencia", "Spain");
		towns.put("Paris", "France");
		towns.put("London", "United Kingdom");

		 List<TownTransactions> townsTransactions = TownTransactions.getTownTransactions(towns, transactions);
		 System.out.println(townsTransactions);
		 
		 Stream<Profit> stream = Profit.sorted(townsTransactions.stream());
		 stream.forEach(System.out::println);
	}

}
