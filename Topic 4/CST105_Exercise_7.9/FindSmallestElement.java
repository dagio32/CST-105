/**
 * 
 * Find the smallest element
 * 
 * This program will accept ten numbers from the user and
 * display the minimum value.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

import java.util.Scanner;

public class FindSmallestElement
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);
		
		// Display instructions
		System.out.println("Enter ten numbers: ");
		
		// Create array to store values
		double[] doublesArray = new double[10];
		
		// Accept 10 numbers from user
		for (int i = 0; i < doublesArray.length; i++)
		{
			// Error message for non-double values
			while (!input.hasNextDouble())
			{
				System.out.println("Error: Try entering a number.");
				input.next();
			}
			
			// Assign value to element i
			doublesArray[i] = input.nextDouble();
		}
		
		// Display result
		System.out.println("The minimum number is: " + findSmallestElement(doublesArray));
	}
	
	private static double findSmallestElement(double[] doublesArray)
	{
		double minimumDouble = doublesArray[0];
		
		for (int i = 0; i < doublesArray.length; i++)
		{
			if (doublesArray[i] < minimumDouble)
			{
				minimumDouble = doublesArray[i];
			}
		}
		
		return minimumDouble;
	}

}
