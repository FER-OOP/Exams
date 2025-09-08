package hr.fer.oop;

public class PlayerResult {

	public int year;
	public String playerName;
	public int points;
	public int wins;
	public String mapName;
	
	public PlayerResult(int year, String playerName, int points, int wins, String mapName) {
		this.year = year;
		this.playerName = playerName;
		this.points = points;
		this.wins = wins;
		this.mapName = mapName;
	}
	
	public static PlayerResult createFromString(String line) {
		String[] parts = line.split(";");
		if (parts.length < 5) {
			System.out.println("Invali num. columns: " + parts.length);
			return null;
		}
		
		int year = Integer.parseInt(parts[0]);
		String playerName = parts[1];
		int points = Integer.parseInt(parts[2]);
		int wins = Integer.parseInt(parts[3]);
		String map = parts[4];

		return new PlayerResult(year, playerName, points, wins, map);
	}
	
	public String toString() {
		return String.format("(%d) %s : %d , %d, %s", year, playerName, points, wins, mapName);
	}

}
