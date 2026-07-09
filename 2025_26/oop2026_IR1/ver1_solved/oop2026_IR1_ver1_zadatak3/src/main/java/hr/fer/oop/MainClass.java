package hr.fer.oop;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainClass {

    
	public static void callVisitor(Path datafolder, FileVisitor<Path> visitor)
            throws IOException {
        
			Files.walkFileTree(datafolder, visitor);
			
    }
	
	
    public static void main(String[] args) throws IOException {
        Path datafolder = Path.of("src", "main", "resources");

        WorldCupFileVisitor visitor = new WorldCupFileVisitor();

        callVisitor(datafolder, visitor);

        System.out.println("Unbeaten teams:");
        visitor.getUnbeatenTeams().forEach(System.out::println);
        
        /* Očekivani ispis: 
        Unbeaten teams:
        	Spain
        	Brazil
        	Canada
        	France
        	Mexico
        	Belgium
        	Croatia
        	Germany
        	Portugal
        	Argentina
        	Netherlands
        	United States
		*/
        
    }
    
    
    
}