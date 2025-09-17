package hr.fer.oop.songs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DemoMain {

	public static void main(String[] args) throws IOException {
		Path path = Path.of("src", "main", "resources", "fileset0");
		SongsVisitor visitor = new SongsVisitor();
		Files.walkFileTree(path, visitor);
		System.out.println("Files count: " + visitor.getFilesCount());
		System.out.println("First lines: ");
		visitor.getFirstLines().forEach(System.out::println);
	}

}
