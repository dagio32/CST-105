//Created by Nicholas Robertson for Grand Canyon University

import java.util.Random;

public class RandomMonth {
	public static void main(String[] args) {
		Random random = new Random();

		// Set month number between 1 and 12
		// nextInt(12) gives a 0-11, so need to add 1
		int monthNumber = random.nextInt(12) + 1;

		String monthName = "";

		switch (monthNumber) {
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "February";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		case 12:
			monthName = "December";
			break;
		}

		System.out.println("Randomly generating a month...");
		System.out.println("The chosen month is: " + monthName);
	}
}