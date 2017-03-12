/**
 * 
 * Password Checker
 * 
 * This program will check an entered password for the following requirements:
 *   Must have at least 8 characters
 *   Must consist of only letters and digits
 *   Must contain at least two digits
 * 
 * @author  Nicholas Robertson
 * Grand Canyon University
 * 
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class PasswordChecker
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter your password: ");
		String enteredPassword = input.nextLine();

		if (validatePassword(enteredPassword))
		{
			System.out.println("Valid Password");
		}
		else
		{
			System.out.println("Invalid Password");
		}

	}

	public static boolean validatePassword(String enteredPassword)
	{
		// Password requirements
		int minimumCharacters = 8;
		int minimumDigits = 2;
		// Password also must contain only letters and digits

		// Will store the value of each character in the for loop
		char tempChar;

		// Will count the type of character as it's processed in the for loop
		int characterCounter = 0;
		int digitCounter = 0;

		for (int i = 0; i < enteredPassword.length(); i++)
		{
			tempChar = enteredPassword.charAt(i);

			if (isLetter(tempChar))
			{
				characterCounter++;
			}
			else if (isDigit(tempChar))
			{
				characterCounter++;
				digitCounter++;
			}
			else
			{
				// Not a letter or digit
				// Exit method and return false
				return false;
			}
		}

		// Check if minimum requirements are met
		if (characterCounter >= minimumCharacters && digitCounter >= minimumDigits)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean isDigit(char input)
	{
		// 0 - 9 are Unicode values 48-57
		if ((int)input >= 48 && (int)input <= 57)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean isLetter(char input)
	{
		// A - Z are Unicode values 65-90
		// a - z are Unicode values 97-122
		if (((int)input >= 65 && (int)input <= 90) || ((int)input >= 97 && (int)input <= 122))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
