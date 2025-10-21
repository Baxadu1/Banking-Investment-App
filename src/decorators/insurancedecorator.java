package decorators;

import classes.account;

public class insurancedecorator extends accountdecorator{
    public insurancedecorator(account Account){
        super(Account);
    }

    public void open(){
        super.open();
        System.out.println("insurance benefits added to your account");
    }
}
