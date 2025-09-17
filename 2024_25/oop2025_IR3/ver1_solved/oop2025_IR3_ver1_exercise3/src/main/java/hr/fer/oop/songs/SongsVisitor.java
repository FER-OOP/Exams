package hr.fer.oop.songs;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SongsVisitor extends SimpleFileVisitor<Path> {
	private Comparator<String> comparator = Comparator.comparing(String::length)
											    	  .thenComparing(Comparator.naturalOrder());
	private Set<String> firstLines = new TreeSet<String>(comparator);
	private int filesCount = 0;
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (attrs.isRegularFile() && file.toString().toLowerCase().endsWith(".txt")) {
			++filesCount;
			try(Scanner sc = new Scanner(file)) {
				firstLines.add(sc.nextLine());
			}			
		}
		return FileVisitResult.CONTINUE;
	}

	public int getFilesCount() {
		return filesCount;
	}

	public Set<String> getFirstLines() {
		return firstLines;
	}
}
