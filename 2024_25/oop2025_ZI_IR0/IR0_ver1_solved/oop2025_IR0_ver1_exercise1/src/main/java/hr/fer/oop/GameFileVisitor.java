package hr.fer.oop;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class GameFileVisitor extends SimpleFileVisitor<Path> {

	private String maxAttVenue = "";
	private int maxAttendance = 0;
	private String minAttVenue = "";
	private int minAttendance = 0;

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
			if (this.maxAttendance == 0 || ginf.attendance > this.maxAttendance) {
				this.maxAttendance = ginf.attendance;
				this.maxAttVenue = ginf.venue;
			}
			if (this.minAttendance == 0 || ginf.attendance < this.minAttendance) {
				this.minAttendance = ginf.attendance;
				this.minAttVenue = ginf.venue;
			}
			
		}
		return FileVisitResult.CONTINUE;
	}

	public String getMaxAttVenue() {
		return maxAttVenue;
	}

	public int getMaxAttendance() {
		return maxAttendance;
	}
	
	public String getMinAttVenue() {
		return minAttVenue;
	}

	public int getMinAttendance() {
		return minAttendance;
	}
}
