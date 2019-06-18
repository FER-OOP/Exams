package hr.fer.oop.midterm_2018_19.task3;

public class Team implements Competitor {
	
	private String nickname;
	private Player[] players;	
	
	public Team(String nickname, Player[] players) {
		this.nickname = nickname;
		this.players = new Player[players.length];
		for(int i=0; i<players.length; i++) {
			this.players[i] = players[i];			
		}
	}
	@Override
	public String getNickname() {
		return nickname;
	}
	
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
