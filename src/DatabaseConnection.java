import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/Mydatabase";  // Имя вашей базы данных
    private static final String USER = "postgres";  // Имя пользователя базы данных
    private static final String PASSWORD = "0000";  // Пароль пользователя


    public static Connection connect() {
        try {

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            System.out.println("Failed to connect to PostgreSQL: " + e.getMessage());
            return null;
        }
    }


    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id SERIAL PRIMARY KEY, " +
                "username VARCHAR(255) NOT NULL, " +
                "password_hash VARCHAR(255) NOT NULL, " +
                "balance DECIMAL NOT NULL);";

        try (Connection connection = connect(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }


    public static void addUser(String username, String passwordHash, double balance) {
        String insertSQL = "INSERT INTO users (username, password_hash, balance) VALUES (?, ?, ?)";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, passwordHash);
            preparedStatement.setDouble(3, balance);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("User added successfully! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }


    public static User getUserByUsername(String username) {
        String selectSQL = "SELECT * FROM users WHERE username = ?";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String passwordHash = resultSet.getString("password_hash");
                double balance = resultSet.getDouble("balance");
                return new User(username, passwordHash, balance);
            } else {
                System.out.println("User not found!");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving user: " + e.getMessage());
            return null;
        }
    }


    public static void updateBalance(String username, double newBalance) {
        String updateSQL = "UPDATE users SET balance = ? WHERE username = ?";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            preparedStatement.setDouble(1, newBalance);
            preparedStatement.setString(2, username);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Balance updated successfully.");
            } else {
                System.out.println("No user found with the username: " + username);
            }
        } catch (SQLException e) {
            System.out.println("Error updating balance: " + e.getMessage());
        }
    }


    public static void deposit(String username, double amount) {
        String depositSQL = "UPDATE users SET balance = balance + ? WHERE username = ?";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(depositSQL)) {

            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, username);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deposit successful.");
            } else {
                System.out.println("No user found with the username: " + username);
            }
        } catch (SQLException e) {
            System.out.println("Error making deposit: " + e.getMessage());
        }
    }
    public static User getUpdatedUser(String username) {
        return getUserByUsername(username);
    }

    public static void withdraw(String username, double amount) {
        String withdrawSQL = "UPDATE users SET balance = balance - ? WHERE username = ?";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(withdrawSQL)) {

            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, username);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("No user found with the username: " + username);
            }
        } catch (SQLException e) {
            System.out.println("Error making withdrawal: " + e.getMessage());
        }
    }
}
