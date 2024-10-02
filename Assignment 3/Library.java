import java.util.ArrayList;
import java.util.Scanner;

// Q4.java

public class Library {
    private static ArrayList<Book>library = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Enter book");
            System.out.println("2. Display details");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume the newline left by nextInt()

            switch (choice) {
                case 1:
                    System.out.println("Title: ");
                    String title = sc.nextLine();
                    System.out.println("Author: ");
                    String author = sc.nextLine();
                    System.out.println("Price: $");
                    double price = sc.nextDouble();
                    sc.nextLine();  // Consume the newline left by nextDouble()
                    System.out.println("Year published: ");
                    int yearPublished = sc.nextInt();
                    sc.nextLine();  // Consume the newline left by nextInt()
                    library.add(new Book(title, author, price, yearPublished));
                    break;
                case 2:
                    for (Book book : library) {
                        book.displayDetails();
                    }
                    break;
                case 3:
                    return;
            }
        }
    }
}

class Book {
    private String title;
    private String author;
    private double price;
    private int yearPublished;

    public Book(String title, String author, double price, int yearPublished){
        this.title = title;
        this.author = author;
        this.price = price;
        this.yearPublished = yearPublished;
    }

    public void displayDetails(){
        System.out.println("Title: " + title);
        System.out.println("Author: "+ author);
        System.out.println("Price: $" + price);
        System.out.println("Year published: "+ yearPublished);
    }
}
