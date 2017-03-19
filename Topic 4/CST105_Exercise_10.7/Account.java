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