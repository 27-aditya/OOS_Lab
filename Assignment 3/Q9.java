public class Q9 {
    public static void main(String[] args) {
        SavingsAccount mySavings = new SavingsAccount("12334", 5.0);
        mySavings.deposit(1000);
        mySavings.addInterest();
        System.out.println("Balance after adding interest: ");
        mySavings.getBalance();
    }
}

class Account{
    private String accountNumber;
    protected double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public double getBalance(){
        return balance;
    }
}

class SavingsAccount extends Account{
    protected double interestRate;

    public SavingsAccount(String string, double interestRate){
        super(string);
        this.interestRate = interestRate;
    }

    public void addInterest(){
        balance += balance*interestRate/100;
    }
}