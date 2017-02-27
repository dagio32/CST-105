import java.util.Scanner;

public class DaysInMonth 
{
	public static void main(String[] args)
	{	
		int daysInMonth = 0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("This program will display the number of days in a particular month, " + 
		"depending on the year entered.");
		System.out.println("Use three-letter abbreviations for the month, " + 
		"such as Jan for January or Feb for February.  Be sure to capitalize the first letter.");
		
		System.out.println("Enter the year: ");
		int year = input.nextInt();
		input.nextLine();
		System.out.println("Enter the month: ");
		String month = input.nextLine();
		
		//Determine if leap year
		boolean leapYear = false;
		int calculateEveryFourYears = year % 4;
		int calculateEveryHundredYears = year % 100;
		int calculateEveryFourHundredYears = year % 400;
		//Remainder of 0 = leap year, except if divisible by 100 and not divisible by 400
		//Years 1700, 1800, and 1900 are -NOT- leap years, while 1600, 2000, and 2400 -ARE- leap years
		if (calculateEveryFourYears == 0)
		{
			if (calculateEveryHundredYears == 0 && calculateEveryFourHundredYears != 0)
			{
				leapYear = false;	
			}
			else
			{
				leapYear = true;	
			}
		}
		
		//Months with 31 days
		if (month.equals("Jan") || month.equals("Mar") || month.equals("May") || 
				month.equals("Jul") || month.equals("Aug") || month.equals("Oct") || 
				month.equals("Dec"))
		{
			daysInMonth = 31;
		}
		
		//Months with 30 days
		if (month.equals("Apr") || month.equals("Jun") || month.equals("Sep") || 
				month.equals("Nov"))
		{
			daysInMonth = 30;
		}
		
		//February
		if (month.equals("Feb"))
		{
			if (leapYear == false)
			{
				daysInMonth = 28;
			}
			else
			{
				daysInMonth = 29;			
			}
		}
		
		if (daysInMonth == 0)
		{
			System.out.println("Unable to determine an answer.  Did you mistype the month? " + 
		"Remember to abbreviate the month, such as Apr for April.");
		}
		else
		{
			System.out.println(month + " " + year + " has " + daysInMonth + " days.");
		}
		
	}
}
