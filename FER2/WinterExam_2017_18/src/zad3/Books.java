package zad3;

import java.util.ArrayList;
import java.util.List;

public class Books {

	public static List<EPubBook> readFromDefaultLocation() {
		List<EPubBook> books = new ArrayList<>();
		books.add(new EPubBook("Mark Twain", "The Adventures of Tom Sawyer", 1876, "http://www.gutenberg.org/ebooks/74.epub.images"));
		books.add(new EPubBook("Charles Dickens", "A Tale of Two Cities by Charles Dickens", 1994, "http://www.gutenberg.org/ebooks/98.epub.images"));
		books.add(new EPubBook("Arthur Conan Doyle", "The Adventures of Sherlock Holmes by Arthur Conan Doyle", 1999, "http://www.gutenberg.org/ebooks/1661.epub.images"));
		books.add(new EPubBook("Bram Stoker", "Dracula", 1991, "http://www.gutenberg.org/ebooks/345.epub.images"));
		books.add(new EPubBook("Herman Melville", "Moby Dick; Or, The Whale", 2001, "http://www.gutenberg.org/ebooks/2701.epub.images"));
		books.add(new EPubBook("Oscar Wilde", "The Picture of Dorian Gray", 1994, "http://www.gutenberg.org/ebooks/174.epub.images"));
		books.add(new EPubBook("graf Leo Tolstoy", "War and Peace", 2001, "http://www.gutenberg.org/ebooks/2600.epub.images"));
		return books;
	}
}
