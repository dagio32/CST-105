import java.util.Scanner;

/**
 * 
 * Fibonacci Numbers
 * 
 * This program will accept a user input index and display its corresponding
 * Fibonacci number.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

public class FibonacciNumbers
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);

		long f0 = 0;
		long f1 = 1;
		long fCurrent = 0;
		int fIndex = 0;

		System.out.println("Enter an index to display the corresponding Fibonacci number.");
		fIndex = input.nextInt();

		for (int i = 1; i <= fIndex; i++)
		{
			fCurrent = f0 + f1;
			f0 = f1;
			f1 = fCurrent;
		}
		System.out.println("The Fibonacci number at index " + fIndex + " is " + fCurrent);
	}

}
