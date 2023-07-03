package hr.fer.oop.ZI2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainClass {

	public static void main(String[] args) {
		String fileName = "primers_2.fasta";
		
		// To correctly find the project dir
		String startdir = System.getProperty("project.dir");
		if (startdir == null) {
			startdir = System.getProperty("user.dir");
        }		
		Path path = Path.of(startdir, "src", "main", "resources", "data");
				
		MyFileVisitor visitor = new MyFileVisitor(fileName);
		
		try {
			Files.walkFileTree(path,  visitor);
			
			System.out.printf("First line: %s%n", visitor.getFirstLine());
			System.out.printf("File found in folder: %s%n", visitor.getFolderName());
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
