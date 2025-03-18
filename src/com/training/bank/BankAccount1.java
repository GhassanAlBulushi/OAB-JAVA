package com.training.bank;

public class BankAccount1 {
	
	    private String accountNumber;
	    private String name;
	    private String roi; // Rate of interest
	    private String amount;

	    // Constructor
	    public BankAccount1(String accountNumber, String name, String roi, String amount) {
	        this.accountNumber = accountNumber;
	        this.name = name;
	        this.roi = roi;
	        this.amount = amount;
	    }

	    // Getter and Setter methods
	    public String getAccountNumber() {
	        return accountNumber;
	    }

	    public void setAccountNumber(String accountNumber) {
	        this.accountNumber = accountNumber;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getRoi() {
	        return roi;
	    }

	    public void setRoi(String roi) {
	        this.roi = roi;
	    }

	    public String getAmount() {
	        return amount;
	    }

	    public void setAmount(String amount) {
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
	    	BankAccount1[] accounts = {
	            new BankAccount1("12345", "ali mohammed", "3.5", "10000.0"),
	            new BankAccount1("67890", "Ahmed hamed", "3.7", "15000.0"),
	            new BankAccount1("11223", "jaber ali", "3.2", "8000.0"),
	            new BankAccount1("44556", "ghassan omar", "3.6", "20000.0")
	        };
	        
	        for (BankAccount1 account : accounts) {
	            account.displayAccountDetails();
	        }
	        
	        
	 
	        // Finding the account with the highest amount
	        BankAccount1 highest = accounts[0];
	        
	        for (int i = 1; i < accounts.length; i++) {
	            if (Double.parseDouble(accounts[i].getAmount()) > Double.parseDouble(highest.getAmount())) {
	                highest = accounts[i];
	            }
	        }
	        
	        System.out.println("\nAccount with the highest amount:");
	        highest.displayAccountDetails();
	    }
	}
