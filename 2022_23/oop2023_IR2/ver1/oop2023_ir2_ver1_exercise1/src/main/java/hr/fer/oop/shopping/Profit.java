package hr.fer.oop.shopping;

import java.util.OptionalInt;
import java.util.stream.Stream;

public record Profit(String town, String country, OptionalInt profit) {

	public static Stream<Profit> sorted(Stream<TownTransactions> stream) {
		// TODO Auto-generated method stub
		return null;
	}}