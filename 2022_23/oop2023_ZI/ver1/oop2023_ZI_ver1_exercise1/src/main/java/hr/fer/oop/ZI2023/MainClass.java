package hr.fer.oop.ZI2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainClass {

	public static void main(String[] args) {
	
		String[] extensions = {".txt", ".gz"};

		// To correctly find the project dir
		String startdir = System.getProperty("project.dir");
		if (startdir == null) {
			startdir = System.getProperty("user.dir");
        }		
		Path path = Path.of(startdir, "src", "main", "resources", "data");
		
		MyFileVisitor visitor = new MyFileVisitor(extensions);
		try {
			Files.walkFileTree(path,  visitor);
			
			System.out.printf("Number of files: %d%n", visitor.getNumFiles());
			System.out.printf("Number of folders: %d%n", visitor.getNumFolders());
			System.out.printf("Largest file size: %d%n", visitor.getLargestFileSize());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
