package decorators;

import classes.account;

public class insurancedecorator extends accountdecorator{
    private double insuredamount;
    private boolean insurancepurchased = false;

    public insurancedecorator(account decoratedaccount){
        super(decoratedaccount);
        this.insuredamount = 1000;
    }

    public void withdraw(double amount){
        if(insurancepurchased){
            double balance = decoratedaccount.getBalance();
            if(balance < amount){
                System.out.println("not enough balance. will use isurance to withdraw");
                double difference = amount - balance;
                if(insuredamount >= difference){
                    insuredamount -= difference;
                    System.out.println("insurance coverage used for " + difference + ". remaining insurance: " + insuredamount);
                    super.withdraw(balance);
                }
                else{
                    System.out.println("not enough insurance");
                }
            }
            else {
                super.withdraw(amount);
            }
        }
        else{
            System.out.println("insurance is not purchased");
        }

    }

    public void printAccountDetails() {
        super.printAccountDetails();
        System.out.println("Insurance Purchased: " + (insurancepurchased ? "Yes" : "No"));
        if (insurancepurchased) { System.out.println("Insurance Coverage: " + insuredamount);}
        else { System.out.println("you dont have insurance coverage");}
    }


    public void purchaseInsurance() {
        if (!insurancepurchased) {
            if (decoratedaccount.getBalance() >= 700) {
                decoratedaccount.withdraw(700);
                this.insuredamount = 1000.0;
                this.insurancepurchased = true;
                System.out.println("Insurance purchased for $700 to cover $1000.");
            } else {
                System.out.println("Not enough funds to purchase insurance.");
            }
        } else {
            System.out.println("Insurance already purchased. Current coverage: " + insuredamount);
        }
    }



}
