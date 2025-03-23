package com.training.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class account2 {
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "pass123";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Scanner scanner = new Scanner(System.in)) {
            
            Class.forName("org.postgresql.Driver");
            
            while (true) {
                System.out.println("\n===== Banking System Menu =====");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Transfer Funds");
                System.out.println("5. Check Balance");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                
                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1 -> createAccount(conn, scanner);
                    case 2 -> depositMoney(conn, scanner);
                    case 3 -> withdrawMoney(conn, scanner);
                    case 4 -> transferFunds(conn, scanner);
                    case 5 -> checkBalance(conn, scanner);
                    case 6 -> {
                        System.out.println("Thank you for using the banking system!");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    private static void createAccount(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty!");
                return;
            }

            String sql = "INSERT INTO bank_account (name, balance) VALUES (?, 0.00)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, name);
                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    ResultSet rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                        int accountId = rs.getInt(1);
                        System.out.println("Account created successfully! Your Account ID: " + accountId);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating account: " + e.getMessage());
        }
    }

    private static void depositMoney(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter your Account ID: ");
            int accountId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter deposit amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                System.out.println("Deposit amount must be greater than zero.");
                return;
            }

            String sql = "UPDATE bank_account SET balance = balance + ? WHERE account_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1, amount);
                pstmt.setInt(2, accountId);
                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Deposit successful!");
                } else {
                    System.out.println("Account not found.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error during deposit: " + e.getMessage());
        }
    }

    private static void withdrawMoney(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter your Account ID: ");
            int accountId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter withdrawal amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                System.out.println("Withdrawal amount must be greater than zero.");
                return;
            }

            String checkBalanceSQL = "SELECT balance FROM bank_account WHERE account_id = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkBalanceSQL)) {
                checkStmt.setInt(1, accountId);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    double currentBalance = rs.getDouble("balance");
                    if (currentBalance < amount) {
                        System.out.println("Insufficient funds!");
                        return;
                    }

                    String withdrawSQL = "UPDATE bank_account SET balance = balance - ? WHERE account_id = ?";
                    try (PreparedStatement withdrawStmt = conn.prepareStatement(withdrawSQL)) {
                        withdrawStmt.setDouble(1, amount);
                        withdrawStmt.setInt(2, accountId);
                        withdrawStmt.executeUpdate();
                        System.out.println("Withdrawal successful!");
                    }
                } else {
                    System.out.println("Account not found.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error during withdrawal: " + e.getMessage());
        }
    }

    private static void transferFunds(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter Sender Account ID: ");
            int senderId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Recipient Account ID: ");
            int recipientId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Transfer Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                System.out.println("Transfer amount must be greater than zero.");
                return;
            }

            conn.setAutoCommit(false);

            String checkBalanceSQL = "SELECT balance FROM bank_account WHERE account_id = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkBalanceSQL)) {
                checkStmt.setInt(1, senderId);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getDouble("balance") >= amount) {
                    String withdrawSQL = "UPDATE bank_account SET balance = balance - ? WHERE account_id = ?";
                    try (PreparedStatement withdrawStmt = conn.prepareStatement(withdrawSQL)) {
                        withdrawStmt.setDouble(1, amount);
                        withdrawStmt.setInt(2, senderId);
                        withdrawStmt.executeUpdate();
                    }

                    String depositSQL = "UPDATE bank_account SET balance = balance + ? WHERE account_id = ?";
                    try (PreparedStatement depositStmt = conn.prepareStatement(depositSQL)) {
                        depositStmt.setDouble(1, amount);
                        depositStmt.setInt(2, recipientId);
                        int affectedRows = depositStmt.executeUpdate();

                        if (affectedRows > 0) {
                            conn.commit();
                            System.out.println("Transfer successful!");
                        } else {
                            conn.rollback();
                            System.out.println("Recipient account not found. Transfer canceled.");
                        }
                    }
                } else {
                    conn.rollback();
                    System.out.println("Insufficient funds or sender account not found.");
                }
            }
        } catch (Exception e) {
            try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            System.out.println("Error during transfer: " + e.getMessage());
        } finally {
            try { conn.setAutoCommit(true); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    private static void checkBalance(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter your Account ID: ");
            int accountId = Integer.parseInt(scanner.nextLine());
            String sql = "SELECT balance FROM bank_account WHERE account_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, accountId);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Your current balance: $" + rs.getDouble("balance"));
                } else {
                    System.out.println("Account not found.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error checking balance: " + e.getMessage());
        }
    }
}
