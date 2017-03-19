/**
 * 
 * Financial Application - Find the Sales Amount
 * 
 * This program calculates the amount of sales required to reach
 * a target salary of $30,000 based on a graduated commission rate.
 * 
 * Sales Amount				Commission Rate
 * $0.01–$5,000				8 percent
 * $5,000.01–$10,000		10 percent
 * $10,000.01 and above		12 percent
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

import java.text.NumberFormat;

public class SalesAmount
{

	public static void main(String[] args)
	{
		double baseSalary = 5000;
		double salaryTarget = 30000;
		double totalSalary = 0;
		double totalSales = 0;
		
		// Increase sales until salary reaches at least 30000
		// Reset salary each iteration by starting at base salary and adding commission
		while (totalSalary < salaryTarget)
		{
			// Increase sales by a penny
			totalSales += .01;
			
			// Recalculate total salary
			totalSalary = baseSalary + calculateCommission(totalSales);
		}
		
		// Currency formatter
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

		// Display result
		System.out.println("Sales: " + currencyFormat.format(totalSales));
		System.out.println("Commission: " + currencyFormat.format(calculateCommission(totalSales)));
		System.out.println("Salary: " + currencyFormat.format(totalSalary));
	}
	
	private static double calculateCommission(double totalSales)
	{
		// $0.01-$5,000
		int maxCommissionBracket1 = 5000;
		double commissionRate1 = .08;
		// $5,000.01-$10,000
		int maxCommissionBracket2 = 10000;
		double commissionRate2 = .10;
		// $10.000.01+
		double commissionRate3 = .12;

		double totalCommission = 0;

		// Bracket 1
		if (totalSales < maxCommissionBracket1)
		{
			// Commission =
			// Sales * .08
			totalCommission = totalSales * commissionRate1;
		}
		// Bracket 2
		else if (totalSales < maxCommissionBracket2)
		{
			// Commission =
			// 5000 * .08 +
			// Remaining sales * .10
			totalCommission = ((double)maxCommissionBracket1 * commissionRate1)
					+ ((totalSales - (double)maxCommissionBracket1) * commissionRate2);
		}
		// Bracket 3
		else
		{
			// Commission =
			// 5000 * .08 +
			// 5000 * .10 +
			// Remaining sales * .12
			totalCommission = ((double)maxCommissionBracket1 * commissionRate1)
					+ (((double)maxCommissionBracket2 - (double)maxCommissionBracket1) * commissionRate2)
					+ ((totalSales - (double)maxCommissionBracket2) * commissionRate3);
		}

		return totalCommission;
	}

}
