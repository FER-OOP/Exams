package hr.fer.oop.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws IOException {		
		Path path = Paths.get(".");	
		System.out.println("File types in: " + path.toAbsolutePath().toString());
		//TO DO:				
	}

}
