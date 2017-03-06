//Created by Nicholas Robertson for Grand Canyon University

import java.util.Scanner;

public class FutureDates {
	public static void main(String[] args) {
		//Create input scanner			
		Scanner input = new Scanner(System.in);
		
		System.out.println("0 for Sunday, 1 for Monday, 6 for Saturday, etc.");
		
		System.out.println("Enter today's day: ");
		int numberTodaysDay = input.nextInt();
		
		String todaysDayName = "";
		
		switch (numberTodaysDay)
		{
		case 0:
			todaysDayName = "Sunday";
			break;
		case 1:
			todaysDayName = "Monday";
			break;
		case 2:
			todaysDayName = "Tuesday";
			break;
		case 3:
			todaysDayName = "Wednesday";
			break;
		case 4:
			todaysDayName = "Thursday";
			break;
		case 5:
			todaysDayName = "Friday";
			break;
		case 6:
			todaysDayName = "Saturday";
			break;	
		default:	
			System.out.println("Invalid day entered, closing application.");
			System.exit(1);
			break;
		}
		
		System.out.println("Enter the number of days elapsed since today: ");
		int numberDaysElapsed = input.nextInt();
		
		//Add days elapsed to today's day
		int numberFutureDay = numberTodaysDay + numberDaysElapsed;
		
		//Remainder will determine how many days beyond the initial day
		numberFutureDay %= 7;
		
		System.out.println(numberFutureDay);
		
		String futureDayName = "";
		switch (numberFutureDay)
		{
		case 0:
			futureDayName = "Sunday";
			break;
		case 1:
			futureDayName = "Monday";
			break;
		case 2:
			futureDayName = "Tuesday";
			break;
		case 3:
			futureDayName = "Wednesday";
			break;
		case 4:
			futureDayName = "Thursday";
			break;
		case 5:
			futureDayName = "Friday";
			break;
		case 6:
			futureDayName = "Saturday";
			break;	
		default:	
			System.out.println("Invalid day entered, closing application.");
			System.exit(1);
			break;
		}
		
		//Print answer
		System.out.println("Today is " + todaysDayName + " and the future day is " + futureDayName);
	}
}
