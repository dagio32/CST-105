/**
 * 
 * Display Calendars
 * 
 * This program accepts a year and month input from the user, then
 * displays a calendar of the given year and month.  The user may
 * choose to skip entering a value, in which case the current month
 * or year will be used.
 * 
 * Revised version of PrintCalendar.java from Listing 6.12 in the book
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

import java.util.Scanner;
import java.text.DateFormatSymbols;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PrintCalendar
{
	/** Main method */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter year
		System.out.print("Enter full year (e.g., 2012), -1 to skip: ");
		int year = input.nextInt();

		// Prompt the user to enter month
		System.out.print("Enter month as a number between 1 and 12, -1 to skip: ");
		int month = input.nextInt();

		// Check for skips
		if (year == -1)
		{
			year = getCurrentYear();
		}
		if (month == -1)
		{
			month = getCurrentMonth();
		}

		GregorianCalendar gCalendar = new GregorianCalendar(year, month - 1, 1);

		// Print calendar for the month of the year
		printMonth(gCalendar);
	}

	public static int getCurrentMonth()
	{
		// Set current date
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		// Manually entered month is not zero-based
		// For consistency we must return zero-based Calendar.MONTH + 1
		return calendar.get(Calendar.MONTH) + 1;
	}

	public static int getCurrentYear()
	{
		// Set current date
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar.get(Calendar.YEAR);
	}

	/** Print the calendar for a month in a year */
	public static void printMonth(GregorianCalendar gCalendar)
	{
		// Print the headings of the calendar
		printMonthTitle(gCalendar);

		// Print the body of the calendar
		printMonthBody(gCalendar);
	}

	/** Print the month title, e.g., March 2012 */
	public static void printMonthTitle(GregorianCalendar gCalendar)
	{
		System.out.println(" " + getMonthName(gCalendar) + " " + gCalendar.get(GregorianCalendar.YEAR));
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}

	/** Get the English name for the month */
	public static String getMonthName(GregorianCalendar gCalendar)
	{
		String monthName = new DateFormatSymbols().getMonths()[gCalendar.get(GregorianCalendar.MONTH)];

		return monthName;
	}

	/** Print month body */
	public static void printMonthBody(GregorianCalendar gCalendar)
	{
		// Get start day of the week for the first date in the month
		int startDay = getStartDay(gCalendar);

		// Get number of days in the month
		int numberOfDaysInMonth = getNumberOfDaysInMonth(gCalendar);

		// Pad space before the first day of the month
		int i = 0;
		for (i = 0; i < startDay; i++)
			System.out.print("    ");

		for (i = 1; i <= numberOfDaysInMonth; i++)
		{
			System.out.printf("%4d", i);

			if ((i + startDay) % 7 == 0)
				System.out.println();
		}

		System.out.println();
	}

	/** Get the start day of month/1/year */
	public static int getStartDay(GregorianCalendar gCalendar)
	{
		YearMonth yearMonth = YearMonth.of(gCalendar.get(GregorianCalendar.YEAR),
				gCalendar.get(GregorianCalendar.MONTH) + 1);
		int startDay = yearMonth.atDay(1).getDayOfWeek().getValue();
		
		// To correct for months that begin on Sunday
		if (startDay == 7)
			startDay = 0;
		
		return startDay;
	}

	/** Get the number of days in a month */
	public static int getNumberOfDaysInMonth(GregorianCalendar gCalendar)
	{
		return gCalendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
	}

	/** Determine if it is a leap year */
	public static boolean isLeapYear(GregorianCalendar gCalendar)
	{
		return gCalendar.isLeapYear(gCalendar.get(GregorianCalendar.YEAR));
	}
}