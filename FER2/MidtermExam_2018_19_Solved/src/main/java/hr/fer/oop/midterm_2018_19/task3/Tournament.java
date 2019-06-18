package hr.fer.oop.midterm_2018_19.task3;

import java.util.LinkedList;
import java.util.List;

public abstract class Tournament {
	private final String name;
	private String when;
	private List<Competitor> competitors = new LinkedList<>();

	public Tournament(String name, String when) {
		this.name = name;
		this.when = when;		
	}

	public final String getName() {
		return name;
	}
	
	public final String getWhen() {
		return when;
	}

	public final void setWhen(String when) {
		this.when = when;
	}
	
	public final int count() {
		return competitors.size();
	}
	
	public void print() {
		System.out.print(this.name);
		for(Competitor c : competitors) {
			System.out.format(" %s", c.getNickname());
		}
		System.out.println();
	}
	
	public boolean addCompetitor(Competitor competitor) {
		boolean found = false;
		for(Competitor c : competitors) {
			if (competitor.getNickname().equals(c.getNickname())) {
				found = true;
				break;
			}
		}
		if (!found) {
			competitors.add(competitor);
		}
		return !found;
	}
	
	public void removeCompetitor(Competitor competitor) {
		Competitor found = null;
		for(Competitor c : competitors) {
			if (competitor.getNickname().equals(c.getNickname())) {
				found = c;
				break;
			}
		}
		if (found != null) {
			competitors.remove(found);
		}
	}
	
	
}
