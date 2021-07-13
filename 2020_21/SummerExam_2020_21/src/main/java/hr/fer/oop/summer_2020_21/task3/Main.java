package hr.fer.oop.summer_2020_21.task3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {

	private Map<Integer, User> users = new HashMap<>();

	private void importData(String filename) throws IOException {
		List<String> lines = Files.readAllLines(Path.of(filename), StandardCharsets.UTF_8);

		for (String line : lines) {
			try {
				String[] parts = line.split(";");
				if (!users.containsKey(Integer.parseInt(parts[0])))
					users.put(Integer.parseInt(parts[0]),
							new User(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3],
									Integer.parseInt(parts[4]), Integer.parseInt(parts[5]),
									Integer.parseInt(parts[6])));
			} catch (Exception e) {
				System.out.println("ERR");
			}
		}
	}

	private void notifyNonActiveUsers() {
		sendNotification(users.values().stream().filter(a -> a.getHoursActive() < 3).map(a -> a.getEmail())
				.collect(Collectors.toList()));
	}

	private Map<Integer, Double> convertMoneyToAnotherCurrency(double rate) {
		return users.entrySet().stream()
				.collect(Collectors.toMap(Entry::getKey, e -> Double.valueOf(e.getValue().getCurrentSaldo()) * rate));
	}

	private void mergeNewUsers(Map<Integer, User> newUsers) {
		newUsers.forEach((k, v) -> users.merge(k, v,
				(v1, v2) -> new User(v1.getUserId(), v1.getUsername(), v1.getPassword(), v1.getEmail(),
						v1.getHoursActive(), v1.getHoursActive(), v1.getCurrentSaldo() + v2.getCurrentSaldo())));
	}

	private static void sendNotification(List<String> usersToNotify) {
		System.out.println("Sending mail notification to:");
		for (String s : usersToNotify)
			System.out.println(s);
	}
}
