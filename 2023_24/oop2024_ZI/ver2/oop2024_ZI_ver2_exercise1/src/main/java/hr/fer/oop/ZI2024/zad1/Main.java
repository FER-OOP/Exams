package hr.fer.oop.ZI2024.zad1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
 		String startDir = System.getProperty("project.dir");
 		if (startDir == null) startDir = System.getProperty("user.dir");

 		Path startPath = Path.of(startDir, "src", "main", "resources", "data");
        MyFileVisitor visitor = new MyFileVisitor();
        
        try {        	
        	Files.walkFileTree(startPath, visitor);
        	        	
        	visitor.getItems().forEach(
        			item -> System.out.printf("%s,%d,%.2f\n", item.getName(), item.getQuantity(), item.getPrice())
        			);
            System.out.println("Total price: " + visitor.getTotalPrice());
            System.out.println("Total quantity: " + visitor.getTotalQuantity());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
