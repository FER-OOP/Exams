package zi.zad01;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import zi.ScientificPaper;

public class Main {

	public static void main(String[] args) throws IOException {
		if(args.length != 1) {
			System.out.println("Očekivao sam stazu.");
			return;
		}

		// staza na temelju jedinog predinog argumenta:
		Path dir = Paths.get(args[0]);

		if(!Files.isDirectory(dir)) {
			System.out.println("Argument nije direktorij.");
			return;
		}
		
		PapersLoader loader = new PapersLoader();
		Files.walkFileTree(dir, loader);
		
		List<ScientificPaper> papers = loader.getPapers();
		System.out.println("Broj znanstvenih radova: " + papers.size());
	}
}

class PapersLoader implements FileVisitor<Path> {
	private List<ScientificPaper> papers = new ArrayList<>();
	
	public List<ScientificPaper> getPapers() {
		return papers;
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		if(Files.exists(dir.resolve("IGNORE.ME"))) return FileVisitResult.SKIP_SUBTREE;
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if(file.getFileName().toString().endsWith(".xml")) {
			ScientificPaper paper = LoaderUtil.load(file);
			papers.add(paper);
		}
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}
}
