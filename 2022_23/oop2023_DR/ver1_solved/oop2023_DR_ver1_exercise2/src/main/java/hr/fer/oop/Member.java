package hr.fer.oop;

import java.util.List;
import java.util.ArrayList;

public class Member {
	
    private String name;
    private List<Book> borrowedBooks;

    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
		return name;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}


	public void borrowBook(Book book) throws BorrowingException {
        if (book.getCopiesAvailable() <= 0 || borrowedBooks.contains(book)) {
            throw new BorrowingException("Cannot borrow the book: " + book.getTitle());
        }
        borrowedBooks.add(book);
        book.copiesAvailable --;
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.copiesAvailable++;
    }
}