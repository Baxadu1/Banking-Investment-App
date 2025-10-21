package decorators;

import classes.account;

public class rewardpointsdecorator extends accountdecorator {
    public rewardpointsdecorator(account Account) {
        super(Account);
    }

    @Override
    public void open(){
        super.open();
        System.out.println("reward points optimized");
    }

}
