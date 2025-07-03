package hr.fer.oop;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
	
	// Replace null with your definition of the GAME_Comparator
	public static final Comparator<GameInfo> GAME_COMPARATOR = null;

	public static void main(String[] args) {
		// Loading the data
		List<GameInfo> ginfList = LoadData.loadGInfData();
		
		// A list of games that Arsenal won by 3 or more goals (home or away)
		List<GameInfo> newList = exercise1(ginfList.stream());
		newList.forEach(System.out::println);
		
		// A collection of all different teams competing in English premiere league, assuming that every team played at least one game at home
		// without duplicates
		Collection<String> teamCollection = exercise2(ginfList.stream());
		
		System.out.println("\nTeams: ");
		teamCollection.forEach(team -> System.out.print(team + " "));
		System.out.println("\n");
		
		// Stream of Games that had 7 or more total goals scored sorted by GAME_COMPARATOR
		Stream<GameInfo> ginfStream = exercise3(ginfList);
		ginfStream.forEach(ginf -> System.out.println(ginf));
		
		// Goal difference for a given team, just one number (goalsScored - goalsConceded)
		int goalDiff = exercise4(ginfList.stream(), "Liverpool");
		System.out.println("\nGoal difference for Liverpool: " + goalDiff);
	}
	
	// A list of games that Arsenal won by 3 or more goals (home or away)
	public static List<GameInfo> exercise1(Stream<GameInfo> ginfStream) {
		// Write your code here
		return null;
	}
	
	// A collection of all different teams competing in English premiere league, assuming that every team played at least one game at home
	// without duplicates
	public static Collection<String> exercise2(Stream<GameInfo> ginfStream) {
		// Write your code here
		return null;
	}
	
	// Stream of Games that had 7 or more total goals scored sorted by GAME_COMPARATOR
	public static Stream<GameInfo> exercise3(List<GameInfo> ginfList) {
		// Write your code here
		return null;
	}
	
	// Goal difference for a given team, just one number (goalsScored - goalsConceded)
	public static int exercise4(Stream<GameInfo> ginfStream, String team) {
		// Write your code here (replace 0 with the calculated value)
		return 0;
	}
		
}
