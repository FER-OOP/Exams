package hr.fer.oop.players;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;


public class Task {	
	public static Stream<PlayerInfo> bySkillAndName(Stream<PlayerInfo> players) {
		return players.sorted((a, b) -> {
			int r = b.noOfSkillsDefined() - a.noOfSkillsDefined();
			if (r == 0)
				r = a.name().compareTo(b.name());
			
			return r;
		});
	}
	
	public static Stream<PlayerInfo> skilfulPlayers(Map<String, Map<String, Integer>> players, Set<String> requiredSkills, int minSkillValue) {
		int requiredCount = requiredSkills.size();
		return players.entrySet()
				      .stream()
				      .filter(playerEntry -> 
				    	  		playerEntry.getValue() //map of skills
				    	  				   .entrySet()
				    	  				   .stream() //stream of pairs skill name, skill value
				    	  				   .filter(skillEntry -> requiredSkills.contains(skillEntry.getKey()) //one of required skills 
				    	  			            && skillEntry.getValue() >= minSkillValue)
				    	  				   .count() >= requiredCount)				    	  	   				     
					  .map(entry -> new PlayerInfo(entry.getKey(), 
							                       entry.getValue().size()));
					
	}	
}
