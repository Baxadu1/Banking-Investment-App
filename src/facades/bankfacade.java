package facades;

import classes.account;
import classes.investmentaccount;
import classes.savingaccount;
import decorators.insurancedecorator;
import decorators.rewardpointdecorator;
import decorators.taxoptimizerdecorator;

public class bankfacade {
    public account openSavingsAccount() {
        account newAccount = new savingaccount();
        newAccount = new rewardpointdecorator(newAccount);
        return newAccount;
    }

    public account openInvestmentAccount() {
        account newAccount = new investmentaccount();
        newAccount = new taxoptimizerdecorator(newAccount);
        return newAccount;
    }

    public void closeAccount(account acc) {
        System.out.println("Closing account with balance: " + acc.getBalance());
    }

    public void purchaseInsurance(account acc) {
        if (acc instanceof investmentaccount) {

            if (!(acc instanceof insurancedecorator)) {
                acc = new insurancedecorator(acc);
            }
            insurancedecorator insuranceDecorator = (insurancedecorator) acc;
            insuranceDecorator.purchaseInsurance();
        } else {
            System.out.println("Insurance is only available for Investment Accounts.");
        }
    }
}
