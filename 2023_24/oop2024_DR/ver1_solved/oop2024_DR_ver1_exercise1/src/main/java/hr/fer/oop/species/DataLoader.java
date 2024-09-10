package hr.fer.oop.species;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DataLoader {
	public static Map<String, Set<String>> loadTaxa(InputStream stream) {
		Map<String, Set<String>> map = new TreeMap<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));		
		String line;
		try {
			while(( line = reader.readLine()) != null) {
				String[] data = line.split(" ");
				Set<String> species = map.get(data[0]);
				if (species == null) {
					species = new TreeSet<>();
					map.put(data[0], species);
				}
				species.add(data[1]);
			}
		} catch (IOException e) {
			TreeSet<String> set = new TreeSet<>();
			set.add(e.getMessage());
			map.put("Exception", set);
		}
		return map;
	}
}
