package hr.fer.oop.fall_2017_18.task2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HighScore {

	public static void print(List<Result> results) {
		Map<Integer, Set<String>> map = new TreeMap<>();
		for(Result result : results) {
			Set<String> set = map.get(result.time);
			if (set == null) {
				set = new LinkedHashSet<>();
				map.put(result.time, set);
			}
			set.add(result.name);
		}
		
		Set<String> used = new HashSet<>();
		int pos = 1;
		for(Map.Entry<Integer, Set<String>> entry : map.entrySet()) {
			for(String name : entry.getValue()) {
				if (used.add(name)) {
					System.out.format("%d. %10s %5d%n", pos++, name, entry.getKey());
				}
			}
		}		
	}

}
