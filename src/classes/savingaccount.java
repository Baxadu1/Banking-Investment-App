package classes;

public class savingaccount implements account {
    private double balance;

    public savingaccount(){
        balance = 0;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        }
        else{
            System.out.println("Insufficient funds");
        }
    }

    public double getBalance(){
        return balance;
    }

    public void printAccountDetails() {
        System.out.println("savings Account Balance: " + balance);
    }
}
