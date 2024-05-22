//library system

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Available: " + isAvailable;
    }
}


class Library {
    private List<Book> books;
    private Scanner scanner;

    public Library() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();

        books.add(new Book(title, author, ISBN));
        System.out.println("Book added successfully!");
    }

    public void borrowBook() {
        System.out.print("Enter ISBN of the book to borrow: ");
        String ISBN = scanner.nextLine();

        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("You have successfully borrowed the book: " + book.getTitle());
                } else {
                    System.out.println("The book is currently not available.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook() {
        System.out.print("Enter ISBN of the book to return: ");
        String ISBN = scanner.nextLine();

        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("You have successfully returned the book: " + book.getTitle());
                } else {
                    System.out.println("The book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchByTitle() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchByAuthor() {
        System.out.print("Enter author to search: ");
        String author = scanner.nextLine();

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayAvailableBooks() {
        boolean found = false;
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books are currently available.");
        }
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

public class LibrarySys {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add a new book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Search for a book by title");
            System.out.println("5. Search for a book by author");
            System.out.println("6. Display available books");
            System.out.println("7. Display all books");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.borrowBook();
                    break;
                case 3:
                    library.returnBook();
                    break;
                case 4:
                    library.searchByTitle();
                    break;
                case 5:
                    library.searchByAuthor();
                    break;
                case 6:
                    library.displayAvailableBooks();
                    break;
                case 7:
                    library.displayAllBooks();
                    break;
                case 8:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
