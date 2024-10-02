import java.util.Scanner;

// Main class 
public class Q2 {
    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Flipkart flipkart = new Flipkart();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] transactionDetails = scanner.nextLine().split(" ");
            String bankName = transactionDetails[0];
            double customerBalance = Double.parseDouble(transactionDetails[1]);
            double productPrice = Double.parseDouble(transactionDetails[2]);

            if (bankName.equalsIgnoreCase("HDFC")) {
                flipkart.hTransaction(customerBalance, productPrice);
            } else if (bankName.equalsIgnoreCase("ICICI")) {
                flipkart.iTransaction(customerBalance, productPrice);
            } else {
                System.out.println("Invalid bank name");
            }
        }
        scanner.close();
    }
}

// Interface for HDFC
interface HDFC {
    void hTransaction(double customerBalance, double productPrice);
}

// Interface for ICICI
interface ICICI {
    void iTransaction(double customerBalance, double productPrice);
}

// Flipkart implementing both HDFC and ICICI
class Flipkart implements HDFC, ICICI {
    private double flipkartAccountBalance = 0.0;  

    public void hTransaction(double customerBalance, double productPrice) {
        if (customerBalance >= productPrice) {
            flipkartAccountBalance += productPrice;  
            customerBalance -= productPrice;  
            System.out.println((int) flipkartAccountBalance + " " + (int) customerBalance); // Type cast to int 
        } else {
            System.out.println("Insufficient funds for HDFC customer");
        }
    }

    public void iTransaction(double customerBalance, double productPrice) {
        if (customerBalance >= productPrice) {
            flipkartAccountBalance += productPrice;  
            customerBalance -= productPrice;  
            System.out.println((int) flipkartAccountBalance + " " + (int) customerBalance); // Type cast to int
        } else {
            System.out.println("Insufficient funds for ICICI customer");
        }
    }
}
