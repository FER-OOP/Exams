package hr.fer.oop.ZI2023;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

	private String[] extensions;
	private int numFiles;
	private int numFolders;
	private long largestFileSize;

	public MyFileVisitor(String[] extensions) {
		super();
		this.extensions = extensions;
	}
	
	public int getNumFiles() {
		return numFiles;
	}

	public int getNumFolders() {
		return numFolders;
	}

	public long getLargestFileSize() {
		return largestFileSize;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		for (String ext : extensions) {
			if (file.toString().endsWith(ext)) {
				long size = attrs.size();
				numFiles += 1;
				if (size > largestFileSize) largestFileSize = size;
				break;
			}
		}
			
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		numFolders += 1;
		return FileVisitResult.CONTINUE;
	}
}
