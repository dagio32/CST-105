//Created by Nicholas Robertson for Grand Canyon University

import java.util.Scanner;

public class ComputeTax {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter filing status
		System.out.print("(0-single filer, 1-married jointly or "
				+ "qualifying widow(er), 2-married separately, 3-head of "
				+ "household) Enter the filing status: ");

		int status = input.nextInt();

		// Prompt the user to enter taxable income
		System.out.print("Enter the taxable income: ");
		double income = input.nextDouble();

		// Compute tax
		double tax = 0;

		//Declare bracket variables
		int bracket1 = 0;
		int bracket2 = 0;
		int bracket3 = 0;
		int bracket4 = 0;
		int bracket5 = 0;
		
		if (status == 0) { // Set tax brackets for single filers
			bracket1 = 8350;
			bracket2 = 33950;
			bracket3 = 82250;
			bracket4 = 171550;
			bracket5 = 372950;
		} else if (status == 1) { // Set tax brackets for married file jointly or qualifying widow(er)
			bracket1 = 16700;
			bracket2 = 67900;
			bracket3 = 137050;
			bracket4 = 208850;
			bracket5 = 372950;
		} else if (status == 2) { // Set tax brackets for married separately
			bracket1 = 8350;
			bracket2 = 33950;
			bracket3 = 68525;
			bracket4 = 104425;
			bracket5 = 186476;
		} else if (status == 3) { // Set tax brackets for head of household
			bracket1 = 11950;
			bracket2 = 45500;
			bracket3 = 117450;
			bracket4 = 190200;
			bracket5 = 372950;
		} else {
			System.out.println("Error: invalid status");
			System.exit(1);
		}
		
		//Compute Taxes
		if (income <= bracket1)
			tax = income * 0.10;
		else if (income <= bracket2)
			tax = bracket1 * 0.10 + (income - bracket1) * 0.15;
		else if (income <= bracket3)
			tax = bracket1 * 0.10 + (bracket2 - bracket1) * 0.15 + (income - bracket2)
					* 0.25;
		else if (income <= bracket4)
			tax = bracket1 * 0.10 + (bracket2 - bracket1) * 0.15 + (bracket3 - bracket2)
					* 0.25 + (income - bracket3) * 0.28;
		else if (income <= bracket5)
			tax = bracket1 * 0.10 + (bracket2 - bracket1) * 0.15 + (bracket3 - bracket2)
					* 0.25 + (bracket4 - bracket3) * 0.28 + (income - bracket4)
					* 0.33;
		else
			tax = bracket1 * 0.10 + (bracket2 - bracket1) * 0.15 + (bracket3 - bracket2)
					* 0.25 + (bracket4 - bracket3) * 0.28 + (bracket5 - bracket4)
					* 0.33 + (income - bracket5) * 0.35;

		// Display the result
		System.out.println("Tax is " + (int) (tax * 100) / 100.0);
	}
}