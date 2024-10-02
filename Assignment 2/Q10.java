import java.util.ArrayList;
import java.util.Scanner;

// Book Class
class Book {
    int id;
    String title;
    String author;

    // Constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return id + ", " + title + ", " + author;
    }
}

// Library Class
class Library {
    private ArrayList<Book> books; // List to store books

    // Constructor 
    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a new book
    public void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
    }

    // Method to remove a book
    public void removeBook(int id) {
        Book bookToRemove = null;
        // Search for the book with the given ID
        for (Book book : books) {
            if (book.id == id) {
                bookToRemove = book;
                break;
            }
        }
        // If book is found, remove it
        if (bookToRemove != null) {
            books.remove(bookToRemove);
        } 
    }

    // Method to list all books
    public void listAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Method to find and display a book by its title
    public void findBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) { // Ignore case to get no difference between upper and lower case
                System.out.println(book);
            }
        }
    }
}

// Main class
public class Q10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(); 

        while (true) {
            System.out.println("\nSelect the operation:");

            // User's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // Add a new book
                    System.out.println("Enter book id, title, author");
                    String[] bookDetails = scanner.nextLine().split(", ");
                    int id = Integer.parseInt(bookDetails[0]);
                    String title = bookDetails[1];
                    String author = bookDetails[2];
                    library.addBook(id, title, author);
                    break;
                case 2:
                    // Remove book by ID
                    int removeId = scanner.nextInt();
                    library.removeBook(removeId);
                    break;
                case 3:
                    // List all books
                    library.listAllBooks();
                    break;
                case 4:
                    // Find a book by title
                    String searchTitle = scanner.nextLine();
                    library.findBook(searchTitle);
                    break;
                case 5:
                    // Exit the program
                    scanner.close();
                    return;
            }
        }
    }
}
