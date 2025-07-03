package hr.fer.oop;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainClass {

	public static void main(String[] args) {
		Path datafolder = Path.of("src/main/resources/");
		GameFileVisitor visitor = new GameFileVisitor();
		
		callVisitor(datafolder, visitor);
		
		System.out.println("Maximum attendance: " + visitor.getMaxAttVenue() + ": " + visitor.getMaxAttendance());
		System.out.println("Minimum attendance: " + visitor.getMinAttVenue() + ": " + visitor.getMinAttendance());
	}
	
	public static void callVisitor(Path datafolder, FileVisitor<Path> visitor) {
		try {
			Files.walkFileTree(datafolder, visitor);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
