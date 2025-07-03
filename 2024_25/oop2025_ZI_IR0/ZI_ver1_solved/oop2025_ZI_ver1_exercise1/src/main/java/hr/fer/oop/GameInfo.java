package hr.fer.oop;

public class GameInfo {
	public int week;
	public String homeTeam;
	public String awayTeam;
	public int homeGoals;
	public int awayGoals;
	public String venue;
	public int attendance;

	private GameInfo(int week, String homeTeam, String awayTeam, int homeGoals, int awayGoals, String venue, int attendance) {
		this.week = week;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeGoals = homeGoals;
		this.awayGoals = awayGoals;
		this.venue = venue;
		this.attendance = attendance;
	}

	public static GameInfo createFromString(String line) {
		String[] columns = line.split("\\t");
		if (columns.length < 11) {
			System.out.println("Invali num. columns: " + columns.length);
			return null;
		}
		
		int week = Integer.parseInt(columns[0]);
		String hometeam = columns[2];
		int homegoals = Integer.parseInt(String.valueOf(columns[4].charAt(0)));
		int awaygoals = Integer.parseInt(String.valueOf(columns[4].charAt(2)));
		String awayteam = columns[6];
		String sAtt = columns[7].replaceAll(",", "");
		int attendance = Integer.parseInt(sAtt);
		String venue = columns[8];

		return new GameInfo(week, hometeam, awayteam, homegoals, awaygoals, venue, attendance);
	}
	
	public String toString() {
		return String.format("(week %02d) %s - %s : %d - %d, %s (%d)", week, homeTeam, awayTeam, homeGoals, awayGoals, venue, attendance);
	}

}
