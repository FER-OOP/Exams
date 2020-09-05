package hr.fer.oop.task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CustomFileVisitor extends SimpleFileVisitor<Path> {

	private Path maxFilePath;
	private long maxFileSize = -1;
	private int maxFilesPerDir = 0;
	private Path maxFilesPerDirPath;

	public Path getMaxFilePath() {
		return maxFilePath;
	}

	public long getMaxFileSize() {
		return maxFileSize;
	}

	public Path getMaxFilesDirPath() {
		return maxFilesPerDirPath;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		int counter = 0;

		for (File f : dir.toFile().listFiles()) {
			if (f.isFile())
				counter++;
		}
		if(counter == maxFilesPerDir) {
			if(maxFilesPerDirPath.toString().compareTo(dir.toString()) > 1) maxFilesPerDirPath = dir;
		}
		else if(counter > maxFilesPerDir) {
			maxFilesPerDir = counter;
			maxFilesPerDirPath = dir;
		}
			
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		if (attrs.size() > maxFileSize) {
			maxFileSize = attrs.size();
			maxFilePath = file;
		}
		else if (attrs.size() == maxFileSize)
			if(maxFilePath.toString().compareTo(file.toString()) > 1) maxFilePath = file;

		return FileVisitResult.CONTINUE;
	}

	@Override
	public String toString() {
		return "CustomFileVisitor{" +
				"maxFilePath=" + maxFilePath +
				", maxFileSize=" + maxFileSize +
				", maxFilesPerDir=" + maxFilesPerDir +
				", maxFilesPerDirPath=" + maxFilesPerDirPath +
				'}';
	}
}
