package decorators;

import classes.account;

public class taxoptimizerdecorator extends accountdecorator{
    private double taxrate = 0.20;

    public taxoptimizerdecorator(account decoratedaccount){
        super(decoratedaccount);
    }

    public void deposit (double amount){
        super.deposit(amount);
    }

    public void withdraw (double amount){
        double amountaftertax = amount - (amount * taxrate);
        System.out.println("amout after tax withdrawal: " + amountaftertax);
        super.withdraw(amountaftertax);
    }


    public void printAccountDetails() {
        super.printAccountDetails();
        System.out.println("tax Rate: " + (taxrate * 100) + "%");
    }

}
