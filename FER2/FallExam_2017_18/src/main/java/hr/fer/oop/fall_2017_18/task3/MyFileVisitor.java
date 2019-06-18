package hr.fer.oop.fall_2017_18.task3;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
	private Map<String, Integer> map = new HashMap<>();
	
	public Map<String,Integer> getMap(){		
		return map;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

		if (file.toString().endsWith("java")) {			
			List<String> lines = Files.readAllLines(file);
			int count = NumberCounter.countNumbers(lines);			
			map.put(file.toString(), count);			
		}

		return FileVisitResult.CONTINUE;
	}
}

