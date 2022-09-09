package hr.fer.oop.t2;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import hr.fer.oop.t2.loaders.DataLoader;
import hr.fer.oop.t2.loaders.NoDataException;

public class Counter {
	private Map<String, Integer> words = new TreeMap<>();
	private int exceptionsCount = 0;
	public Map<String, Integer> getWords() {
		return Collections.unmodifiableMap(words);
	}
	public int getExceptionsCount() {
		return exceptionsCount;
	}
	
	public void process(DataLoader loader) {
		try {
			for(String s : loader.Load()) {
				words.merge(s, 1, (old, def) -> old + 1);
			}
		}
		catch(NoDataException e) {
			++exceptionsCount;
		}
	}
}
