package DefiningClasses.Lab._3_BankAccount;

public class BankAccount {
    private static int nextId = 1;
    private static double interestRate = 0.02;

    private double balance;
    private final int id;

    public BankAccount() {
        this.id = nextId;
        nextId++;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
