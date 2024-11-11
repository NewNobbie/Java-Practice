package Exercise.ToUpgrade.LoanBooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> books;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Method to lend a book
    public void lendBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book lent: " + title);
                } else {
                    System.out.println("Book is currently unavailable.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Method to return a book
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned: " + title);
                } else {
                    System.out.println("Book is already available in the library.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Method to display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Library has no books.");
        } else {
            System.out.println("Books in the Library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }


    public static void main(Object o) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System\n" +
                    "1. Add a book\n" +
                    "2. Lend a book\n" +
                    "3. Return a book\n" +
                    "4. Show all books\n" +
                    "5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();

                    Book book = new Book(title, author);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter the title of the book to lend: ");
                    String lendTitle = scanner.nextLine();
                    library.lendBook(lendTitle);
                    break;

                case 3:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;

                case 4:
                    library.displayBooks();
                    break;

                case 5:
                    System.out.println("Exiting the library system...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
