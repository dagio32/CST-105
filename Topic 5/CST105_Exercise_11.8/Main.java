/**
 * 
 * Account
 * 
 * This program instantiates the Account class, makes several transactions, and
 * then displays the transaction history to the console.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

import java.text.NumberFormat;

public class Main
{

	public static void main(String[] args)
	{
		// Currency formatter
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		
		// Instantiate account
		Account account = new Account("George", 1122, 1000);
		account.setAnnualInterestRate(1.5);
		
		// Deposit money
		account.deposit(30);
		account.deposit(40);
		account.deposit(50);
		
		// Withdraw money
		account.withdraw(5);
		account.withdraw(4);
		account.withdraw(2);
		
		// Display summary
		System.out.println("Name: " + account.getName());
		System.out.println("Interest rate: " + account.getAnnualInterestRate() + "%");
		System.out.println("Balance: " + currencyFormat.format(account.getBalance()) + "\r\n");
		
		// Display each transaction
		for (Transaction transaction: account.getTransactions())
		{
			System.out.println("Date: " + transaction.getDate());
			System.out.println(transaction.getDescription());
			System.out.println("Balance: " + currencyFormat.format(transaction.getBalance()) + "\r\n");
		}
		
	}

}
