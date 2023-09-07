package hr.fer.oop.shopping;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public record TownTransactions(String town, String country, List<Integer> amounts) 
{
	public static List<TownTransactions> getTownTransactions(Map<String, String> townsAndCountries, List<Transaction> transactions) {
		
		Map<String, TownTransactions> transactionsPerTown = new HashMap<>(townsAndCountries.size());
		for (var town : townsAndCountries.entrySet()) {
			transactionsPerTown.put(town.getKey(), new TownTransactions(town.getKey(), town.getValue(), new LinkedList<>()));
		}
		for(Transaction transaction : transactions) {
			TownTransactions tt = transactionsPerTown.get(transaction.town());
			tt.amounts.add(transaction.amount());
		}
		return transactionsPerTown.values().stream().toList();
	}
}
