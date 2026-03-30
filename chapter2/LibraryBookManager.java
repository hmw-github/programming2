package chapter2;

import java.util.Scanner;

class Book {
	private String title = "Hitchhiker's Guide", 
			author = "Douglas Adam";
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String value) {
		title = value;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String toString() {
		return author + " - " + title;
	}
}

/**
 * 
	Requirements:
	The class stores multiple books in an array
	The size of the array is defined when the object is created
	
	Implement the following methods:
	 1. Insert a book
	  Store a book at a specific position in the array.
	 2. Search for a book by title
		Return the first book that matches a given title
		If no book is found, return "null"
	 3. Count books by author
		Count how many books in the array belong to a given author
 */
class Library {
	private Book[] books;
	
	public Library(Book[] books, int maxSize) {
		this.books = new Book[maxSize];
		
		for (int i = 0; i < books.length; ++i) {	
			if (i >= maxSize) {
				break;
			}
			this.books[i] = books[i]; 
		}
	}

	public void insertBook(Book b, int pos) {
		if (pos >= books.length) {
			return;
		}
		books[pos] = b;
	}
	
	public Book searchByTitle(String title) {
		Book result = null;
		
		for (Book b : books) {
			if (b != null && b.getTitle().equals(title)) {
				result = b;
				break;
			}
		}
		
		return result;
	}
	
	public int countBooksByAuthor(String author) {
		int count = 0;
		
		for (Book b : books) {
			if (b != null && b.getAuthor().equals(author)) {
				count++;
			}
		}
		
		return count;		
	}
	
	public Book[] getBooksBySearchTerm(String searchTerm) {
		int hits = 0;
		
		// first search to find out size of array
		for (Book b : books) {
			if (b != null 
					&& (b.getAuthor().contains(searchTerm) 
					|| b.getTitle().contains(searchTerm))) {
				hits++;
			}
		}
		
		if (hits == 0) {
			return new Book[0]; // no hits!
		}
		
		// create array
		Book[] result = new Book[hits];
		
		// second search to fill the array
		// note: unnecessary when we will use lists later!
		int i = 0;
		for (Book b : books) {
			if (b != null 
				&& (b.getAuthor().contains(searchTerm) 
					|| b.getTitle().contains(searchTerm))) {
				result[i++] = b;
			}
		}
		return result;
	}
}

public class LibraryBookManager {

	private static Scanner scanner = new Scanner(System.in);
	
	public static int printMenuAndGetChoice() {
		System.out.println("--- Please choose ---");
		System.out.println("(1) Search book by title");
		System.out.println("(2) Count books from an author");
		System.out.println("(3) List all books by search term");
		System.out.println("(4) Exit");
		System.out.print("Your choice: ");
		int choice = scanner.nextInt();
		scanner.nextLine(); // consume leftover newline
		
		return choice;
	}

	private static String input(String prompt) {
		System.out.print(prompt);
		String line = scanner.nextLine();
		return line;
	}
	
	public static void main(String[] args) {
		Book[] books = {
			    new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams"),
			    new Book("1984", "George Orwell"),
			    new Book("Brave New World", "Aldous Huxley"),
			    new Book("To Kill a Mockingbird", "Harper Lee"),
			    new Book("The Great Gatsby", "F. Scott Fitzgerald"),
			    new Book("Moby Dick", "Herman Melville"),
			    new Book("War and Peace", "Leo Tolstoy"),
			    new Book("The Catcher in the Rye", "J.D. Salinger"),
			};
		
		Library lib = new Library(books, 100);
		lib.insertBook(new Book("The Lord of the Rings", "J.R.R. Tolkien"), 20);
		lib.insertBook(new Book("Pride and Prejudice", "Jane Austen"), 30);
		
		boolean terminated = false;
		while (!terminated) {
			int choice = printMenuAndGetChoice();

			switch (choice) {
			case 1:
				String title = input("Title: ");
				Book b = lib.searchByTitle(title);
				
				if (b == null) {
					System.out.println("Not found!");
				} else {
					System.out.println(b);
				}
				break;
			case 2:
				String author = input("Author: ");
				int count = lib.countBooksByAuthor(author);
				System.out.println("#books by author: " + count);
				break;
			case 3:
				String term = input("Search term: ");
				Book[] booksFound = lib.getBooksBySearchTerm(term);
				if (booksFound.length == 0) {
					System.out.println("No books are matching your search term!");
				} else {
					int index = 1;
					for (Book book : booksFound) {
						System.out.printf("%2d. %s\n", index++, book);
					}
				}
				break;
			default:
				System.out.println("Program terminated.");
				terminated = true;
				break;
			}
		}
	}
	

}
