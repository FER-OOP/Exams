package hr.fer.oop.songs;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Set;

//TO DO Finish this class by changing methods below and adding what is necessary
public class SongsVisitor extends SimpleFileVisitor<Path> {
		
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {	
		return FileVisitResult.CONTINUE;
	}

	public int getFilesCount() {
		return -1;
	}

	public Set<String> getFirstLines() {		
		return Set.of();
	}
}
