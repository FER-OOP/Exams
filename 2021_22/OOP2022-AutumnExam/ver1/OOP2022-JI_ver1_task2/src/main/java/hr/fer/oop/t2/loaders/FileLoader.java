package hr.fer.oop.t2.loaders;

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
		
		//if the path does not exist throw NoDataException with the message filename does not exist (e.g. data2.txt does not exist)
		
		//if the path exists try to read the file. If an exception happens throw NoDataException with the original exception inside as the exception cause.
		
		//TO DO: Replace the line below with the loaded list of string (or something else that is Iterable<String>
		return List.of();
	}

}
