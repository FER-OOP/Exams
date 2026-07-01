package hr.fer.oop;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LogVisitor extends SimpleFileVisitor<Path> {

	private int totalErrors = 0;

	private String worstFile = null;
	private int worstFileErrors = 0;

	private final Set<String> criticalFiles = new TreeSet<>();

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (!file.getFileName().toString().endsWith(".log")) {
			return FileVisitResult.CONTINUE;
		}

		int errorsInFile = 0;
		List<String> lines = Files.readAllLines(file);
		
		if (lines.isEmpty()) {
		    return FileVisitResult.CONTINUE;
		}
		for (String line : lines) {
			if (line.startsWith("ERROR")) {
				errorsInFile++;
			}
		}

		totalErrors += errorsInFile;
		
		
		if (errorsInFile > worstFileErrors) {
			worstFileErrors = errorsInFile;
			worstFile = file.toString();
		}
		
		if (errorsInFile > 5) {
			criticalFiles.add(file.getFileName().toString());
		}

		return FileVisitResult.CONTINUE;
	}

	public int getTotalErrors() {
		return totalErrors;
	}
	
	public String getWorstFile() {
		return worstFile;
	}

	public Collection<String> getCriticalFiles() {
		return criticalFiles;
	}
}
