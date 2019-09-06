package treci;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class DuplicateFileVisitor extends SimpleFileVisitor<Path> {

	private Map<String, Long> data = new HashMap<String, Long>();
	private Map<String, String> repo = new HashMap<String, String>();

	public Map<String, Long> getDeletedData() {
		return data;
	} // dohva�anje pobrisanih

	public Map<String, String> getDataRepo() {
		return repo;
	} // dohva�anje popisa unikata

	// TODO: nadja�avanjem definirajte potrebne metode FileVisitora
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
		String digest = Digest.MD5(file);
		if (repo.containsKey(digest)) {
			Path repoFile = Paths.get(repo.get(digest));
			if (file.getNameCount() >= repoFile.getNameCount()) {
				deleteFile(file, attr.size());
			} else {
				deleteFile(repoFile, attr.size());
				repo.put(digest, file.toString());
			}
		}
		else repo.put(digest, file.toString());

		return FileVisitResult.CONTINUE;
	}

	private void deleteFile(Path file, long size) {
		// TO DO napisati ostatak metode u kojem se spremaju podatci o brisanju

		data.put(file.normalize().toString(), size);

		//TO DO: obrisati datoteku
		try {
			Files.delete(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}