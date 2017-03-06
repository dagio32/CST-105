//Created by Nicholas Robertson for Grand Canyon University

import java.util.Scanner;
import java.util.Random;

public class LogicalOperators {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		System.out.println("This application will accept an integer and determine whether it is divisible by 5, 6, or both."); 		
		
		System.out.print("Enter an integer: ");
		int inputInteger = input.nextInt();
		
		boolean divisibleByFive = false;
		boolean divisibleBySix = false;
		boolean divisibleByBoth = false;
		boolean divisibleByEither = false;
		boolean divisibleByOnlyOne = false;
		
		if (inputInteger % 5 == 0)
		{
			divisibleByFive = true;
		}
		
		if (inputInteger % 6 == 0)
		{
			divisibleBySix = true;
		}

		if (divisibleByFive && divisibleBySix)
		{
			divisibleByBoth = true;
		}
		
		if (divisibleByFive || divisibleBySix)
		{

			divisibleByEither = true;
		}
		
		if (divisibleByFive ^ divisibleBySix)
		{
			divisibleByOnlyOne = true;
		}
		
		System.out.println("Is " + inputInteger + " divisible by 5 and 6? " + divisibleByBoth);
		System.out.println("Is " + inputInteger + " divisible by 5 or 6? " + divisibleByEither);
		System.out.println("Is " + inputInteger + " divisible by 5 or 6, but not both? " + divisibleByOnlyOne);
	}
}