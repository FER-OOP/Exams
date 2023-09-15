package hr.fer.oop;

import java.util.List;
import java.util.ArrayList;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }


    public List<Book> getBooks() {
		return books;
	}


	public List<Member> getMembers() {
		return members;
	}

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }
    

	public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getCopiesAvailable() > 0) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}
