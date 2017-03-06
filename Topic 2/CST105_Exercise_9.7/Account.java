//Created by Nicholas Robertson for Grand Canyon University

/*
 9.7 (The Account class) Design a class named Account that contains:
 * A private int data field named id for the account (default 0).
 * A private double data field named balance for the account (default 0).
 * A private double data field named annualInterestRate that stores the current
 interest rate (default 0). Assume all accounts have the same interest rate.
 * A private Date data field named dateCreated that stores the date when the
 account was created.
 * A no-arg constructor that creates a default account.
 * A constructor that creates an account with the specified id and initial balance.
 * The accessor and mutator methods for id, balance, and annualInterestRate.
 * The accessor method for dateCreated.
 * A method named getMonthlyInterestRate() that returns the monthly
 interest rate.
 * A method named getMonthlyInterest() that returns the monthly interest.
 * A method named withdraw that withdraws a specified amount from the
 account.
 * A method named deposit that deposits a specified amount to the account.
 Draw the UML diagram for the class and then implement the class. (Hint: The
 method getMonthlyInterest() is to return monthly interest, not the interest rate.
 Monthly interest is balance * monthlyInterestRate. monthlyInterestRate
 is annualInterestRate / 12. Note that annualInterestRate is a percentage,
 e.g., like 4.5%. You need to divide it by 100.)
 Write a test program that creates an Account object with an account ID of 1122,
 a balance of $20,000, and an annual interest rate of 4.5%. Use the withdraw
 method to withdraw $2,500, use the deposit method to deposit $3,000, and print
 the balance, the monthly interest, and the date when this account was created.
 */

import java.text.NumberFormat;
import java.util.Date;

public class Account {

	public static void main(String[] args) {
		//Create new account instance using constructor
		Account account = new Account(1122, 20000);
		//Assign annual interest rate
		account.AnnualInterestRate = 4.5;

		//Withdraw and deposit some money
		account.withdraw(2500);
		account.deposit(3000);
		
		//Format to currency
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		currencyFormat.setMinimumFractionDigits(2);
		
		System.out.println("Balance: " + currencyFormat.format(account.getBalance()));
		System.out.println("Monthly interest: " + currencyFormat.format(account.getMonthlyInterest()));
		System.out.println("Account created: " + account.DateCreated);
	}

	private int Id;
	private double Balance;
	private double AnnualInterestRate;
	private Date DateCreated = new Date();

	public Account() {
		Id = 0;
		Balance = 0;
		AnnualInterestRate = 0;
	}

	public Account(int id, int balance) {
		Id = id;
		Balance = balance;
	}

	// Get and set methods for Id
	public int getId() {
		return Id;
	}

	public void setId(int newId) {
		Id = newId;
	}

	// Get and set methods for Balance
	public double getBalance() {
		return Balance;
	}

	public void setBalance(double newBalance) {
		Balance = newBalance;
	}

	// Get and set methods for AnnualInterestRate
	public double getAnnualInterestRate() {
		return Balance;
	}

	public void setAnnualInterestRate(double newAnnualInterestRate) {
		AnnualInterestRate = newAnnualInterestRate;
	}

	// Get method for DateCreated
	public Date getDateCreated() {
		return DateCreated;
	}

	// Monthly interest rate = yearly rate / 12
	public double getMonthlyInterestRate() {
		return AnnualInterestRate / 12.0;
	}

	// Monthly interest calculator
	public double getMonthlyInterest() {
		double monthlyInterest = Balance * (getMonthlyInterestRate() / 100);
		return monthlyInterest;
	}

	// Withdraw and deposit methods
	public void withdraw(double withdrawAmount) {
		Balance -= withdrawAmount;
	}

	public void deposit(double depositAmount) {
		Balance += depositAmount;
	}
}