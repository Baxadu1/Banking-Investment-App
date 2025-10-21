package classes;

public interface account {
    void open();
    void close();
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}
