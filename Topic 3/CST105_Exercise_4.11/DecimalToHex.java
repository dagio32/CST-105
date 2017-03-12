/**
 * 
 * Decimal to Hex Converter
 * 
 * This program will accept a number from 0 to 15 from the user
 * and convert it to a hexadecimal value.
 * 
 * @author  Nicholas Robertson
 * Grand Canyon University
 * 
*/

import java.util.Scanner;

public class DecimalToHex 
{
	
	public static void main(String[] args) 
	{
		System.out.println("Enter a decimal value (0 to 15): ");
		
		int inputInteger = acceptInput();
		
		String hexValue = Integer.toHexString(inputInteger).toUpperCase();
		
		//Display result
		System.out.println("The hex value is " + hexValue + ".");		
		
	}
	
	public static int acceptInput()
	{
		//Instantiate Scanner named input
		Scanner input = new Scanner(System.in);
		
		//inputInteger is used to test the value of the input
		int inputInteger = -1;
		
		//validInput stays as false and is used to keep the while loop going
		//Does not change to true, as this method is only used to return an int
		boolean validInput = false;
		
		while (validInput == false) 
		{
			if (input.hasNextInt())
			{
				inputInteger = input.nextInt();
				if (inputInteger  >= 0 && inputInteger <= 15)
				{
					//Valid input
					//Integer value and between 0 and 15
					return inputInteger;
				}
			}
			
			//Error message and go through another iteration
			System.out.println("Invalid input.  Please enter an integer between 0 and 15.");
			input.nextLine();
		}
		
		//Execution should never reach here, but is necessary to satisfy the compiler
		return inputInteger;
	}
	
}
