import java.util.ArrayList;

class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void listBooks() {
        for (Book book : books) {
            book.getDetails();
        }
    }
}

class Book {
    private String title;
    private int publicationYear;
    private Author author;

    public Book(String title, int publicationYear, Author author) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public void getDetails() {
        System.out.println("Title: " + title);
        System.out.println("Year: " + publicationYear);
        author.getDetails();
    }
}

class Author {
    private String name;
    private String nationality;

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public void getDetails() {
        System.out.println("Author: " + name);
        System.out.println("Nationality: " + nationality);
    }
}

public class Q4 {
    public static void main(String[] args) {
        Author author1 = new Author("George Orwell", "British");
        
        Book book1 = new Book("1984", 1949, author1);
        
        Library library = new Library("City Library");
        
        library.addBook(book1);
        
        System.out.println("Books in the library:");
        library.listBooks();
        
        library.removeBook(book1);
        
        System.out.println("\nBooks in the library after removal:");
        library.listBooks();
    }
}
