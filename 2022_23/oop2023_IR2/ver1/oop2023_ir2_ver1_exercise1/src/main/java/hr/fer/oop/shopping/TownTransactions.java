package hr.fer.oop.shopping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public record TownTransactions(String town, String country, List<Integer> amounts) {

	public static List<TownTransactions> getTownTransactions(Map<String, String> townsAndCountries, List<Transaction> transactions) {
		
		//TO DO:
		return null;			
	}}
