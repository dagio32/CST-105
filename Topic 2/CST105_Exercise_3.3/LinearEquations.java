//Created by Nicholas Robertson for Grand Canyon University

import java.util.Scanner;
import java.util.Random;

public class LinearEquations {
	public static void main(String[] args) {
		//Introduction
		System.out.println("This program will solve linear equations.  The equation is as follows:");
		System.out.println("ax + by = e\r\ncx + dy = f");
		System.out.println("Cramer's rule for solving linear equations:");
		System.out.println("x = (ed - bf) / (ad - bc)");
		System.out.println("y = (af - ec) / (ad - bc)");

		//Create the input scanner
		Scanner input = new Scanner(System.in);
		
		//Declare a through f and set to 0 by default
		double a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
		
		System.out.println("Enter a, b, c, d, e, f: ");
		
		//Take input of next six entered numbers
		a = input.nextDouble();
		b = input.nextDouble(); 
		c = input.nextDouble(); 
		d = input.nextDouble(); 
		e = input.nextDouble(); 
		f = input.nextDouble(); 
		
		//Calculate using Cramer's rule
		double x = ((e * d) - (b * f)) / ((a * d) - (b * c));
		double y = ((a * f) - (e * c))  / ((a * d) - (b * c));
		
		//Print results
		if (((a * d) - (b * c)) == 0)
		{
			System.out.println("The equation has no solution.");
			System.exit(1);
		}
		else
		{
			System.out.println("x is " + x + " and y is " + y);
		}
	}
}