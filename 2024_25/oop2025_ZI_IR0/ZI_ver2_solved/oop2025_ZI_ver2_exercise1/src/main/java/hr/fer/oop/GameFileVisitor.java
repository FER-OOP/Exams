package hr.fer.oop;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameFileVisitor extends SimpleFileVisitor<Path> {

	private Map<Integer, Integer> attendMap = new HashMap<>();

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		Charset c = StandardCharsets.UTF_8;
		List<String> lines = Files.readAllLines(file, c);
		int cnt = 0;
		for (String line : lines) {
			cnt ++;
			if (cnt == 1) {
				continue;
			}
			// System.out.println(line);
			GameInfo ginf = GameInfo.createFromString(line);
			int week = ginf.week;
			int attend = ginf.attendance;
			
			if (attendMap.containsKey(week)) {
				int oldattend = attendMap.get(week);
				attendMap.put(week, (attend > oldattend) ? attend:oldattend);
			}
			else {
				attendMap.put(week,  attend);
			}
		}
		return FileVisitResult.CONTINUE;
	}
	
	public Map<Integer, Integer> getAttendanceMap() {
		return attendMap;
	}

	
}
