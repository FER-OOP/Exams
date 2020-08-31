package hr.fer.oop.task1;

import java.util.ArrayList;

public class Team implements Identifiable
{
	private String teamName;
	private ArrayList<Competitor> teammates = new ArrayList<>();
	private int teamID;
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public ArrayList<Competitor> getTeammates() {
		return teammates;
	}

//	public void setTeammates(ArrayList<Competitor> teammates) {
//		this.teammates = teammates;
//	}
	
	public void addCompetitor(Competitor c)
	{
		teammates.add(c);
	}
	
//	public Competitor getCompetitor(int index)
//	{
//		return teammates.get(index);
//	}
	
	public Team()
	{
		super();
	}
	
	public int getTeamID() {
		return teamID;
	}

	@Override
	public int createID()
	{
		//TO DO: write a concrete ID generator for Team class
		this.teamID = 0;
		return 0;
	}
}
