/**
 * 
 * Investment Value Calculator
 * 
 * This program will accept an investment amount and interest rate
 * and then print the value of the investment over the next 30 years.
 * 
 * @author  Nicholas Robertson
 * Grand Canyon University
 * 
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class InvestmentValueCalculator
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);

		System.out.println("This program will accept an investment amount and interest rate "
				+ "and then print the value of the investment over the next 30 years.");
		System.out.println("When entering the percentage, enter as a whole number.  For example, "
				+ "15 for 15%, 5 for 5%, etc.");

		// Accept user input
		System.out.println("The amount invested: ");
		double amountInvested = input.nextDouble();
		System.out.println("Annual interest rate: ");
		double annualInterestRate = input.nextDouble();
		double monthlyInterestRate = annualInterestRate / 12.0;

		// Hard code the number of years to 30
		int numberOfYears = 30;

		// Calculate and display future investments
		futureInvestmentValue(amountInvested, monthlyInterestRate, numberOfYears);
	}

	public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years)
	{
		// Create formatters for $$
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

		System.out.println("Years     Future Value");

		// Convert interest rate to percentage
		monthlyInterestRate *= .01;
		double currentValue = investmentAmount;

		for (int i = 1; i <= years; i++)
		{
			currentValue = calculateYearlyInterest(currentValue, monthlyInterestRate);
			System.out.println(i + "         " + currencyFormatter.format(currentValue));
		}

		return 0;
	}

	public static double calculateYearlyInterest(double currentValue, double monthlyInterestRate)
	{
		// Interest compounded monthly
		// Iterate 12 times for one year
		for (int i = 0; i < 12; i++)
		{
			currentValue += currentValue * monthlyInterestRate;
		}

		return currentValue;
	}

}
