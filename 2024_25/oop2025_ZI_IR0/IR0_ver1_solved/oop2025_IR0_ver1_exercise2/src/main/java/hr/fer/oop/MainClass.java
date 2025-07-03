package hr.fer.oop;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
	
	public static final Comparator<GameInfo> GOAL_COMPARATOR = new Comparator<>(){
		@Override
		public int compare(GameInfo o1, GameInfo o2) {
			int goalsG1 = o1.awayGoals+o1.homeGoals;
			int goalsG2 = o2.awayGoals+o2.homeGoals;
			int diff = goalsG1 - goalsG2;
			
			if (diff != 0) return diff;
			else return o1.homeGoals - o2.homeGoals;
		}		
	};

	public static void main(String[] args) {
		// Loading the data
		List<GameInfo> ginfList = LoadData.loadGInfData();
		
		// A list of games played by Arsenal where opponent scored zero goals and Arsenal scored 3 or more 
		List<GameInfo> newList = exercise1(ginfList.stream());
		newList.forEach(System.out::println);
		
		
		// Maximum attendance at Old Trafford
		long maxatt = exercise2(ginfList.stream());
		
		System.out.print("\nMax attendance at Old Trafford: " + maxatt + "\n\n");
		
		// Stream of Tottenham home Games sorted by GOAL_COMPARATOR
		Stream<GameInfo> ginfStream = exercise3(ginfList);
		// ginfStream.limit(5).forEach(ginf -> System.out.println(ginf));
		ginfStream.forEach(ginf -> System.out.println(ginf));
		
		// How many points Liverpool won at home
		int homePointsLiverpool = exercise4(ginfList.stream());
		System.out.println("\nPoints Liverpool won at home: " + homePointsLiverpool);
	}
	
	// A list of games played by Arsenal where opponent scored zero goals and Arsenal scored 3 or more
	public static List<GameInfo> exercise1(Stream<GameInfo> ginfStream) {
		return ginfStream.filter(ginf -> (ginf.homeTeam.equals("Arsenal") && ginf.awayGoals == 0 && ginf.homeGoals >= 3)
									  || (ginf.awayTeam.equals("Arsenal") && ginf.homeGoals == 0 && ginf.awayGoals >= 3))
						 .collect(Collectors.toList());
	}
	
	// Maximum attendance at Old Trafford
	public static long exercise2(Stream<GameInfo> ginfStream) {
		return ginfStream.filter(ginf -> ginf.venue.strip().equals("Old Trafford"))
		                .mapToLong(ginf -> ginf.attendance)
		                .max()
		                .getAsLong();
	}
	
	// Stream of Tottenham home Games sorted by GOAL_COMPARATOR
	public static Stream<GameInfo> exercise3(List<GameInfo> ginfList) {
		return ginfList.stream().filter(ginf -> ginf.homeTeam.equals("Tottenham"))
				.sorted(GOAL_COMPARATOR);
	}
	
	// How many points Liverpool won at home
	public static int exercise4(Stream<GameInfo> ginfStream) {
		return ginfStream.filter(ginf -> ginf.homeTeam.equals("Liverpool"))
						 .mapToInt(ginf -> {
							if (ginf.homeGoals == ginf.awayGoals) return 1;
							if (ginf.homeGoals > ginf.awayGoals) return 3;
							return 0;
						 })
						 .sum();
	}
		
}
