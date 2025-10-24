import classes.account;
import classes.investmentaccount;
import facades.bankfacade;

import java.util.Scanner;

public class termainalinterface {

    private static bankfacade facade = new bankfacade();
    private static account currentAccount = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("Digital Banking System");
            System.out.println("1. Open Savings Account");
            System.out.println("2. Open Investment Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. View Account Details");
            System.out.println("6. Close Account");
            System.out.println("7. Exit");
            System.out.println("8. Buy Insurance for Investment Account");


            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    openSavingsAccount();
                    break;
                case 2:
                    openInvestmentAccount();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    withdrawMoney();
                    break;
                case 5:
                    viewAccountDetails();
                    break;
                case 6:
                    closeAccount();
                    break;
                case 7:
                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);
                    break;
                case 8:
                    buyInsurance();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void openSavingsAccount() {
        if (currentAccount != null) {
            System.out.println("You already have an account open. Please close it first.");
        } else {
            currentAccount = facade.openSavingsAccount();
            System.out.println("Savings account created with Reward Points enabled.");
        }
    }

    private static void openInvestmentAccount() {
        if (currentAccount != null) {
            System.out.println("You already have an account open. Please close it first.");
        } else {
            currentAccount = facade.openInvestmentAccount();
            System.out.println("Investment account created with Tax Optimization.");
        }
    }

    private static void depositMoney() {
        if (currentAccount == null) {
            System.out.println("No account found. Please open an account first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        currentAccount.deposit(amount);
        System.out.println("Deposited: " + amount);
    }

    private static void withdrawMoney() {
        if (currentAccount == null) {
            System.out.println("No account found. Please open an .account first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        currentAccount.withdraw(amount);
        System.out.println("Withdrawn: " + amount);
    }

    private static void viewAccountDetails() {
        if (currentAccount == null) {
            System.out.println("No account found. Please open an account first.");
            return;
        }

        currentAccount.printAccountDetails();
    }

    private static void buyInsurance() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to buy insurance for $700? (yes/no): ");
        String response = scanner.nextLine().toLowerCase();

        if (response.equals("yes")) {
            facade.purchaseInsurance(currentAccount);
        } else {
            System.out.println("Insurance purchase cancelled.");
        }
    }

    private static void closeAccount() {
        if (currentAccount == null) {
            System.out.println("No account found to close.");
        } else {
            facade.closeAccount(currentAccount);
            currentAccount = null;
            System.out.println("Account closed successfully.");
        }
    }
}
