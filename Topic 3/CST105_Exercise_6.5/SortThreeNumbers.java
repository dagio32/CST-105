/**
 * 
 * Sort Three Numbers
 * 
 * This program will accept three numbers from the user
 * and sort them in ascending order.
 * 
 * @author  Nicholas Robertson
 * Grand Canyon University
 * 
 */

import java.util.Scanner;

public class SortThreeNumbers
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);

		//Accept user input
		System.out.println("Please enter three numbers: ");
		double inputNumber1 = input.nextDouble();
		double inputNumber2 = input.nextDouble();
		double inputNumber3 = input.nextDouble();

		displaySortedNumbers(inputNumber1, inputNumber2, inputNumber3);
	}

	public static void displaySortedNumbers(double num1, double num2, double num3)
	{
		double[] doublesArray = new double[] {num1, num2, num3};
		double tempDouble;
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{		
				//Re-arrange the array in ascending order
				if (doublesArray[i] < doublesArray[j])
				{
					tempDouble = doublesArray[i];
					doublesArray[i] = doublesArray[j];
					doublesArray[j] = tempDouble;
				}
			}
		}
		
		//Display numbers in the array
		for (int i = 0; i < doublesArray.length; i++)
		{
			System.out.println(doublesArray[i]);
		}

	}

}
