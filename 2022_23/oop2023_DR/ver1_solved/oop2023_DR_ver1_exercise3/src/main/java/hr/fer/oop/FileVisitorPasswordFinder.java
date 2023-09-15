package hr.fer.oop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class FileVisitorPasswordFinder implements FileVisitor<Path> {
	Map<String, StringBuilder> folderLinesContainingPassword = new HashMap<>();

	final private String resultDirectoryPath;

	public FileVisitorPasswordFinder(String resultDirectoryPath) {
		this.resultDirectoryPath = resultDirectoryPath;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

		// search only .txt files
		if (file.toString().endsWith(".txt")) {

			String line;
			FileReader a = new FileReader(file.toString());
			BufferedReader br = new BufferedReader(a);

			// Gets each line till end of file is reached
			while ((line = br.readLine()) != null) {

				if (line.contains("password")) {
					// "password found!"
					// stout printing
					System.out.println(file.toString() + " = " + Files.size(file));
					// copying to dest folder
					Path toFile = Path.of(resultDirectoryPath, file.getFileName().toString());
					Path parent = toFile.getParent();
					if (parent != null) {
						if (Files.notExists(parent)) {
							Files.createDirectories(parent);
						}
					}

					// processing to gather all lines containing password in a specific folder
					if (folderLinesContainingPassword.containsKey(file.getParent().toString())) {
						folderLinesContainingPassword.put(file.getParent().toString(),
								folderLinesContainingPassword.get(file.getParent().toString()).append(line)
										.append(System.getProperty("line.separator")));
					} else {
						StringBuilder sb = new StringBuilder();
						sb.append(line);
						sb.append(System.getProperty("line.separator"));
						folderLinesContainingPassword.put(file.getParent().toString(), sb);
					}

					Files.copy(file, Path.of(resultDirectoryPath, file.getFileName().toString()),
							StandardCopyOption.REPLACE_EXISTING);
				}
			}
			br.close();
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

		//String separator = System.getProperty("file.separator");
		String separator = Pattern.quote(System.getProperty("file.separator"));
		String[] parts = dir.toString().split(separator + "+");
		String filename = parts[parts.length - 1];

		Path toFile = Path.of(resultDirectoryPath, filename + ".txt");
		Path parent = toFile.getParent();
		if (parent != null) {
			if (Files.notExists(parent)) {
				Files.createDirectories(parent);
			}
		}

		if (folderLinesContainingPassword.containsKey(dir.toString())) {
			Files.writeString(toFile, folderLinesContainingPassword.get(dir.toString()).toString());
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		return null;
	}

	public String getResultDirectoryPath() {
		return this.resultDirectoryPath;
	}

}