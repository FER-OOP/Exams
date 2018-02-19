package zad1;

public class EPubBook {
	String authors;
	String name;
	int year;
	String url;

	public EPubBook(String authors, String name, int year, String url) {
		super();
		this.authors = authors;
		this.name = name;
		this.year = year;
		this.url = url;
	}

	public String getAuthors() {
		return authors;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public int hashCode() {
		return authors.hashCode() + name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof EPubBook)) {
			return false;
		}
		EPubBook druga = (EPubBook)obj;
		
		return authors.equals(druga.authors) && name.equals(druga.name);
	}

	@Override
	public String toString() {
		return name;
	}
}