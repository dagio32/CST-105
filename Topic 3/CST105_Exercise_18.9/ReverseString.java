import java.util.Scanner;

/**
 * 
 * Reverse String
 * 
 * This program will accept a string and reverse its characters using recursion.
 * 
 * @author Nicholas Robertson Grand Canyon University
 * 
 */

public class ReverseString
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);

		// Accept input
		System.out.println("Enter a word: ");
		String inputString = input.nextLine();

		// Display result
		System.out.print(inputString + " in reverse is ");
		reverseDisplay(inputString);
	}

	public static void reverseDisplay(String value)
	{
		// Base case
		if (value.length() == 0)
		{
			return;
		}
		else
		{
			// Print the last letter of value
			System.out.print(value.charAt(value.length() - 1));

			// Remove the last letter of value
			value = value.substring(0, value.length() - 1);

			// Call method with the shortened "value"
			reverseDisplay(value);
		}
	}
	
	// Original method, found a more efficient way
	/*
	public static void reverseDisplay(String value)
	{
		if (value.length() > 0)
		{
			// newValue is the same as value minus the last letter
			String newValue = value.substring(0, value.length() - 1);

			// Print the last letter of the word
			if (newValue.length() > -1)
			{
				System.out.print(value.charAt(newValue.length()));
			}
			else
			{
				return;
			}

			reverseDisplay(newValue);
		}
	}
	*/
	
}
