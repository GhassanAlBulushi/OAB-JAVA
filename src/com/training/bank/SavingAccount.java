package com.training.bank;

public class SavingAccount {
    private int accountNumber;
    private String name;
    private double roi; // Rate of interest
    private double amount;

    // Constructor
    public SavingAccount(int accountNumber, String name, double roi, double amount) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.roi = roi;
        this.amount = amount;
    }

    // Getter and Setter methods
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Rate of Interest: " + roi + "%");
        System.out.println("Amount: " + amount);
    }

    // Main method to test the class
    public static void main(String[] args) {
        SavingAccount account = new SavingAccount(12345, "John Doe", 3.5, 10000.0);
        account.displayAccountDetails(); 
    }
}
