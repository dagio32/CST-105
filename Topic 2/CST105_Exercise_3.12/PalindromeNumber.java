//Created by Nicholas Robertson for Grand Canyon University

import java.util.Scanner;

public class PalindromeNumber {
	public static void main(String[] args) {
		//Create input scanner			
		Scanner input = new Scanner(System.in);
		
		System.out.println("This program will determine if the entered number is a palindrome number.");
		
		System.out.println("Enter a three-digit number: ");
		int inputNumber = input.nextInt();
		
		//Check for out of range data (larger or smaller than three digits)
		if (inputNumber < 100 || inputNumber > 999)
		{
			System.out.println("Invalid number entered.  Exiting program.");
			System.exit(1);
		}
		
		//Determine if palindrome
		//If firstDigit = lastDigit, then palindrome = true 
		double firstDigit = inputNumber * .01;
		double lastDigit = inputNumber % 10;
		
		//Cast as ints, as the doubles will not be exact even if equal
		if ((int)firstDigit == (int)lastDigit)
		{
			System.out.println(inputNumber + " is a palindrome");
		}
		else
		{
			System.out.println(inputNumber + " is not a palindrome");
		}
	}
}
