package hr.fer.oop.players;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task {
	public static int countSkills(Map<String, Integer> playerSkills, Set<String> skills, int minSkillValue) {
		int count = 0;	
		for(Map.Entry<String, Integer> playerSkill : playerSkills.entrySet()){
			if (skills.contains(playerSkill.getKey()) && playerSkill.getValue() >= minSkillValue){
				count++;
			}
		}
		return count;
	
	}

	public static List<String> bestPlayers(Map<String, Map<String, Integer>> players, Set<String> skills, int minSkillValue, double minPercentage){
		List<String> chosenPlayers = new LinkedList<>();	
				
		for(Map.Entry<String, Map<String, Integer>> player : players.entrySet()){
			int count = countSkills(player.getValue(), skills, minSkillValue);							
			if ((double) count / skills.size() >= minPercentage) {
				chosenPlayers.add(player.getKey());
			}
		}
		return chosenPlayers;
	}
}
