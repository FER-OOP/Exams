package hr.fer.oop.t2.loaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileLoader implements DataLoader {

	private String filename;
	public FileLoader(String filename) {
		this.filename = filename;	
	}
	@Override
	public Iterable<String> Load() throws NoDataException {
		Path path = Path.of("src", "main", "resources", filename);
		if (!Files.exists(path)) {
			throw new NoDataException(filename + " does not exist");
		}
		
		try {
			List<String> data = Files.readAllLines(path);
			return data;
		} catch (IOException e) {
			throw new NoDataException(e);
		}
	}

}
