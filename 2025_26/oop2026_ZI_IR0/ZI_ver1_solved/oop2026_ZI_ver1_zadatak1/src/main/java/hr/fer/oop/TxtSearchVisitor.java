package hr.fer.oop;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class TxtSearchVisitor extends SimpleFileVisitor<Path>{
	private int totalTxtFiles = 0;
    private long totalSize = 0;
    private final Set<String> directories = new TreeSet<>();
    
    @Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    	String dirName = dir.getFileName().toString();

    	if (!dirName.contains("txt")) {
            return FileVisitResult.SKIP_SUBTREE;
        }

    	return FileVisitResult.CONTINUE;

	}
	
    @Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    	if (file.toString().endsWith(".txt")) {
    		totalTxtFiles++;
    		long size = attrs.size();
    		totalSize += size;
    		
    		Path parent = file.getParent();
            String directoryName = parent.getFileName().toString();
            directories.add(directoryName);

    	}
    	
    	return FileVisitResult.CONTINUE;
	}

	public int getTotalTxtFiles() {
		return totalTxtFiles;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public Collection<String> getDirectories() {
	    return directories;
	}

}
