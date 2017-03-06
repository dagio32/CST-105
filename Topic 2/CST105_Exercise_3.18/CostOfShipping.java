//Created by Nicholas Robertson for Grand Canyon University

import java.util.Scanner;
import java.util.Random;

public class CostOfShipping {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		//User inputs package weight
		System.out.println("Enter the weight of the package: ");
		double packageWeight = input.nextDouble();

		// Exit program if package exceeds weight limit of 20
		// or if weight is less than or equal to 0
		if (packageWeight > 20 || packageWeight <= 0) {
			System.out.println("The package cannot be shipped.");
			System.exit(0);
		}

		double multiplier = 0;
		
		//All other scenarios
		if (packageWeight > 10)
			multiplier = 10.5;
		else if (packageWeight > 3)
			multiplier = 8.5;
		else if (packageWeight > 1)
			multiplier = 5.5;
		else if (packageWeight > 0)
			multiplier = 3.5;
		
		//Calculate cost of shipping
		double costOfShipping = packageWeight * multiplier;
		
		//Print cost and format for $ currency.
		System.out.printf("Cost of shipping is $%.2f.%n", costOfShipping);
	}
}