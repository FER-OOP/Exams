package hr.fer.oop;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		Path startDir = Path.of("src/main/resources/");
		LogVisitor visitor = new LogVisitor();

		callVisitor(startDir, visitor);

		System.out.println("Total errors: " + visitor.getTotalErrors());
		System.out.println("Worst file: " + visitor.getWorstFile());
		
		System.out.println("Critical files: ");
		for (String path : visitor.getCriticalFiles()) {
			System.out.println(path);
		}
	}
	
	public static void callVisitor(Path startDir, FileVisitor<Path> visitor) {
		// TODO
	}
}