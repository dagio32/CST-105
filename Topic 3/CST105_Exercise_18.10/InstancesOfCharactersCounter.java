import java.util.Scanner;

/**
 * 
 * Instances of Characters Counter
 * 
 * This program will accept a string and a character and count the occurrences of that character in the string.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

public class InstancesOfCharactersCounter
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);

		// Accept user input for string
		System.out.println("Enter a string: ");
		String inputString = input.nextLine();

		// Accept user input for character
		System.out.println("Enter a character: ");
		String inputCharString = input.next();
		char inputChar = inputCharString.charAt(0);

		// Calculate occurrences of the character
		int totalCharCount = count(inputString, inputChar);

		// Adjust for plural cases
		String stringIs = " is ";
		String stringOccurrence = " occurrence ";

		if (totalCharCount != 1)
		{
			stringIs = " are ";
			stringOccurrence = " occurrences ";
		}

		// Display result
		System.out.println("There" + stringIs + totalCharCount + stringOccurrence + "of the letter \"" + inputChar
				+ "\" in the word \"" + inputString + "\".");
	}

	public static int count(String str, char a)
	{
		// Convert to lower case to remove case-sensitivity
		str = str.toLowerCase();
		a = Character.toLowerCase(a);

		// Initialize charCount to avoid null value
		int charCount = 0;

		if (str.length() > 0)
		{
			// Check for character match for first character in string
			if (str.charAt(0) == a)
			{
				charCount++;
			}

			// Remove the beginning letter from the string
			// Eventually the length will be 0 and recursion will stop
			String newString = removeLetter(str);

			// Count will return either a 1 or 0
			charCount += count(newString, a);
		}
		return charCount;
	}

	public static String removeLetter(String str)
	{
		String newString = "";

		for (int a = 0; a < str.length() - 1; a++)
		{
			newString += str.charAt(a + 1);
		}

		return newString;
	}
}
