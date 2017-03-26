import java.util.Date;

public class Account
{
	protected int Id;
	protected double Balance;
	protected double AnnualInterestRate;
	protected Date DateCreated = new Date();

	public Account()
	{
		Id = 0;
		Balance = 0;
		AnnualInterestRate = 0;
	}

	public Account(int id, int balance)
	{
		Id = id;
		Balance = balance;
	}

	// Get and set methods for Id
	public int getId()
	{
		return Id;
	}

	public void setId(int newId)
	{
		Id = newId;
	}

	// Get and set methods for Balance
	public double getBalance()
	{
		return Balance;
	}

	public void setBalance(double newBalance)
	{
		Balance = newBalance;
	}

	// Get and set methods for AnnualInterestRate
	public double getAnnualInterestRate()
	{
		return AnnualInterestRate;
	}

	public void setAnnualInterestRate(double newAnnualInterestRate)
	{
		AnnualInterestRate = newAnnualInterestRate;
	}

	// Get method for DateCreated
	public Date getDateCreated()
	{
		return DateCreated;
	}

	// Monthly interest rate = yearly rate / 12
	public double getMonthlyInterestRate()
	{
		return AnnualInterestRate / 12.0;
	}

	// Monthly interest calculator
	public double getMonthlyInterest()
	{
		double monthlyInterest = Balance * (getMonthlyInterestRate() / 100);
		return monthlyInterest;
	}

	// Withdraw and deposit methods
	public void withdraw(double withdrawAmount)
	{
		Balance -= withdrawAmount;
	}

	public void deposit(double depositAmount)
	{
		Balance += depositAmount;
	}

	// toString override
	@Override
	public String toString()
	{
		return "Account";
	}
}

class CheckingAccount extends Account
{
	int OverdraftLimit;

	public CheckingAccount()
	{
		OverdraftLimit = 0;
	}

	public CheckingAccount(int id, int balance, int overdraftLimit)
	{
		Id = id;
		Balance = balance;
		OverdraftLimit = overdraftLimit;
	}

	// Withdraw method
	@Override
	public void withdraw(double withdrawAmount)
	{
		double tempBalance = Balance;
		tempBalance -= withdrawAmount;

		// Check if over the overdraft limit
		// Because OverdraftLimit is a positive number, needs to be converted to a negative
		if (tempBalance >= -OverdraftLimit)
		{
			Balance = tempBalance;
		}
	}

	// toString override
	@Override
	public String toString()
	{
		return "CheckingAccount";
	}

}

class SavingsAccount extends Account
{
	public SavingsAccount(int id, int balance)
	{
		Id = id;
		Balance = balance;
	}

	// Withdraw method
	@Override
	public void withdraw(double withdrawAmount)
	{
		double tempBalance = Balance;
		tempBalance -= withdrawAmount;

		// Account cannot be overdrawn
		if (tempBalance >= 0)
		{
			Balance = tempBalance;
		}
	}

	// toString override
	@Override
	public String toString()
	{
		return "SavingsAccount";
	}
}