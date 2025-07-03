package hr.fer.oop;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class MainClass {

	public static void main(String[] args) {
		Path datafolder = Path.of("src/main/resources/");
		GameFileVisitor visitor = new GameFileVisitor();
		
		callVisitor(datafolder, visitor);
		
		Map<Integer, Integer> attendMap = visitor.getAttendanceMap();
		
		System.out.println("Maximum attendance for each week:");
		for (Integer week : attendMap.keySet())  {
			int maxAttend = attendMap.get(week);
			System.out.println("Week " + week + ", maximum attendance: " + maxAttend);
		}
	}
	
	public static void callVisitor(Path datafolder, FileVisitor<Path> visitor) {
		try {
			Files.walkFileTree(datafolder, visitor);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
