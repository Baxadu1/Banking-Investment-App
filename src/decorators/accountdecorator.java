package decorators;

import classes.account;

public abstract class accountdecorator implements account {
    protected account Account;
    public accountdecorator(account Account) {
        this.Account = Account;
    }
    @Override
    public double getBalance() {
        return Account.getBalance();
    }

    public void open() {
        Account.open();
    }
    public void close() {
        Account.close();
    }

    public void deposit(double amount) {
        Account.deposit(amount);
    }

    public void withdraw(double amount) {
        Account.withdraw(amount);
    }
}
