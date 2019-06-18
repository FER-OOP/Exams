package hr.fer.oop.midterm_2018_19.task3;

public class Team  {
	
	private String nickname;
	private Player[] players;	
		
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nickname);
		sb.append(" :");
		for(int i=0; i<players.length; i++) {
			sb.append(' ');
			sb.append(players[i]);		
		}
		return sb.toString();
	}
	
}
