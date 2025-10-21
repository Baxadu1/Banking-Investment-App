package facades;

import classes.account;
import classes.investmentaccount;
import classes.savingsaccount;
import decorators.insurancedecorator;
import decorators.rewardpointsdecorator;
import decorators.taxoptimizationdecorator;

import java.util.Scanner;
public class bankingfacade {
    private Scanner sc = new Scanner(System.in);

    public account openaccountWithBenefits(String type){
        account Account;
        if(type.equals("savings")){
            Account = new savingsaccount();
            Account = new insurancedecorator(Account);
            Account = new rewardpointsdecorator(Account);
        } else {
            Account = new investmentaccount();
            Account = new taxoptimizationdecorator(Account);
        }
        Account.open();
        return Account;
    }

    public void closeaccount (account Account){
        Account.close();
    }

    public void deposit(account Account){
        System.out.println("Enter amount to deposit");
        double amount = sc.nextDouble();
        Account.deposit(amount);
        System.out.println("current balance is " + Account.getBalance());
    }

    public void withdraw(account Account){
        System.out.println("Enter amount to withdraw");
        double amount = sc.nextDouble();
        Account.withdraw(amount);
        System.out.println("current balance is " + Account.getBalance());
    }

    public void displaybalance(account Account){
        System.out.println("current balance is " + Account.getBalance());
    }
}
