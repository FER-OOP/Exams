package hr.fer.oop.jir2024.zad1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		String startDir = System.getProperty("project.dir");
		if (startDir == null) startDir = System.getProperty("user.dir");

		Path startPath = Path.of(startDir, "src", "main", "resources", "data");
		
		List<String> extList = List.of("txt","jpg");
		List<String> skipList = List.of("file5.txt", "file8.jpg");
		
		FileRemoveSimulator sim = new FileRemoveSimulator(extList, skipList);

		try {        	
			Files.walkFileTree(startPath, sim);

			System.out.println("getFilesMarkedForRemoval():");
			sim.getFilesMarkedForRemoval().forEach(f -> System.out.println(f));
			
			System.out.println("\ngetExcludedFiles():");
			sim.getExcludedFiles().forEach(f -> System.out.println(f));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
