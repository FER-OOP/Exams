package hr.fer.oop.jir2024.zad1;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileRemoveSimulator implements FileVisitor<Path>{

	private List<String> extList;
	private List<String> skipList;
	
	private List<String> filesMarkedForRemoval;
	private List<String> excludedFiles;
	
	public FileRemoveSimulator(List<String> extList, List<String> skipList) {
		this.extList = extList;
		this.skipList = skipList;
		filesMarkedForRemoval = new ArrayList<String>();
		excludedFiles = new ArrayList<String>();
	}
	
	public List<String> getFilesMarkedForRemoval() {
		return filesMarkedForRemoval;
	}
	public List<String> getExcludedFiles() {
		return excludedFiles;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println(file.toString());
		String filename = file.getFileName().toString();
		for (String excludedFN: skipList)
			if (filename.equals(excludedFN)) {
				excludedFiles.add(filename);
				return FileVisitResult.CONTINUE;
			}
		for (String ext : extList)
			if (filename.endsWith(ext)) {
				filesMarkedForRemoval.add(filename);
				return FileVisitResult.CONTINUE;
			}		
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}
	
}
