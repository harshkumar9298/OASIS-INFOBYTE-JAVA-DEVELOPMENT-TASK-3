package com.atm.transaction.app;

import java.util.Scanner;
 class bankTransaction{
	 	//variable declaration
	 	String name;
	 	String uName;
	 	String pWord;
	 	Double accNo;
	 	String accType;
	 	String TransactionHistory="";
	 	int transaction=0;
	 	float bankBalance=100000f;
	 	Scanner s=new Scanner(System.in);
	 	public void register() {
	 		
	 		System.out.println("Enter Name: ");
	 		name=s.nextLine();
	 		System.out.println("Enter UserName: ");
	 		uName=s.nextLine();
	 		System.out.println("Enter password: ");
	 		pWord=s.nextLine();
	 		System.out.println("Enter Account Number: ");
	 		accNo=Double.parseDouble(s.nextLine());
	 		System.out.println("Enter Account Type");
	 		accType=s.nextLine();
	 		System.out.println("Registration Completed....Please login");
	 	}
	 	public boolean login() {
	 			 		
	 		System.out.println("Enter UserName: ");
	 		String uN=s.nextLine();
	 		System.out.println("Enter password: ");
	 		String pW=s.nextLine();
	 		if(uN.equals(uName) && pW.equals(pWord)) {
	 			return true;
	 		}
	 		else {
	 			return false;
	 		}
	 	    
			
	 	}
	 	public void withdraw() {
	 		System.out.println("Enter The Amount You Want to Withdraw : ");
	 		float amt=Float.parseFloat(s.nextLine());
	 		if(bankBalance>=amt) {
	 		transaction++;
	 		bankBalance=bankBalance-amt;
	 		String th=amt+"Amount Withdrawn sucessfully \n";
	 		System.out.println(th);
	 		TransactionHistory = TransactionHistory.concat(th);
	 		}
	 		else
	 		{
	 			System.out.println
	 			("Insufficient Balance");
	 		}
	 		}
	 	public void deposite() {
	 		System.out.println("Enter The Amount You Want to deposite : ");
	 		float amt=Float.parseFloat(s.nextLine());
	 		if(amt<=100000f) {
	 		transaction++;
	 		bankBalance=bankBalance+amt;
	 		String t2=amt+"Amount Deposited sucessfully \n";
	 		System.out.println(t2);
	 		TransactionHistory = TransactionHistory.concat(t2);
	 		}
	 		else
	 		{
	 			System.out.println
	 			("Opps!!! Limit is 100000");
	 		}
	 	}
	 	public void showBalance() {
	 		System.out.println("Available Balance Is: "+bankBalance);
	 	}
	 	
	 	public void transfer() {
	 		System.out.print("\nEnter Receipent's Name : ");
			String rName = s.nextLine();
			System.out.print("\nEnter amount to transfer : ");
			float amt = Float.parseFloat(s.nextLine());
			if ( bankBalance >= amt ) {
					if ( amt<= 50000f ) {
						transaction++;
						bankBalance =bankBalance-amt;
						System.out.println("\nSuccessfully Transfered to " + rName);
						String th = amt + " Rs transfered to " + rName + "\n";
						TransactionHistory = TransactionHistory.concat(th);
					}
					else {
						System.out.println("\nSorry...Limit is 50000.00");
					}
				}
				else {
					System.out.println("\nInsufficient Balance");
				}
			}
	 	public void TransactionHistory() {
	 		if(transaction==0) {
	 			System.out.println("\nNo Transaction Available");
	 		}
	 		else {
	 			System.out.println("\n"+TransactionHistory);
	 		}
	 	}
	 	
 }
	
public class Atm_Transaction {
		public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		boolean loop1=true;
		boolean loop2=true;
		boolean loop3=true;
		while(loop1) {
				System.out.println("********Welcome To Atm********");
				System.out.println("\n1.Register\n2.Exit");
				int choice=Integer.parseInt(s.nextLine());
				switch(choice) {
				case 1:
					bankTransaction at=new bankTransaction();
					at.register();//register() call
					
					while(loop2) {
					System.out.println("\n1.Login \n2.Exit");
					int z=Integer.parseInt(s.nextLine());
					switch(z){
					case 1:
						boolean isLogin=at.login();// Login() call
						if(isLogin)
						{	
							
							System.out.println("Welcome back " +at.name);
							while(loop3) {
										System.out.println
										("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
										System.out.print("\nEnter Your Choice : ");
										int choice1=Integer.parseInt(s.nextLine());
										switch(choice1) {
										case 1:
											at.withdraw();
											break;
										case 2:
											at.deposite();
											break;
										case 3:
											at.transfer();
											break;
										case 4:
											at.showBalance();
											break;
										case 5:
											at.TransactionHistory();
											break;
										case 6:
											loop3=false;
											System.out.println("Thank You ");
											break;
										}//end of switch
										
							}//end of loop3
						}//end of if
						else {
							System.out.println("Opps...Incorrect UserName/Password");
						}//else
						break;
					case 2:
						loop2=false;
						System.out.println("Thank You ");
						break;
					}//inner switch
					
				}//loop2
				break;		
				case 2:
					loop1=false;
					System.out.println("Thank You ");
					break;
				}//end of outer switch
			
			}//loop1
		
		
	}

}
