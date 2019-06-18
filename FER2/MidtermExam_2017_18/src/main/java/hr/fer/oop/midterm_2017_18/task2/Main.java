package hr.fer.oop.midterm_2017_18.task2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {	
		Set<String> skills = new HashSet<>();
		skills.add("Jumping");
		skills.add("Marking");
		skills.add("Tackling");
		skills.add("Positioning");
		skills.add("Strength");
		Map<String, Map<String, Integer>> players = loadPlayers();
		
		List<String> chosenPlayers = bestPlayers(players, skills, 15, 0.8);
		for(String name : chosenPlayers) { //should write John Stone and Mark Strong
			System.out.println(name);
		}			
	}
	
	private static Map<String, Map<String, Integer>> loadPlayers() {
		Map<String, Map<String, Integer>> players = new HashMap<>();
		
		Map<String, Integer> skills = new HashMap<>();
		skills.put("Jumping", 12);
		skills.put("Marking", 15);
		skills.put("Tackling", 20);
		skills.put("Positioning", 19);
		skills.put("Strength", 20);
		players.put("John Stone", skills);
		
		skills = new HashMap<>();
		skills.put("Jumping", 1);
		skills.put("Marking", 20);
		skills.put("Tackling", 5);
		skills.put("Positioning", 20);
		skills.put("Strength", 1);
		players.put("Brian Light", skills);
		
		skills = new HashMap<>();
		skills.put("Jumping", 19);
		skills.put("Marking", 20);
		skills.put("Tackling", 16);
		skills.put("Positioning", 20);
		skills.put("Strength", 20);
		players.put("Mark Strong", skills);
		
		skills = new HashMap<>();
		skills.put("Jumping", 20);
		skills.put("Marking", 5);
		skills.put("Tackling", 8);
		skills.put("Positioning", 15);
		skills.put("Strength", 13);
		players.put("Jean Jumpo", skills);
		
		skills = new HashMap<>();
		skills.put("Jumping", 20);
		skills.put("Marking", 20);
		skills.put("Tackling", 8);
		skills.put("Positioning", 7);
		skills.put("Strength", 4);
		skills.put("Shooting", 20);
		skills.put("Speed", 20);
		players.put("Sunday Fox", skills);
		
		return players;	
	}
	
	private static int countSkills(Map<String, Integer> playerSkills, Set<String> skills, int minSkillValue) {
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
