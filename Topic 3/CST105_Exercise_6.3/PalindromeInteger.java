/**
 * 
 * Palindrome Integers
 * 
 * This program will accept an integer from the user
 * and determine if it is a palindrome integer.
 * 
 * @author  Nicholas Robertson
 * Grand Canyon University
 * 
 */

import java.util.Scanner;

public class PalindromeInteger
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);

		printEnterInteger();

		int inputInteger;
		while (!input.hasNextInt())
		{
			System.out.println("Invalid input.");
			printEnterInteger();
			input.next();
		}
		//Valid input confirmed, assign inputInteger to the input integer
		inputInteger = input.nextInt();

		// Display result
		System.out.println("Is " + inputInteger + " a palindrome?");
		System.out.println(isPalindrome(inputInteger));
		System.out.println("The reverse of " + inputInteger + " is " + reverse(inputInteger) + ".");
	}

	public static void printEnterInteger()
	{
		System.out.println("Please enter an integer: ");
	}

	// Return the reversal of an integer, i.e., reverse(456) returns 654
	public static int reverse(int number)
	{
		//integerString will hold the characters of the parameter "number"
		String integerString = Integer.toString(number);
		
		//This string will be built one char at a time
		String reversedIntegerString = "";
		
		//Add the characters starting from the end of the integerString and going backwards 
		for (int i = 0; i < integerString.length(); i++)
		{
			reversedIntegerString += integerString.charAt(integerString.length() - i - 1);
		}
		
		//Parse the reversedIntegerString to an int
		int reversedInteger = Integer.parseInt(reversedIntegerString);
		
		return reversedInteger;
	}

	// Return true if number is a palindrome
	public static boolean isPalindrome(int number)
	{
		if (number == reverse(number))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
