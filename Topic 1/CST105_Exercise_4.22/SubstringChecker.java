import java.util.Scanner;

public class SubstringChecker 
{
	public static void main(String[] args)
	{	
		Scanner input = new Scanner(System.in);
		
		System.out.println("This program will compare two strings and see if the second string is " + 
		" a substring of the first string.");

		System.out.println("Enter string 1: ");
		String string1 = input.nextLine();
		System.out.println("Enter string 2: ");
		String string2 = input.nextLine();
		
		//Check for substring
		boolean isSubString = false;
		if (string1.indexOf(string2) != -1)
		{
			isSubString = true;
		}
		
		//Display results
		if(isSubString == true)
		{
			System.out.println(string2 + " is a substring of " + string1);
		}
		else
		{
			System.out.println(string2 + " is not a substring of " + string1);
		}		
	}
}
