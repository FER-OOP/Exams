package hr.fer.oop.task1;

import java.time.LocalDate;
import java.util.HashMap;

public abstract class Sport
{		
	private AgeCategory gameAgeCategory;
	private GenderCategory gameGenderCategory;
	
	private HashMap<Competitor,String> scoreMap = new HashMap<>();
	
	//private LocalDate date;

	public AgeCategory getGameAgeCategory() {
		return gameAgeCategory;
	}

	public void setGameAgeCategory(AgeCategory gameAgeCategory) {
		this.gameAgeCategory = gameAgeCategory;
	}

	public GenderCategory getGameGenderCategory() {
		return gameGenderCategory;
	}

	public void setGameGenderCategory(GenderCategory gameGenderCategory) {
		this.gameGenderCategory = gameGenderCategory;
	}

//	public LocalDate getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
//	
	public void addToScoreMap(Competitor c, String stats)
	{
		scoreMap.put(c, stats);
	}
	
	public abstract HashMap<Competitor, String> calculateStatistics();
	
}
