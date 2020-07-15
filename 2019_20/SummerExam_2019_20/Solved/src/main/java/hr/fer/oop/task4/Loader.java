package hr.fer.oop.task4;

import java.util.HashMap;
import java.util.Map;

public class Loader {

    public static Map<String, Map<String, Integer>> loadData() {
        Map<String, Integer> electionUnit1 = new HashMap<>();
        electionUnit1.put("Blue", 100);
        electionUnit1.put("Green", 200);
        electionUnit1.put("Yellow", 300);
        electionUnit1.put("Red", 400);

        Map<String, Integer> electionUnit2 = new HashMap<>();
        electionUnit2.put("Yellow", 100);
        electionUnit2.put("Green", 200);
        electionUnit2.put("Red", 300);
        electionUnit2.put("Blue", 400);

        Map<String, Map<String, Integer>> votes = new HashMap<>();
        votes.put("eu1", electionUnit1);
        votes.put("eu2", electionUnit2);

        return votes;
    }
}
