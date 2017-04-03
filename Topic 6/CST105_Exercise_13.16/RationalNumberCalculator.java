/**
 * 
 * Rational Number Calculator
 * 
 * This programs accepts two rational numbers and an operand, then
 * performs the calculation.  For example, the string...
 * 1/4 + 2/4
 * ...will return 3/4
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

import java.util.Scanner;
import java.util.regex.Pattern;

public class RationalNumberCalculator
{
	// Main method for testing
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		// Prompt the user to enter operation
		System.out.println("Accepted operands:   +   -   *   \\");
		System.out.println("Use '/' to denote rational, e.g. 3/4");
		System.out.println("Use '\\' for dividing, e.g. 3/4 \\ 1/2\r\n");
		System.out.print("Enter rational calculation: ");
		
		String operation = input.nextLine();
		
		char operand = getOperand(operation);
		Rational r1 = getRational1(operation, operand);
		Rational r2 = getRational2(operation, operand);

		System.out.println(operation + " = " + getResult(r1, r2, operand));
	}

	//
	// Class fields and methods
	//
	public static Rational getRational1(String operation, char operand)
	{
		// Create an array of strings, splitting at all instances of /
		String[] parts = operation.split(Pattern.quote("/"));
		
		// Numerator is the first element in the array
		int numerator = Integer.parseInt(parts[0]);
		
		// Remove leading white space and operand
		parts[1] = removeOperand1(parts[1], operand);	
		int denominator = Integer.parseInt(parts[1]);
		
		Rational rationalTemp = new Rational(numerator, denominator);
		return rationalTemp;
	}
	
	public static Rational getRational2(String operation, char operand)
	{
		// Create an array of strings, splitting at all instances of /
		String[] parts = operation.split(Pattern.quote("/"));
		
		// Remove leading white space and operand
		parts[1] = removeOperand2(parts[1], operand);
		int numerator = Integer.parseInt(parts[1]);
		
		// Denominator is the last element in the array
		int denominator = Integer.parseInt(parts[2]);
		
		Rational rationalTemp = new Rational(numerator, denominator);
		return rationalTemp;
	}

	public static String removeOperand1(String string, char operand)
	{
		// Get a substring ending at the index before the operand
		String newString = string.substring(0, string.indexOf(operand) - 1);

		// Remove white space
		newString = newString.trim();

		return newString;
	}

	public static String removeOperand2(String string, char operand)
	{
		// Get a substring starting at the index after the operand
		String newString = string.substring(string.indexOf(operand) + 1, string.length());

		// Remove white space
		newString = newString.trim();
		
		return newString;
	}
	
	public static char getOperand(String operation)
	{
		String[] parts = operation.split(Pattern.quote("/"));
		
		if (parts[1].contains("+"))
		{
			return '+';
		}
		else if (parts[1].contains("-"))
		{
			return '-';
		}
		else if (parts[1].contains("*"))
		{
			return '*';
		}
		else if (parts[1].contains("\\"))
		{
			return '\\';
		}
		else
		{
			return ' ';	
		}
	}
	
	public static Rational getResult(Rational r1, Rational r2, char operand)
	{
		Rational rational = new Rational();
		// Determine the operator
		switch (operand)
		{
		case '+':
			rational = r1.add(r2);
			break;
		case '-':
			rational = r1.subtract(r2);
			break;
		case '*':
			rational = r1.multiply(r2);
			break;	
		// Divide by is usually '/', but is changed because it is being used in this program to denote a rational number
		case '\\':
			rational = r1.divide(r2);
		}
		return rational;
	}

}