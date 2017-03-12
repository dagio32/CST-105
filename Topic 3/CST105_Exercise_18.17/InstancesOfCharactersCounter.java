import java.util.Scanner;

/**
 * 
 * Instances of Characters Counter
 * 
 * This program will accept a string and a character, build an array of characters from the string,
 * and count the occurrences of that character in the array of characters.
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

		// Accept user input for array of characters
		System.out.println("Enter a list of characters on one line: ");
		String inputString = input.nextLine();
		char[] inputCharArray = new char[inputString.length()];

		// Build the character array from the input string
		for (int a = 0; a < inputString.length(); a++)
		{
			inputCharArray[a] = inputString.charAt(a);
		}

		// Accept user input for character
		System.out.println("Enter a character: ");
		String inputCharString = input.next();
		char inputChar = inputCharString.charAt(0);

		// Calculate occurrences of the character
		int totalCharCount = count(inputCharArray, inputChar);

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
				+ "\" in the array of characters \"" + inputString + "\".");
	}

	public static int count(char[] chars, char ch)
	{
		int high = returnHigh(chars);
		return count(chars, ch, high);
	}

	public static int count(char[] chars, char ch, int high)
	{
		// Convert to lower case to remove case-sensitivity

		for (int i = 0; i < chars.length; i++)
		{
			chars[i] = Character.toLowerCase(chars[i]);
		}

		ch = Character.toLowerCase(ch);

		// Initialize charCount to avoid null value
		int charCount = 0;

		if (high > -1)
		{
			// Check for character match for first character in string
			if (chars[high] == ch)
			{
				charCount++;
			}

			// Count will return either a 1 or 0
			charCount += count(chars, ch, high - 1);
		}
		return charCount;
	}

	public static int returnHigh(char[] charArray)
	{
		return charArray.length - 1;
	}
}
