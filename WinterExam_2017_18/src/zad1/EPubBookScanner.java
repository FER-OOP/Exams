package zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EPubBookScanner extends SimpleFileVisitor<Path> {
	
	private Path file;
	private List<EPubBook> allBooks = new ArrayList<>();
	
	//Constructor
	public EPubBookScanner(Path rootFolder) {
		this.file = rootFolder;
	}

	//Returns list of books
	public List<EPubBook> getBooks() {
		return allBooks;
	}

	/*
	 * IF the file starts with ebook and ends with txt, parse line author, name, year, and url
	 * create OBJECT EPubBook with aforementioned attributes and store it in the EPubBook list.
	 * 
	 * ASSUMPTION is that all files have standardized content
	 *  */
	@Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		String fileName = file.getFileName().toString();
        if (fileName.endsWith(".txt") && fileName.startsWith("ebook-")) {
        	Map<String,String> data = new HashMap<>(); 
        	for(String line : Files.readAllLines(file)) {
        		int p = line.indexOf('=');
        		if(p==-1) continue;
        		String name = line.substring(0, p).trim();
        		String value = line.substring(p+1).trim();
        		data.put(name, value);
        	}
        	EPubBook book = new EPubBook(data.get("author"), data.get("name"), Integer.parseInt(data.get("year")), data.get("url"));
        	allBooks.add(book);
        }
        return FileVisitResult.CONTINUE;
    }
}
