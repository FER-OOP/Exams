package hr.fer.oop.t2.loaders;

import java.util.Arrays;

public class HardcodedLoader implements DataLoader {
	@Override
	public Iterable<String> Load() {
		String s = "the quick brown fox jumps over the lazy dog";
		return Arrays.asList(s.split(" "));
	}
}
