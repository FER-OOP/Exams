package hr.fer.oop;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static long getNumberOfMapsInAYear(Stream<PlayerResult> s, int year) {
		//TO-DO
		return 0;
	}
	
	public static int getWinsInAYear(Stream<PlayerResult> s, int year, String playerName) {
		//TO-DO
		return 0;
	}

	public static int getMostPointsInAYear(Stream<PlayerResult> s, int year) {
		//TO-DO
		return 0;
	}
	
	public static List<String> getPlayerWithMaxWins(Collection<PlayerResult> c, int year, String mapName) {
		//TO-DO
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		
		List<PlayerResult> list = new ArrayList<PlayerResult>();
		
		Path csvFile = Path.of("src/main/resources/match_results.csv");
		List<String> lines = Files.readAllLines(csvFile, StandardCharsets.UTF_8);
		
		for (String line : lines) {
			PlayerResult res = PlayerResult.createFromString(line);
			list.add(res);
		}
		
		//testing
		System.out.println("Number of different maps played in a 2024: " + getNumberOfMapsInAYear(list.stream() ,2024));
		System.out.println("Number of wins for WittyOstrich in a 2025: " + getWinsInAYear(list.stream(), 2025, "WittyOstrich"));
		System.out.println("Most points in a 2022: " + getMostPointsInAYear(list.stream() ,2022));
		System.out.println("Players with most wins in 2024: " + getPlayerWithMaxWins(list, 2025, "Zone wars"));
		
	}

}
