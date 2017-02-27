import java.util.Scanner;


public class MonthlyInterestCalculator 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the balance: ");
		double balance = input.nextDouble();
		System.out.println("Enter the annual interest rate: ");
		double annualInterestRate = input.nextDouble();
		double monthlyInterest = balance * (annualInterestRate/1200);
		System.out.println("The interest for next month is $" + monthlyInterest);
	}
}
