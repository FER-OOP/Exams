package hr.fer.oop.midterm_2018_19.task3;

public class Main {

	public static void main(String[] args) {
		Person[] persons = new Person[] {
				new Person("03564", "John Butcher"),
				new Person("13235", "Ann Lord"),				
				new Person("25674", "Steven Blacksmith"),
				new HumanPlayer("snowie", "99999", "Marie Snow"),
				new HumanPlayer("Antra", "656544", "Anthony Travolta"),
				new HumanPlayer("diane", "999321",  "Diana Hopkins"),
				new HumanPlayer("Ivan Grozni", "44664", "Ivan Stroganov")
		};
		
		Robot[] robots = new Robot[] {
				new Robot("Shallow red", "9999-1234-65666"),
				new Robot("Pluk", "2687-12-507"),
				new Robot("Nosferatu ", "0365-4794-13713"),
				new Robot("Roadrunner", "4444-1212-56787"),
				new Robot("Wile v2", "3647-3333-44444")				
		};
		
		for(int i=0; i<robots.length; i++) {
			robots[i].setContactPerson(persons[i]);
		}
		
		IndividualsTournament cross = new IndividualsTournament("Cross running", "spring 2019");
		System.out.println(cross.addCompetitor(robots[0])); //true
		System.out.println(cross.addCompetitor((HumanPlayer) persons[4])); //true
		System.out.println(cross.addCompetitor((HumanPlayer) persons[5])); //true
		
		HumanPlayer diane = new HumanPlayer("diane", "999321",  "Diana Hopkins");
		System.out.println(cross.addCompetitor(diane)); //false (diane already registered)
		cross.print(); //Cross running 9999-1234-65666 Antra diane
					
				
		TeamTournament volleyball = new TeamTournament("Beach Volleyball", "summer 2019");						
		Team roboteam = new Team("RoboVolley", robots);		
		volleyball.addCompetitor(roboteam);			
		Team hybrid = new Team("Hybrid", new Player[] { robots[1], diane });
		volleyball.addCompetitor(hybrid);
		
		volleyball.print();//Beach Volleyball RoboVolley Hybrid
	}

}
