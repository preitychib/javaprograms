//! not tested 
//! requires given database and procedure to exit on the server

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MoneyTransfer {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Disable auto-commit to start a transaction
            connection.setAutoCommit(false);

            // Simulating two accounts with balances
            int fromAccountId = 1;
            int toAccountId = 2;
            double amountToTransfer = 100.0;

            // Perform the money transfer
            if (transferMoney(connection, fromAccountId, toAccountId, amountToTransfer)) {
                // Commit the transaction if successful
                connection.commit();
                System.out.println("Money transfer successful!");
            } else {
                // Rollback the transaction if there was an issue
                connection.rollback();
                System.out.println("Money transfer failed. Transaction rolled back.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean transferMoney(Connection connection, int fromAccountId, int toAccountId, double amount) {
        try {
            // Deduct money from the source account
            updateAccountBalance(connection, fromAccountId, -amount);

            // Add money to the destination account
            updateAccountBalance(connection, toAccountId, amount);

            return true; // Money transfer successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Money transfer failed
        }
    }

    private static void updateAccountBalance(Connection connection, int accountId, double amount) throws SQLException {
        String updateQuery = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
        }
    }
}

