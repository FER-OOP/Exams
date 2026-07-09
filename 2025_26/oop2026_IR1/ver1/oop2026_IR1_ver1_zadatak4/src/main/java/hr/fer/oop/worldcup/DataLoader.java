package hr.fer.oop.worldcup;

import java.util.HashMap;
import java.util.Map;

public class DataLoader {

    public static Map<String, Map<String, Integer>> loadTeams() {
        Map<String, Map<String, Integer>> teams = new HashMap<>();

        Map<String, Integer> scorers = new HashMap<>();
        scorers.put("Neymar", 6);
        scorers.put("Vinicius", 5);
        scorers.put("Endrick", 3);
        scorers.put("Raphinha", 2);
        teams.put("Brazil", scorers);

        scorers = new HashMap<>();
        scorers.put("Kramaric", 6);
        scorers.put("Modric", 5);
        scorers.put("Perisic", 3);
        scorers.put("Baturina", 1);
        scorers.put("Musa", 1);
        teams.put("Croatia", scorers);

        scorers = new HashMap<>();
        scorers.put("Messi", 4);
        scorers.put("Alvarez", 2);
        scorers.put("Martinez", 2);
        scorers.put("Fernandez", 1);
        scorers.put("Mac Allister", 1);
        teams.put("Argentina", scorers);

        scorers = new HashMap<>();
        scorers.put("Mbappe", 8);
        scorers.put("Olise", 5);
        scorers.put("Dembele", 1);
        teams.put("France", scorers);

        scorers = new HashMap<>();
        scorers.put("Gakpo", 3);
        scorers.put("Depay", 1);
        scorers.put("Dumfries", 1);
        teams.put("Netherlands", scorers);

        scorers = new HashMap<>();
        scorers.put("Davies", 1);
        teams.put("Canada", scorers);

        return teams;
    }
}