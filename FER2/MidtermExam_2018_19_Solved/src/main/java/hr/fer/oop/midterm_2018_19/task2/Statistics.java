package hr.fer.oop.midterm_2018_19.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Statistics {

	public static void printGamesByMonth(List<PrizeGame> games) {
		List<Set<String>> list = new ArrayList<>(12);
		for(int i=0; i<12; i++) {
			list.add(new TreeSet<>());
		}
		
		for(PrizeGame game : games) {
			int month = game.getDrawDate().getMonthValue();
			list.get(month - 1).add(game.getName());
		}
		
		for(int i=0; i<12; i++) {
			if (list.get(i).size() > 0) {
				System.out.format("%d.%n", i+1);
				for(String s : list.get(i)) {
					System.out.format("\t%s%n", s);
				}
			}
		}		
	}
	
	public static Set<String> gameWinners(List<PrizeGame> games, String gameName) {
		Set<String> set = new TreeSet<>();
		for(PrizeGame game : games) {
			if (game.getName().equals(gameName)) {
				for (Prize prize : game.getPrizes()) {
					set.addAll(prize.getWinners());
				}
			}
		}
		return set;
	}		
}
