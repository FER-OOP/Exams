package hr.fer.oop.task1;

import java.util.HashMap;

public class BasketballGame extends TeamSport
{
	public BasketballGame()
	{
		super();
	}
	
	@Override
	public HashMap<Competitor, String> calculateStatistics()
	{
		HashMap<Competitor, String> statMap = new HashMap<>();
		//Do something here...
		return statMap;
	}
}