package decorators;

import classes.account;

public abstract class accountdecorator implements account {
    protected account decoratedaccount;

    public accountdecorator(account decoratedaccount){
        this.decoratedaccount = decoratedaccount;
    }

    public void deposit(double amount){
        decoratedaccount.deposit(amount);
    }
    public void withdraw(double amount){
        decoratedaccount.withdraw(amount);
    }
    public double getBalance(){
        return decoratedaccount.getBalance();
    }

    public void printAccountDetails() {
        decoratedaccount.printAccountDetails();
    }
}
