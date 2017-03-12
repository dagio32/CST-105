/**
 * 
 * Display Characters
 * 
 * This program will print all of the characters between '1' and 'Z'.
 * 
 * @author  Nicholas Robertson
 * Grand Canyon University
 * 
 */

import java.util.Scanner;

public class DisplayCharacters
{

	public static void main(String[] args)
	{
		char ch1 = '1';
		char ch2 = 'Z';
		int numbersPerLine = 10;
		
		printChars(ch1, ch2, numbersPerLine);
	}

	public static void printChars(char ch1, char ch2, int numberPerLine)
	{
		//Will keep track of numbersPerLine
		int lineCounter = 0;
		
		for (int i = (int)ch1; i <= (int)ch2; i++)
		{
			System.out.print((char)i + " ");
			lineCounter++;
			
			//Add new line once lineCounter has reached numbersPerLine
			if (lineCounter == numberPerLine)
			{
				System.out.print("\r\n");
				
				//Reset lineCounter
				lineCounter = 0;
			}
		}
	}

}
