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
		return s.filter(m -> m.year==year)
				.map(m -> m.mapName)
				.distinct()
				.count();
	}
	
	public static int getWinsInAYear(Stream<PlayerResult> s, int year, String playerName) {
		return s.filter(m -> m.playerName.equals(playerName))
				.filter(m -> m.year==year)
				.mapToInt(m -> m.wins)
				.sum();
	}

	public static int getMostPointsInAYear(Stream<PlayerResult> s, int year) {
		//može i s Collectors.groupingBy u jednoj naredbi
		
		Map<String,Integer> map = new HashMap<>();
		
		s.filter(m -> m.year==year)
		 .forEach(pr -> map.merge(pr.playerName, pr.points, ((p1, p2) -> p1+p2)));
		
		return map.entrySet()
				  .stream()
				  .mapToInt(e -> e.getValue())
				  .max()
				  .orElse(0);
	}
	
	public static List<String> getPlayerWithMaxWins(Collection<PlayerResult> c, int year, String mapName) {
		return c.stream().filter(m -> m.year==year)
				.filter(m -> m.mapName.equals(mapName))
				.filter(m -> m.wins == (c.stream().filter(m1 -> m1.year==year)
										 .filter(m1 -> m1.mapName.equals(mapName))
										 .mapToInt(m1->m1.wins).max().orElse(0)))
				.map(m -> m.playerName)
				.collect(Collectors.toList());
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
