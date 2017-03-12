/**
 * 
 * Credit Card Number Validator
 * 
 * This program will check the entered credit card number
 * and confirm whether it is a valid credit card number.
 * 
 * @author  Nicholas Robertson
 * Grand Canyon University
 * 
 */

import java.util.Scanner;

public class CreditCardNumberValidator
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter your credit card number: ");

		long creditCardNumber = input.nextLong();

		System.out.println(isValid(creditCardNumber));
	}

	/** Return true if the card number is valid */
	public static boolean isValid(long creditCardNumber)
	{
		int sumOfEvenAndOdd = sumOfDoubleEvenPlace(creditCardNumber) + sumOfOddPlace(creditCardNumber);

		if (isPrefixValid(creditCardNumber) == false)
		{
			return false;
		}

		if (sumOfEvenAndOdd % 10 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean isPrefixValid(long creditCardNumber)
	{
		// prefixMatched(creditCardNumber, numberOfDigits, startsWith)
		// Check Visa
		if (prefixMatched(creditCardNumber, 1, 4))
		{
			return true;
		}

		// Check Mastercard
		else if (prefixMatched(creditCardNumber, 1, 5))
		{
			return true;
		}

		// Check American Express
		else if (prefixMatched(creditCardNumber, 2, 37))
		{
			return true;
		}

		// Check Discover
		else if (prefixMatched(creditCardNumber, 1, 6))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long creditCardNumber)
	{
		String numberString = Long.toString(creditCardNumber);
		int numberToDouble = 0;
		int totalDoubledNumbers = 0;

		// Start from right and move left
		// Begin with second to last number
		// Then move two to the left each iteration
		for (int i = getSize(creditCardNumber) - 2; i > -1; i -= 2)
		{
			numberToDouble = Character.getNumericValue(numberString.charAt(i));
			numberToDouble *= 2;
			totalDoubledNumbers += getDigit(numberToDouble);
		}
		return totalDoubledNumbers;
	}

	/**
	 * Return this number if it is a single digit, otherwise, return the sum of
	 * the two digits
	 */
	public static int getDigit(int number)
	{
		if (number < 10)
		{
			return number;
		}
		else
		{
			String numberString = Integer.toString(number);

			int newNumber = Character.getNumericValue(numberString.charAt(0))
					+ Character.getNumericValue(numberString.charAt(1));

			return newNumber;
		}
	}

	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long creditCardNumber)
	{
		String numberString = Long.toString(creditCardNumber);
		int totalOddNumbers = 0;

		// Start from right and move left
		// Begin with last number
		// Then move two to the left each iteration
		for (int i = getSize(creditCardNumber) - 1; i > -1; i -= 2)
		{
			totalOddNumbers += Character.getNumericValue(numberString.charAt(i));
		}

		return totalOddNumbers;
	}

	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d, int k)
	{
		if (getPrefix(number, d) == k)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/** Return the number of digits in d */
	public static int getSize(long d)
	{
		return Long.toString(d).length();
	}

	/**
	 * Return the first k number of digits from number. If the number of digits
	 * in number is less than k, return number.
	 */
	public static long getPrefix(long number, int k)
	{
		String numberString = Long.toString(number);
		String prefixString = "";

		// Check if credit card number has fewer digits than k
		if (getSize(number) < k)
		{
			return number;
		}

		// Build prefix string
		for (int i = 0; i < k; i++)
		{
			prefixString += numberString.charAt(i);
		}

		long prefixNumber = Long.parseLong(prefixString);

		return prefixNumber;
	}

}
