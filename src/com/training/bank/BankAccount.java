package com.training.bank;



import java.util.Scanner;
public class BankAccount {  // protected: in package only = defualt // priveate : for class only // public : every one // final : cannot be subclassed and preivent inharten

	
	
	String accountHolderName;  // public variable
	
	
	 void display() {
		
		int age = 21; //local variable
		accountHolderName = "David";
		
		 
	}
	 
	 
	
	
	
	
	
	
	public static void main(String[] args) {    
//		System.out.println("welcome to my Bank!!");
//		System.out.println("first argument: " +args[0]);
		
//		BankAccount account1 = new BankAccount();
//		account1.accountHolderName="david";
//		
//		short s =10;
//		int i=9;
//		s= (short)i;
//		i=s;
//		System.out.println(i);

		
		////////////////////////////////////////////////////////////////////////////////////////
		
		
//		 SAVINGACCOUNT  SAVINGACCOUNT1=new SAVINGACCOUNT(1231,"jaber",5,120000);
//		   
//		 System.out.println(SAVINGACCOUNT1);
//
//	        SAVINGACCOUNT1.CALCULATE();

		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		///
		///
		///
		///
		///
		
		
//		 Scanner sc =new Scanner(System.in);
//		 System.out.println("enter account number : ");
//		 int accNumber = sc.nextInt();
//		 System.out.println("enter First name : ");
//		 String name1 = sc.next();
//		 
//		 
//		 System.out.println("enter Last name : ");
//		 String name2 = sc.next();
//		 String name=name1 +" "+name2;
//		 
//		 
//		 System.out.println("enter rate pf interest : ");
//		 double roi = sc.nextDouble();
//		 
//		 System.out.println("enter amount : ");
//		 double amount = sc.nextDouble();
//		 
//		 
//		 
//		 SavingAc2  SAVINGACCOUNT1=new SavingAc2(accNumber,name,roi,amount);
//		   
//		 System.out.println(SAVINGACCOUNT1);
//
//	     SAVINGACCOUNT1.CALCULATE();
//
//		
//	     String[] names = new String[4]; //use same type for all + same size not change 
//	     names[0]= "ali";
//	     names[1]= "ali1";
//	     names[2]= "ali2";
//	     names[3]= "ali3";
//
//	     
//	     
//	     for (int i=0; i<names.length;i++) {
//			 System.out.println(names[i]);
//
//	    	 
//	     }


		SavingAc2  SAVINGACCOUNT1=new SavingAc2(1231,"ghassan",5,132);
		SavingAc2  SAVINGACCOUNT2=new SavingAc2(234,"ghassan1",5,322);

		SavingAc2  SAVINGACCOUNT3=new SavingAc2(34,"ghassan2",5,3233);

		SavingAc2  SAVINGACCOUNT4=new SavingAc2(32553,"ghassan3",5,422);

		
		SavingAc2[] accs=new SavingAc2[4];
		
		accs[0]=SAVINGACCOUNT1;
		accs[1]=SAVINGACCOUNT2;
		accs[2]=SAVINGACCOUNT3;
		accs[3]=SAVINGACCOUNT4;
		
		
	int accmax=0;
	double accamount=accs[0].getamount();
	
     for (int i=0; i<accs.length;i++) {
    	 if (accamount < accs[i].getamount()) {
    		 accamount= accs[i].getamount();
    		 accmax=i;
    		
    	 }
    	 }
     System.out.println(accs[accmax]);

     }
    	 {
     
		
		
		

	}

}