package hr.fer.oop.players;

import java.util.HashMap;
import java.util.Map;

public class DataLoader {
	public static Map<String, Map<String, Integer>> loadPlayers() {
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
}
