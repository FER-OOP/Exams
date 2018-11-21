package hr.fer.oop.midterm_2018_19.task2;

import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		List<PrizeGame> games = DataLoader.getGames();
		Statistics.printGamesByMonth(games);
		Set<String> set = Statistics.gameWinners(games, "Od glave do pete");
		System.out.println(String.join(", ", set));
		
		set = Statistics.gameWinners(games, "Priroda i društvo");
		System.out.println(String.join(", ", set));
		
		set = Statistics.gameWinners(games, "Nepostojeća igra");
		System.out.println(String.join(", ", set));
		
		set = Statistics.gameWinners(games, "Tehnika narodu");
		System.out.println(String.join(", ", set));
		
		set = Statistics.gameWinners(games, "Zdrav život");
		System.out.println(String.join(", ", set));	
		
		
	}	
}
