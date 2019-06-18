package zad1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		  Path rootFolder = Paths.get("Downloads");
		  EPubBookScanner sc = new EPubBookScanner(rootFolder);
		  Files.walkFileTree(rootFolder, sc);
		  List<EPubBook> books = sc.getBooks();
		  for(EPubBook book : books) {
		    System.out.printf("%s %s %d %s%n", book.getAuthors(), book.getName(), book.getYear(), book.getUrl());
		  }
		}
}
