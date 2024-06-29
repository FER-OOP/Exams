package hr.fer.oop.players;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Map<String, Map<String, Integer>> players = DataLoader.loadPlayers();
		
		Set<String> skills = new HashSet<>();
		skills.add("Finishing");
		skills.add("Marking");
		skills.add("Tackling");
		skills.add("Positioning");
		skills.add("Strength");
		
		Map<String, Integer> sundayFoxSkills = players.get("Sunday Fox");
		System.out.println(sundayFoxSkills); // {Positioning=7, Speed=20, Shooting=20, Marking=20, Jumping=20, Tackling=8, Strength=4}
		System.out.println(skills); // [Positioning, Marking, Finishing, Tackling, Strength]
		int count = Task.countSkills(sundayFoxSkills, skills, 8);
		System.out.println(count);  // 2
				
		
		skills.add("Jumping");		
		skills.remove("Finishing");
		
		List<String> chosenPlayers = Task.bestPlayers(players, skills, 15, 0.8);
		for(String name : chosenPlayers) { //should write John Stone and Mark Strong (in any order)
			System.out.println(name);
		}	
		
		chosenPlayers = Task.bestPlayers(new HashMap<>(), skills, 15, 0.8);
		System.out.println(chosenPlayers.size()); // prints 0
	}

}
