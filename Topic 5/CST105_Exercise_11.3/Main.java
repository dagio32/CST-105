/**
 * 
 * Subclasses of Account
 * 
 * This program instantiates the three classes Account, CheckingAccount, and SavingsAccount,
 * and invokes their toString() method and prints them to the console. 
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

public class Main
{

	public static void main(String[] args)
	{
		Account account = new Account(0, 500);
		CheckingAccount checkingAccount = new CheckingAccount(1, 1000, 200);
		SavingsAccount savingsAccount = new SavingsAccount(2, 2000);

		System.out.println(account.toString());
		System.out.println(checkingAccount.toString());
		System.out.println(savingsAccount.toString());
	}

}
