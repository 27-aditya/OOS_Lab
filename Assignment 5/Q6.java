import java.util.*;

public class Q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> bookList = new ArrayList<>(); 

        while (true) {
            System.out.println("1. Add Reference Book");
            System.out.println("2. Add Text Book");
            System.out.println("3. Check-Out");
            System.out.println("4. Check-In");
            System.out.println("5. List Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    System.out.println("Enter ID, Title and Author (Line by line)");
                    String refID = scanner.nextLine();
                    String refTitle = scanner.nextLine();
                    String refAuthor = scanner.nextLine();
                    bookList.add(new ReferenceBook(refID, refTitle, refAuthor));
                    break;
                
                case 2:
                    System.out.println("Enter ID, Title and Author (Line by line)");
                    String textID = scanner.nextLine();
                    String textTitle = scanner.nextLine();
                    String textAuthor = scanner.nextLine();
                    bookList.add(new TextBook(textID, textTitle, textAuthor));
                    break;
                
                case 3:
                    System.out.print("Enter Book ID: ");
                    String checkoutID = scanner.nextLine();
                    boolean foundCheckout = false;
                    for (Book book : bookList) {
                        if (book.getBookID().equals(checkoutID)) {
                            foundCheckout = true;
                            if (book instanceof TextBook) {
                                System.out.print("Enter Username: ");
                                String user = scanner.nextLine();
                                ((TextBook) book).checkIn(user);
                            } else if (book instanceof ReferenceBook) {
                                book.checkOut();
                            }
                        }
                    }
                    if (!foundCheckout) {
                        System.out.println("Book not found.");
                    }
                    break;
                
                case 4:
                    System.out.print("Enter Book ID: ");
                    String checkinID = scanner.nextLine();
                    boolean foundCheckin = false;
                    for (Book book : bookList) {
                        if (book.getBookID().equals(checkinID)) {
                            foundCheckin = true;
                            if (book instanceof TextBook) {
                                ((TextBook) book).checkOut();
                            } else if (book instanceof ReferenceBook) {
                                book.checkIn(""); // ReferenceBook's checkIn should not do anything
                            }
                        }
                    }
                    if (!foundCheckin) {
                        System.out.println("Book not found.");
                    }
                    break;
                
                case 5:
                    for (Book book : bookList) {
                        book.displayDetails();
                    }
                    break;
                
                case 6:
                    scanner.close();
                    return;
            }
        }
    }
}

interface Borrowable {
    void checkIn(String user);   
    void checkOut();             
}

abstract class Book {
    private String bookID;   
    protected String title;   
    protected String author;   

    public Book(String bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
    }

    protected abstract void checkOut();

    protected abstract void checkIn(String string);

    public String getBookID() {
        return bookID;
    }

    public abstract void displayDetails();
}

class TextBook extends Book implements Borrowable {
    private String status;       
    private String user; 

    public TextBook(String bookID, String title, String author) {
        super(bookID, title, author);
        this.status = "Available"; 
        this.user = "";
    }

    public void checkIn(String user) {
        if (status.equals("Available")) {
            status = "Borrowed by " + user;
            this.user = user;
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    public void checkOut() {
        if (!status.equals("Available")) {
            status = "Available";
            this.user = "";
        } else {
            System.out.println("Book is already available.");
        }
    }

    public void displayDetails() {
        System.out.println("TextBook: " + getBookID() + ": " + title + ": " + author + ": " + status);
    }
}

class ReferenceBook extends Book implements Borrowable {

    public ReferenceBook(String bookID, String title, String author) {
        super(bookID, title, author);
    }

    public void checkIn(String user) {
        System.out.println("Invalid");
    }

    public void checkOut() {
        System.out.println("Cannot be borrowed");
    }

    public void displayDetails() {
        System.out.println("ReferenceBook: " + getBookID() + ": " + title + ": " + author);
    }
}
