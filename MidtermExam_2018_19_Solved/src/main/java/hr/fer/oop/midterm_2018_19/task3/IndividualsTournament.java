package hr.fer.oop.midterm_2018_19.task3;

public class IndividualsTournament extends Tournament {

	public IndividualsTournament(String name, String when) {
		super(name, when);		
	}
	

	@Override
	public boolean addCompetitor(Competitor newCompetitor) {
		if (newCompetitor instanceof Player) 
		{
			return super.addCompetitor(newCompetitor);
		}
		else {
			return false;
		}
	}

}
