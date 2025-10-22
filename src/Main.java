import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        DatabaseConnection.createTable();


        System.out.println("1. Register");
        System.out.println("2. Login");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {

            System.out.println("Enter username:");
            String username = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();
            String passwordHash = hashPassword(password);


            DatabaseConnection.addUser(username, passwordHash, 0.0);
            System.out.println("Registration successful!");
        }


        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();


        User user = DatabaseConnection.getUserByUsername(username);

        if (user != null && user.getPasswordHash().equals(hashPassword(password))) {
            System.out.println("Login successful! Welcome " + username);

            boolean exit = false;
            while (!exit) {
                System.out.println("\nSelect operation:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                int operation = scanner.nextInt();
                switch (operation) {
                    case 1:
                        System.out.println("Enter amount to deposit:");
                        double depositAmount = scanner.nextDouble();
                        DatabaseConnection.deposit(username, depositAmount);
                        user = DatabaseConnection.getUpdatedUser(username);
                        break;
                    case 2:
                        System.out.println("Enter amount to withdraw:");
                        double withdrawAmount = scanner.nextDouble();
                        DatabaseConnection.withdraw(username, withdrawAmount);
                        user = DatabaseConnection.getUpdatedUser(username);
                        break;
                    case 3:
                        System.out.println("Current balance: " + user.getBalance());
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option! Try again.");
                }
            }
        } else {
            System.out.println("Invalid login or password.");
        }

        scanner.close();
    }


    public static String hashPassword(String password) {

        return password;
    }
}
