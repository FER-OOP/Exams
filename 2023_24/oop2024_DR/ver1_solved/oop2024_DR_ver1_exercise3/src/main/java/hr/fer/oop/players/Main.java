package hr.fer.oop.players;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Map<String, Map<String, Integer>> players = DataLoader.loadPlayers();
		
		Set<String> skills = new HashSet<>();
		skills.add("Jumping");
		skills.add("Marking");		
		skills.add("Positioning");
		skills.add("Strength");
		
			
		Stream<PlayerInfo> skilfulPlayers = Task.skilfulPlayers(players, skills, 12);
		skilfulPlayers.forEach(System.out::println); 
		//prints (in any order)
		//PlayerInfo[name=John Stone, noOfSkillsDefined=5]
		//PlayerInfo[name=Mark Strong, noOfSkillsDefined=5] 
		
		System.out.println("----------");
		
		skills.clear();
		skills.add("Jumping");
		skilfulPlayers = Task.bySkillAndName(Task.skilfulPlayers(players, skills, 1));
		
		skilfulPlayers.forEach(System.out::println); 
		//prints (in exact order)
		//		PlayerInfo[name=Sunday Fox, noOfSkillsDefined=7]
		//		PlayerInfo[name=Speedy Gonzales, noOfSkillsDefined=6]
		//		PlayerInfo[name=Brian Light, noOfSkillsDefined=5]
		//		PlayerInfo[name=Jean Jumpo, noOfSkillsDefined=5]
		//		PlayerInfo[name=John Stone, noOfSkillsDefined=5]
		//		PlayerInfo[name=Mark Strong, noOfSkillsDefined=5]
		//
		
		System.out.println("----------");
		skills.clear();
		skills.add("Pace");
		skilfulPlayers = Task.skilfulPlayers(players, skills, 1);
		skilfulPlayers.forEach(System.out::println); // prints nothing
		
	}

}
