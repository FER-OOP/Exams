package hr.fer.oop.task1;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Main
{

	public static void main(String[] args)
	{
		System.out.println("Testing 123\n");
		
		//Put in some competitors all of them are for the new team created.
		List<Team> teamList = new ArrayList<>();
		
		Team politickiTrgovci = new Team();
		politickiTrgovci.createID();
		politickiTrgovci.setTeamName("Politicki Trgovci");
		List<Competitor> competitorList1 = new ArrayList<>();	
		competitorList1.add(new Competitor("Ivan", "Perić", LocalDate.of(1999, 2, 17), 190, 78, 100));
		competitorList1.add(new Competitor("Marko", "Marić", LocalDate.of(1979, 3, 22), 160, 81, 101));
		competitorList1.add(new Competitor("Mirko", "Tomić", LocalDate.of(1997, 6, 12), 120, 85, 105));
		competitorList1.add(new Competitor("Janko", "Ivanić", LocalDate.of(1988, 8, 23), 185, 300, 202));
		competitorList1.add(new Competitor("Stanko", "Stanić", LocalDate.of(1994, 8, 5), 202, 75, 296));
		competitorList1.add(new Competitor("Žarko", "Mirković", LocalDate.of(1994, 3, 2), 210, 89, 299));
		for(Competitor c : competitorList1)
		{
			politickiTrgovci.addCompetitor(c);
		}
		teamList.add(politickiTrgovci);
		
		Team testnaOpozicija = new Team();
		testnaOpozicija.createID();
		testnaOpozicija.setTeamName("Testna Opozicija");
		List<Competitor> competitorList2 = new ArrayList<>();
		competitorList2.add(new Competitor("Vojko", "Stanković", LocalDate.of(1993, 4, 8), 155, 80, 300));
		competitorList2.add(new Competitor("Milojko", "Horvat", LocalDate.of(1997, 5, 4), 196, 100, 305));
		competitorList2.add(new Competitor("Gojko", "Perović", LocalDate.of(1995, 11, 18), 180, 65, 308));
		competitorList2.add(new Competitor("Veljko", "Sarić", LocalDate.of(1990, 12, 29), 176, 95, 999));
		for(Competitor c : competitorList2)
		{
			testnaOpozicija.addCompetitor(c);
		}
		teamList.add(testnaOpozicija);
		
		//Test printout of teams
		teamList.forEach(e -> System.out.println(e.getTeamName()));
		System.out.println("----");
		//testprintout of all competitors
		teamList.forEach(e -> e.getTeammates().forEach(t -> System.out.println(" -> " + t.getName() + " " + t.getSurname())) );
		
		//Put all of the footballgames in one ArrayList
		ArrayList<FootballGame> footballGamesList = new ArrayList<>();
		FootballGame footballGame1 = new FootballGame();
		//footballGame1.setDate(LocalDate.of(2004, 6, 1));
		footballGame1.setAwayTeam(politickiTrgovci);
		footballGame1.setHomeTeam(testnaOpozicija);
		footballGame1.setGameAgeCategory(AgeCategory.SENIOR);
		//Test print
		System.out.println(footballGame1.getHomeTeam().getTeamName());
		System.out.println(footballGame1.getAwayTeam().getTeamName());
		System.out.println(footballGame1.getHomeTeam().getTeammates().get(2).getName());
		//Add some real results to the game
		footballGame1.addToScoreMap(footballGame1.getHomeTeam().getTeammates().get(2), "1, 2, 3");
		footballGamesList.add(footballGame1);
		footballGamesList.forEach(e -> System.out.println(e.getHomeTeam().getTeamName() + " - " + e.getAwayTeam().getTeamName() ));
		
	}

}
