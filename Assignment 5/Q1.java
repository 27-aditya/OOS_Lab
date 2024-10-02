import java.util.Scanner;

public class Q1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalBalance = scanner.nextDouble();
        double rupee = scanner.nextDouble();  // Price of the product from Shop A
        double dollar = scanner.nextDouble();  // Price of the product from Shop B
        double pound = scanner.nextDouble();  // Price of the product from Shop C

        Bank bank = new Bank();
        double remainingBalance = bank.calculateRemainingBalance(totalBalance, rupee, dollar, pound);

        if (remainingBalance != totalBalance) {
            System.out.println((int)remainingBalance);  
        }
    }
}
interface CurrencyConverter{
    double convertRupees(double amount);
    double convertDollars(double amount);
    double convertPounds(double amount);
}

class Bank implements CurrencyConverter{
    private static final double DOLLAR_TO_RUPEE = 70;
    private static final double POUND_TO_RUPEE = 100;

    public double convertRupees(double amount){
        return amount;
    }

    public double convertDollars(double amount){
        return amount * DOLLAR_TO_RUPEE;
    }

    public double convertPounds(double amount){
        return amount * POUND_TO_RUPEE;
    }

    public double calculateRemainingBalance(double initialBalance, double rupees, double dollars, double pounds){
        double totalAmount = convertDollars(dollars)+convertPounds(pounds)+convertRupees(rupees);

        if(initialBalance >= totalAmount){
            return initialBalance-totalAmount;
        }
        else{
            System.out.println("Insufficient Balance");
            return initialBalance;
        }
    }
}


