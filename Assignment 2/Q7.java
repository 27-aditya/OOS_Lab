import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

// Account class
class Account {
    // Members
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    // parameterized constructor
    public Account(int accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }

    // number method
    public int getAccountNumber() {
        return accountNumber;
    }

    // account method
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // balance method
    public double getBalance() {
        return balance;
    }

    // deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // account display method
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

// Main menu class
public class Q7 {
    private static Map<Integer, Account> accounts = new HashMap<>();
    private static int nextAccountNumber = 1001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Banking System Menu:");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createNewAccount(scanner);
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the banking system. Goodbye");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createNewAccount(Scanner scanner) {
        System.out.print("Enter account holder's name: ");
        String accountHolderName = scanner.next();
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        int accountNumber = nextAccountNumber++;
        Account newAccount = new Account(accountNumber, accountHolderName, initialDeposit);
        accounts.put(accountNumber, newAccount);
        System.out.println("Account created successfully!");
        newAccount.displayAccountDetails();
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            System.out.println("Updated account details:");
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
            System.out.println("Updated account details:");
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }
}
