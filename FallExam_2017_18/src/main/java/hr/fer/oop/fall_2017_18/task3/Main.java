package hr.fer.oop.fall_2017_18.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter directory:");
			String dirName = sc.nextLine();
			Path path = Paths.get(dirName);
			MyFileVisitor visitor = new MyFileVisitor();			
			try {
				Files.walkFileTree(path, visitor);				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			visitor.getMap().entrySet()
				   .stream()				  
				   .forEach(p -> {
					   System.out.format("%s %d%n", p.getKey(), p.getValue());
				   });
			
			OptionalDouble optional = visitor.getMap().entrySet()
											   .stream()
											   .filter(p -> p.getKey().contains("Main"))
											   .mapToInt(p -> p.getValue())
											   .average();
			if (optional.isPresent()) {
				System.out.println("Prosjecan broj brojeva u datotekama koje sadrze rijec Main: "  + optional.getAsDouble());
			}
			else {
				System.out.println("Ne postoji java datoteka koja sadrzi rijec Main.");
			}						    
		}
	}
}