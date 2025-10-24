package decorators;

import classes.account;

public class rewardpointdecorator extends accountdecorator {
    private int rewardpoints;

    public rewardpointdecorator(account decoratedaccount){
        super(decoratedaccount);
        this.rewardpoints = 0;
    }

    public void deposit(double amount){
        super.deposit(amount);
        rewardpoints += (int)(amount * 0.01);
        System.out.println("added " + (int)(amount * 0.01) + " rewardpoints." +" total is: " + rewardpoints);
    }

    public void printAccountDetails() {
        super.printAccountDetails();
        System.out.println("reward Points: " + rewardpoints);
    }

    public int getRewardpoints(){
        return rewardpoints;
    }
}
