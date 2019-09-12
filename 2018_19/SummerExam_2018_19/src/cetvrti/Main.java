package cetvrti;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.OptionalDouble;

public class Main {
	public static void main(String[] args) {
		final String directory = "D:/_OOP";
		final String extension = "*"; // ili "pdf" ili "ppt" ili "java" ...
		Path root = Paths.get(directory);
		MetadataFileVisitor visitor = new MetadataFileVisitor(extension);
		try {
			Files.walkFileTree(root, visitor);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TO DO: napisati kod za ispis srednje vrijednosti veličina pronađenih datoteka
		// morate koristiti kolekcijske tokove

		try {
			OptionalDouble avg = visitor.getMetaData().stream().map(s -> s.split(",")).filter(s -> !s[2].equals("0"))
					.mapToDouble(s -> Integer.parseInt(s[2])).average();
			System.out.format("\nAverage file size %.2f", avg.getAsDouble());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
