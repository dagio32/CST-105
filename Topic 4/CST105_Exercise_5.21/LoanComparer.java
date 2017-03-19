/**
 * 
 * Financial Application - Compare Loans With Various Interest Rates
 * 
 * This program will accept a loan amount and loan length from the user.
 * It will display monthly payments and total payments for various
 * interest rates, ranging from 5% to 8% and incrementing by .125%.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanComparer
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);
		
		// Accept user input
		System.out.println("Loan Amount: ");
		int loanAmount = input.nextInt();
		System.out.println("Number of Years: ");
		int numberOfYears = input.nextInt();
		
		// Display columns
		System.out.println("Interest Rate		Monthly Payment		Total Payment");
		
		// Set initial interest rate
		double interestIncrement = .00125;
		double interestRate = .05;
		
		// Print the values to the console
		// 24 increments to reach 8% interest
		for (int i = 0; i < 25; i++)
		{
			printLoanOutput(loanAmount, numberOfYears, interestRate);
			interestRate += interestIncrement;
		}
	}
	
	private static void printLoanOutput(int loanAmount, int numberOfYears, double interestRate)
	{
		//Percentage formatter
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		percentFormat.setMinimumFractionDigits(3);
		
		//Currency formatter
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

		//Display interest rate
		System.out.print(percentFormat.format(interestRate) + "			");
		
		//Convert interest rate to monthly
		interestRate /= 12;

		//Calculate and display monthly payment
		double monthlyPayment = loanAmount * interestRate / (1 - 1 / Math.pow(1 + interestRate, numberOfYears * 12));
		System.out.print(currencyFormat.format(monthlyPayment) + "			");
		
		//Calculate and display total payment
		double totalPayment = monthlyPayment * numberOfYears * 12;
		System.out.println(currencyFormat.format(totalPayment));
	}

}
