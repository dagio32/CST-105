import java.util.Scanner;

/**
 * 
 * String Permutation
 * 
 * This program will accept a string and display the permutation
 * 
 * For example, for the string "abc", the permutation is:
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

public class StringPermutation
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);

		// Accept user input for string
		System.out.println("Enter a string: ");
		String inputString = input.nextLine();

		// Display the permutation of the string
		displayPermutation(inputString);
	}

	public static void displayPermutation(String s)
	{
		displayPermutation("", s);
	}

	public static void displayPermutation(String s1, String s2)
	{
		// Base case
		if (s2.length() == 0)
		{
			// Once all chars moved from s2 to s1, display word
			System.out.println(s1);
		}
		else
		{
			for (int i = 0; i < s2.length(); i++)
			{
				// Concat new s1
				String newS1 = s1 + s2.charAt(i);

				// Concat new s2
				String beginSubString = s2.substring(0, i);
				String endSubString = s2.substring(i + 1, s2.length());
				String newS2 = beginSubString + endSubString;

				// Eventually all chars moved from s2 to s1
				displayPermutation(newS1, newS2);
			}
		}
	}
}
