package com.training.bank;

public class SavingAccount1 {
	
     private int accountNumber;
     private String name;
     private double roi; 
     private double amount;

    
    public SavingAccount1(int accountNumber, String name, double roi, double amount) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.roi = roi;
        this.amount = amount;
    }
    
    
    public double calculate() {
        return amount + (amount * roi / 100);
    }
    
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Rate of Interest: " + roi + "%");
        System.out.println("Initial Amount: " + amount);
        System.out.println("Total Amount after One Year: " + calculate());
    }
    
    
	public static void main(String[] args) {
		
		
		// create a class name saving account with accountNumber , name , ROI and amount 
		// create a method calculate inside this and return the total amount after one year

        SavingAccount1 account = new SavingAccount1(123456, "ghassan", 5.0, 10000);
        
        account.displayAccountDetails();

	}

}