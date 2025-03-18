package com.training.bank;

public class SavingAc2 {
	
	
	private int ACCOUNTNUMBER ;
	private String name  ;
	private double ROI  ;
	private double amount;
    
	
	
	
	public SavingAc2(int ACCOUNTNUMBER,String name,double ROI,double amount){
		this.ACCOUNTNUMBER=ACCOUNTNUMBER;
		this.name=name;
		this.ROI=ROI;
		this.amount=amount;
	}
		
	
    
	public int getACCOUNTNUMBER() {
		return ACCOUNTNUMBER;
	}

	
	public void setname(String name) {
		
		this.name = name;

	
	}
	
	
	

	public void setROI(double ROI) {
		
		this.ROI = ROI;

	
	}
	

	public void setamount(double amount) {
		
		this.amount = amount;
	
	}
	

	public void setACCOUNTNUMBER(int ACCOUNTNUMBER) {
		
		this.ACCOUNTNUMBER = ACCOUNTNUMBER;

	
	}
	
	
	public String getname() {
		return name;
	}
	

	public double getROI() {
		return ROI;
	}
	

	public double getamount() {
		return amount;
	}
	
	
	
    void CALCULATE() {
    	double totalAmount = amount + (amount * ROI / 100);  // Calculate interest
        System.out.println("TOTAL AMOUNT AFTER 12 months: " + totalAmount);
    }
    
    public String toString() {
    	return "ACCOUNTNUMBER : " + this.ACCOUNTNUMBER+ "  amount : "+this.amount +" roi: "+this.ROI + "  name: "+this.name  ;
    }
}