public class User {
    private String username;
    private String passwordHash;
    private double balance;

    public User(String username, String passwordHash, double balance) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}
