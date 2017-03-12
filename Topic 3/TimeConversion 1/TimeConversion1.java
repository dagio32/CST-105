/**
 * 
 * Time Conversion Application Part 1
 * 
 * This program will accept a 24-hour time input 
 * from the user and convert it to a 12-hour format.
 * 
 * @author  Nicholas Robertson
 * Grand Canyon University
 * 
 */

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeConversion1
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);

		// Accept inputs
		printUserPrompt();
		String timeInput = input.nextLine();

		// Parse the timeInput String and convert from 24-hour to 12-hour format
		String convertTime = "";

		// To keep while loop going until valid input is entered
		boolean isSuccessful = false;

		while (isSuccessful == false)
		{
			try
			{
				// Parse the user input and convert from 24-hour to 12-hour time format
				convertTime = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern("HH:mm")).format(
						DateTimeFormatter.ofPattern("hh:mm a"));
				isSuccessful = true;
			}
			catch (Exception e)
			{
				// Print error message and retry input
				System.out.println("\r\n-Error-\r\n");
				printUserPrompt();
				timeInput = input.nextLine();
			}
		}
		// Display result
		System.out.println(convertTime);
	}

	public static void printUserPrompt()
	{
		System.out.println("Enter a time using the 24-hour format.");
		System.out.println("Must be in form of HH:mm (examples: 05:17 or 19:08):");
	}
}
