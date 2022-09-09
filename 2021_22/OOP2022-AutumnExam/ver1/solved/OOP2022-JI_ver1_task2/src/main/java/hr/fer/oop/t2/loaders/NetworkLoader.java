package hr.fer.oop.t2.loaders;

import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class NetworkLoader implements DataLoader {
	private String url;

	public NetworkLoader(String url) {
		this.url = url;
	}

	@Override
	public Iterable<String> Load() throws NoDataException {
		try(Scanner sc = new Scanner(new URL(url).openStream())) {
			String s = sc.nextLine();
			return Arrays.asList(s.split(" "));
		}
		catch(Exception e) {
			throw new NoDataException(e);
		}
	}
}
