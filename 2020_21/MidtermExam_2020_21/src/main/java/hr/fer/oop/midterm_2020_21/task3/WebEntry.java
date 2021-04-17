package hr.fer.oop.midterm_2020_21.task3;

public class WebEntry<T> {

	private final String author;
	private final String date;
	private final T entry;

	public WebEntry(String author, String date, T entry) {		
		this.author = author;
		this.date = date;
		this.entry = entry;
	}

	public String getAuthor() {
		return author;
	}

	public String getDate() {
		return date;
	}

	public T getEntry() {
		return entry;
	}

}
