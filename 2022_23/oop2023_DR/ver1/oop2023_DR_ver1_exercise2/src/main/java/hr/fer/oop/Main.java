package hr.fer.oop;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 2);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1); 

        Member member1 = new Member("Pero Peric");
        Member member2 = new Member("Ivo Ivic");

        library.addBook(book1);
        library.addBook(book2);
        library.addMember(member1);
        library.addMember(member2);

        try {
            member1.borrowBook(book1);
            member1.borrowBook(book2);
            member2.borrowBook(book2);
        } catch (BorrowingException e) {
            System.out.println("Error: " + e.getMessage());
        }
        

        System.out.println("Available books:");
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Copies available: " + book.getCopiesAvailable());
        }

        // Pretraživanje knjiga
        String searchQuery = "great";
        System.out.println("Search results for query '" + searchQuery + "':");
        for (Book book : library.getAvailableBooks()) {
            if (book.search(searchQuery)) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
        }

        member1.returnBook(book2);
        

        System.out.println("Available books after returning a book:");
        availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Copies available: " + book.getCopiesAvailable());
        }
    }
    
}