package decorators;

import classes.account;

public class taxoptimizationdecorator extends accountdecorator {
    public taxoptimizationdecorator(account Account) {
        super(Account);
    }

    public void open(){
        super.open();
        System.out.println("tax optimized");
    }
}
