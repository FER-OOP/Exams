package hr.fer.oop;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
	
	// Replace null with your definition of the GOAL_Comparator
	public static final Comparator<GameInfo> GOAL_COMPARATOR = null;

	public static void main(String[] args) {
		// Loading the data
		List<GameInfo> ginfList = LoadData.loadGInfData();
		
		// A list of games played by Arsenal where opponent scored zero goals and Arsenal scored 3 or more 
		List<GameInfo> newList = exercise1(ginfList.stream());
		System.out.println(newList);
		
		
		// Maximum attendance at Old Trafford
		long maxatt = exercise2(ginfList.stream());
		
		System.out.print("\nMax attendance at Old Trafford: " + maxatt + "\n\n");
		
		// Tottenham home Games sorted by GOAL_COMPARATOR
		Stream<GameInfo> ginfStream = exercise3(ginfList);
		ginfStream.limit(5).forEach(ginf -> System.out.println(ginf));
		
		// How many points Liverpool won at home
		int homePointsLiverpool = exercise4(ginfList.stream());
		System.out.println("\nPoints Liverpool won at home: " + homePointsLiverpool);
	}

	
	public static List<GameInfo> exercise1(Stream<GameInfo> ginfStream) {
		// Write your code here
		return null;
	}
	
	public static long exercise2(Stream<GameInfo> ginfStream) {
		// Write your code here
		return 0;
	}
	
	public static Stream<GameInfo> exercise3(List<GameInfo> ginfList) {
		// Write your code here
		return null;
	}
	
	public static int exercise4(Stream<GameInfo> ginfStream) {
		// Write your code here (replace 0 with the calculated value)
		return 0;
	}
		
}
