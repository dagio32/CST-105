
/**
 * 
 * Account Class
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

public class Account
{
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();
	private String name;
	private ArrayList<Transaction> Transactions = new ArrayList<Transaction>();

	public Account()
	{
		id = 0;
		balance = 0;
		annualInterestRate = 0;
	}

	public Account(int _id, int _balance)
	{
		id = _id;
		balance = _balance;
	}

	public Account(String _name, int _id, int _balance)
	{
		name = _name;
		id = _id;
		balance = _balance;
	}

	// Get and set methods for id
	public int getId()
	{
		return id;
	}

	public void setId(int NewId)
	{
		id = NewId;
	}

	// Get and set methods for balance
	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double NewBalance)
	{
		balance = NewBalance;
	}

	// Get and set methods for annualInterestRate
	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double NewAnnualInterestRate)
	{
		annualInterestRate = NewAnnualInterestRate;
	}

	// Get method for dateCreated
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	// Get method for name
	public String getName()
	{
		return name;
	}

	// Monthly interest rate = yearly rate / 12
	public double getMonthlyInterestRate()
	{
		return annualInterestRate / 12.0;
	}

	// Monthly interest calculator
	public double getMonthlyInterest()
	{
		double monthlyInterest = balance * (getMonthlyInterestRate() / 100);
		return monthlyInterest;
	}

	// Withdraw and deposit methods
	public void withdraw(double WithdrawAmount)
	{
		// Currency formatter
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		
		balance -= WithdrawAmount;
		Transactions.add(new Transaction(new Date(), 'W', WithdrawAmount, balance, "Withdrew " + currencyFormat.format(WithdrawAmount)));
	}

	public void deposit(double DepositAmount)
	{
		// Currency formatter
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		
		balance += DepositAmount;
		Transactions.add(new Transaction(new Date(), 'D', DepositAmount, balance, "Deposited " + currencyFormat.format(DepositAmount)));
	}
	
	// Getter for Transaction history
	public ArrayList<Transaction> getTransactions()
	{
		return Transactions;
	}

	// toString override
	@Override
	public String toString()
	{
		return "Account for " + name;
	}
}

class Transaction
{
	private Date date;
	private char type;
	private double amount;
	private double balance;
	private String description;

	public Transaction(Date _date, char _type, double _amount, double _balance, String _description)
	{
		date = _date;
		type = _type;
		amount = _amount;
		balance = _balance;
		description = _description;
	}
	
	// Getter methods
	public Date getDate()
	{
		return date;
	}
	
	public char getType()
	{
		return type;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public String getDescription()
	{
		return description;
	}
}