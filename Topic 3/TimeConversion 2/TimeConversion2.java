/**
 * 
 * Time Conversion Application Part 2
 * 
 * This program will accept a decimal time input 
 * from the user and convert it to hours and minutes.
 * 
 * @author  Nicholas Robertson
 * Grand Canyon University
 * 
 */

import java.util.Scanner;

public class TimeConversion2
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);

		// Accept inputs
		printUserPrompt();

		// Loop until a double value is entered
		while (input.hasNextDouble() == false)
		{
			System.out.println("Error.  Try again.");
			input.next();
		}

		double timeInput = input.nextDouble();

		// Parse the timeInput String and convert from 24-hour to 12-hour format
		String convertTime = "";

		// Methods to parse the hours and minutes from the double value
		int totalHours = findHours(timeInput);
		int totalMinutes = findMinutes(timeInput);

		String hoursLabel = " hour";
		String minutesLabel = " minute";

		// Add plural label if number is other than 1
		if (totalHours != 1)
		{
			hoursLabel += "s";
		}
		if (totalMinutes != 1)
		{
			minutesLabel += "s";
		}

		// Display result
		System.out.println(totalHours + hoursLabel + " " + totalMinutes + minutesLabel);
	}

	public static void printUserPrompt()
	{
		System.out.println("Enter a time in decimals.");
		System.out.println("For example, 5.5 will convert to 5 hours 30 minutes:");
	}

	public static int findHours(double timeInput)
	{
		// 10.xx = 10 hours
		int totalHours = (int)timeInput / 1;
		return totalHours;
	}

	public static int findMinutes(double timeInput)
	{
		// Find hours
		int totalHours = findHours(timeInput);

		// Remove hours from the time
		timeInput -= totalHours;

		double totalMinutes = timeInput * 60;
		return (int)totalMinutes;
	}
}
