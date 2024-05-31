package com.first;

public class BankAccount {
	private String accountNumber;
	
	private double balance;
	
	

	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		if (balance>=0) {
			this.balance = balance;
		}
		else {
			System.out.println("balance cannot be negative.");
		}
	}


		public BankAccount(String accountNumber, double balance) {
		
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if (amount>0) {
			balance += amount;
		}else {
			System.out.println("Deposit amount must be positive");
		}
	}
	
	public void withdraw(double amount) {
		if (amount> 0 && amount<=balance) {
			balance -= amount;
		}else {
			System.out.println("Invalid Withdrawal amount");
		}
	}

	public void displayAccountDetails() {
		System.out.println("account number : " + accountNumber);
		System.out.println("Balance:"+ balance);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankAccount account = new BankAccount("123456789",500.0);
		
		account.displayAccountDetails();
		
		account.setAccountNumber("987654321");
		account.setBalance(1000.0);
		
		account.displayAccountDetails();
		
		account.deposit(500.0);
		account.withdraw(200.0);
		
		account.displayAccountDetails();
	}
	
}
