package hr.fer.oop.midterm_2018_19.task2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DataLoader {
	public static List<PrizeGame> getGames(){
		List<PrizeGame> list = new LinkedList<>();
		
		PrizeGame game = new PrizeGame("Zdrav život", LocalDate.of(2018, 4, 25));
		list.add(game);
		Prize prize = game.addPrize("Pakiranje slatkiša", 100);
		prize.setWinners(Arrays.asList("Ana", "Ivana", "Ante", "Marija", "Ante"));
				
		prize = game.addPrize("16L gaziranih sokova", 250);		
		prize.setWinners(Arrays.asList("Klara", "Pjero", "Ante", "Vinko"));		
		
		prize = game.addPrize("Godišnja zaliha kave", 3000);		
		prize.setWinners(Arrays.asList("Bojan"));		
		
		
		game = new PrizeGame("Tehnika narodu", LocalDate.of(2018, 4, 12));
		list.add(game);
		prize = game.addPrize("Mobitel Fjung-Hu", 400);
		prize.setWinners(Arrays.asList("Ana", "Petra", "Lorena", "Martin", "Matija"));
				
		prize = game.addPrize("Android TV", 2500);		
		prize.setWinners(Arrays.asList("Klara", "Ante"));		
		
		prize = game.addPrize("Kućno kino", 5000);		
		prize.setWinners(Arrays.asList("Marija"));
		
		
		game = new PrizeGame("Priroda i društvo", LocalDate.of(2018, 2, 11));
		list.add(game);
		prize = game.addPrize("Vrtni roštilj", 500);
		prize.setWinners(Arrays.asList("Zoran", "Ivana", "Bojan", "Marija", "Ante"));
								
		prize = game.addPrize("Godišnja zaliha drvenih briketa", 1000);		
		prize.setWinners(Arrays.asList("Davor", "David", "Jakov"));
		
		prize = game.addPrize("Godišnja zaliha roštiljskih kobasica", 5000);
		prize.setWinners(Arrays.asList("Petra"));
		
		game = new PrizeGame("Od glave do pete", LocalDate.of(2018, 1, 2));
		list.add(game);
		prize = game.addPrize("Zimska kapa", 100);
		prize.setWinners(Arrays.asList("Juraj", "Lovro", "Jakov", "Marko", "Darko"));
								
		prize = game.addPrize("Zimski pulover", 500);		
		prize.setWinners(Arrays.asList("Jurica", "Ivica", "Ivan", "Ante", "Petra"));
		
		prize = game.addPrize("Zimske cipele", 800);
		prize.setWinners(Arrays.asList("Marija"));
				
		
		return list;
	}
}
