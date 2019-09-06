package treci;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		final String directory = "D:\\OOP\\";
		Path root = Paths.get(directory);
		DuplicateFileVisitor visitor = new DuplicateFileVisitor(); 
	try {
	        Files.walkFileTree(root, visitor);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	// TO DO: napisati kod za ispis ukupnog iznosa oslobo�ene memorije 
// i broja obrisanih datoteka
	    // morate koristiti kolekcijske tokove

		Long total = visitor.getDeletedData().entrySet().stream()
			.map(s ->s.getValue())
			.mapToLong(Long::longValue)
			.sum();
		System.out.format("\nFreed disk space %d Deleted files %d", total, visitor.getDeletedData().size());
	}


}
