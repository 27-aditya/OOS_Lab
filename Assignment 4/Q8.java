
import java.util.ArrayList;

public class Q8 {
    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);

        library.displayBook();

        library.removeBook(book1);

        library.displayBook();
    }
}

class Book{
    String title;
    String author;
    int year;

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void displayBook(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
    }
}

class Library{
    ArrayList<Book>library;

    public Library(){
        library = new ArrayList<>();
    }

    public void addBook(Book book){
        library.add(book);
    }

    public void removeBook(Book book){
        library.remove(book);
    }

    public void displayBook(){
        for(Book book : library){
            book.displayBook();
        }
    }
}
