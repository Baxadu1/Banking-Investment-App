
import classes.account;
import facades.bankingfacade;

import java.util.Scanner;

public class terminalmanipulation {
    private Scanner scanner = new Scanner(System.in);
    private bankingfacade facade = new bankingfacade();
    private account Account = null;

    public void run() {
        while (true) {
            System.out.println("\nselect an option:");
            System.out.println("1. open savings account with benefits");
            System.out.println("2. open investment account with benefits");
            System.out.println("3. deposit money");
            System.out.println("4. withdraw money");
            System.out.println("5. check balance");
            System.out.println("6. close account");
            System.out.println("7. exit");
            System.out.print("choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                Account = facade.openaccountWithBenefits("savings");
            } else if (choice == 2) {
                Account = facade.openaccountWithBenefits("investment");
            } else if (choice == 3) {
                if (Account == null) {
                    System.out.println("no account opened yet.");
                } else {
                    facade.deposit(Account);
                }
            } else if (choice == 4) {
                if (Account == null) {
                    System.out.println("no account opened yet.");
                } else {
                    facade.withdraw(Account);
                }
            } else if (choice == 5) {
                if (Account == null) {
                    System.out.println("no account opened yet.");
                } else {
                    facade.displaybalance(Account);
                }
            } else if (choice == 6) {
                if (Account == null) {
                    System.out.println("no account opened yet.");
                } else {
                    facade.closeaccount(Account);
                    Account = null;
                }
            } else if (choice == 7) {
                break;
            } else {
                System.out.println("invalid choice.");
            }
        }

        scanner.close();
        System.out.println("thank you for using the banking system.");
    }
}

