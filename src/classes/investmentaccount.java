package classes;

public class investmentaccount implements account{
    private double balance;

    public void open() {
        System.out.println("you opened your investment account");
        balance = 0;
    }

    public void close() {
        System.out.println("investment account is closed");
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("you deposited" + balance + "to your investment account");
    }

    public void withdraw(double amount) {
        if (amount >= balance) {
            System.out.println("not enough balance");
        }
        else {
            balance -= amount;
            System.out.println("you withdrawed" + amount + " to your investment account");
        }
    }

    public double getBalance() {
        return balance;
    }
}
