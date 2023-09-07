package hr.fer.oop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class FileVisitorWordCounterAndSorter implements FileVisitor<Path> {
	Map<String,Integer> searchedWordCounterMap = new HashMap<>();
	Map<Long,String> sortedFilesOnCreationTime = new TreeMap<>(Collections.reverseOrder());
    private String searchedWord;

    public FileVisitorWordCounterAndSorter(String searchedWord) {
        this.searchedWord = searchedWord;
    }

	@Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        
    	if(file.toString().endsWith(".txt")) {
    		
    		BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
    	    long fileSize = attr.size();
    	    sortedFilesOnCreationTime.put(fileSize, file.toString());
    		
    		int counter = 0;
	    	String line;
	    	FileReader a = new FileReader(file.toString());  
	        BufferedReader br = new BufferedReader(a);  
	  
	        //Gets each line till end of file is reached  
	        while((line = br.readLine()) != null) {
	            //Splits each line into words  
	            String words[] = line.split("\\s+"); 
	            for (int i=0;i<words.length;i++) {
	            	//Counts searched word
	            	if(words[i].equals(searchedWord))
	            		counter = counter + 1; 
	            }
	  
	        }
	        if(searchedWordCounterMap.containsKey(file.getParent().toString()))
	        	searchedWordCounterMap.put(file.getParent().toString(), counter+searchedWordCounterMap.get(file.getParent().toString()));
	        else
	        	searchedWordCounterMap.put(file.getParent().toString(), counter); 
	        
	        br.close();  
        }
    	return FileVisitResult.CONTINUE;
        }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
    	if(searchedWordCounterMap.containsKey(dir.toString())) {
    		System.out.println(dir.toString() + " = " +searchedWordCounterMap.get(dir.toString()));
    		searchedWordCounterMap.remove(dir.toString());
    	}
    	return FileVisitResult.CONTINUE;
    }

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		return null;
	}
	
	public void copyToSortedFilesFolder(String sortedFilesFolderPath) throws IOException {
		int i =1;
        for(Entry<Long, String> e : sortedFilesOnCreationTime.entrySet()) {
        	Path copied = Paths.get(sortedFilesFolderPath + i++ + ".txt");
        	Path originalPath = Paths.get(e.getValue());
        	try {
        		Files.copy(originalPath, copied);
        	} catch (NoSuchFileException ex) {
        		Files.createDirectories(Paths.get(sortedFilesFolderPath));
        		Files.copy(originalPath, copied);
        	}
        }
        sortedFilesOnCreationTime.clear();
	}

	public String getSearchedWord() {
		return searchedWord;
	}

	public void setSearchedWord(String searchedWord) {
		this.searchedWord = searchedWord;
	}

}