package zi;

import java.nio.file.Path;
import java.util.Set;

public class ScientificPaper {
	private String title;
	private Set<Author> authors;
	private Set<String> keywords;
	private String text;
	private String journal;
	private int year;
	private Path path;
	
	public ScientificPaper(String title, Set<Author> authors, Set<String> keywords, String text, String journal,
			int year, Path path) {
		super();
		this.title = title;
		this.authors = authors;
		this.keywords = keywords;
		this.text = text;
		this.journal = journal;
		this.year = year;
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public Set<String> getKeywords() {
		return keywords;
	}

	public String getText() {
		return text;
	}

	public String getJournal() {
		return journal;
	}

	public int getYear() {
		return year;
	}

	public Path getPath() {
		return path;
	}
	
	// plus getteri, equals, hashcode...
	
	
}

