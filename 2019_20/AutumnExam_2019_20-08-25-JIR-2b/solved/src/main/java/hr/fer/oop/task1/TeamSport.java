package hr.fer.oop.task1;

public abstract class TeamSport extends Sport
{
	private Team homeTeam;
	private Team awayTeam;
	
	public TeamSport()
	{
		super();
	}
		
	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	
}
