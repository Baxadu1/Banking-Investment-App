package classes;

public class savingsaccount implements account {
    private double balance;

    public void open() {
        System.out.println("you opened the savings account");
        balance = 0;
    }

    public void close() {
        System.out.println("savings account closed");
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("you deposited" + amount + " to your savings account");
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("you withdrawed" + amount + " to your savings account");
    }

    public double getBalance() {
        return balance;
    }

}
