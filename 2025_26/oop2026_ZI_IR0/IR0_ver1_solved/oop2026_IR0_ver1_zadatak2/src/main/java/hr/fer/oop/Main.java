package hr.fer.oop;

import java.nio.file.Path;
import java.util.Collection;
import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;

public class Main {
	
	public static void main(String[] args) {
        Path startDir = Path.of("src/main/resources/txtExercise/");
    	TxtSearchVisitor visitor = new TxtSearchVisitor();
    	
    	callVisitor(startDir, visitor);
    	
    	System.out.println("Total .txt files: " + visitor.getTotalTxtFiles());
    	System.out.println("Total size (bytes): " + visitor.getTotalSize());
    	
    	System.out.println("Directories: ");
    	Collection<String> directories = visitor.getDirectories();
    	for (String dir : directories) {
    		System.out.println(dir);
    	}
	}
	
	public static void callVisitor(Path startDir, FileVisitor<Path> visitor) {
		try {
			Files.walkFileTree(startDir, visitor);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

}
