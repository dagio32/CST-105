/**
 * 
 * Perfect Square
 * 
 * This program accepts an input integer from the user and calculates the smallest integer
 * in which m * n is a perfect square.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

import java.util.Scanner;

public class PerfectSquare
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);

		// Accept user input for array of characters
		System.out.println("Enter an integer m: ");

		// Assign inputM based on user input
		// Call method that checks for valid input
		int inputM = setInt(input);

		// Display result
		System.out.println("The smallest number n for m * n to be a perfect square is " + findN(inputM));
		System.out.println("m * n is " + inputM * findN(inputM));
	}

	private static int setInt(Scanner input)
	{
		while (!input.hasNextInt())
		{
			System.out.println("Error:  Not an integer.  Try again.");
			input.next();
		}
		return input.nextInt();
	}

	private static int findN(int m)
	{
		int n = 0;
		int originalM = m;

		// Never becomes true, just there to keep loop going
		boolean isFound = false;

		while (!isFound)
		{
			n++;

			// To reset m for each iteration, use original value of m and multiply by n
			m = originalM * n;

			// Check for perfect square
			int squareRoot = (int)Math.sqrt(m);
			
			if (squareRoot * squareRoot == m)
			{
				return n;
			}
		}

		// Should never reach this point but here to satisfy compiler
		return -1;
	}

}
