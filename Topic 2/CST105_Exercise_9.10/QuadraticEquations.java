//Created by Nicholas Robertson for Grand Canyon University

/*
9.10 (Algebra: quadratic equations) Design a class named QuadraticEquation for
a quadratic equation ax2 + bx + c = 0. The class contains:
* Private data fields a, b, and c that represent three coefficients.
* A constructor for the arguments for a, b, and c.
* Three getter methods for a, b, and c.
* A method named getDiscriminant() that returns the discriminant, which is b2 - 4ac.
* The methods named getRoot1() and getRoot2() for returning two roots of the equation:
r1 = (-b + SQRT((b^2 - 4ac)) / 2a)
and
r2 = (-b - SQRT((b^2 - 4ac)) /2a)

These methods are useful only if the discriminant is nonnegative. Let these methods
return 0 if the discriminant is negative.
Draw the UML diagram for the class and then implement the class. Write a test
program that prompts the user to enter values for a, b, and c and displays the result
based on the discriminant. If the discriminant is positive, display the two roots. If
the discriminant is 0, display the one root. Otherwise, display “The equation has
no roots.” See Programming Exercise 3.1 for sample runs.
*/

import java.util.Scanner;

public class QuadraticEquations
{

	public static void main(String[] args) 
	{
		//Create input scanner			
		Scanner input = new Scanner(System.in);
		
		System.out.println("Quadratic Equations Calculator");
		
		System.out.println("Please enter values for a, b, and c: ");
		
		//Assign temporary values to a, b, and c
		double tempA = input.nextDouble();
		double tempB = input.nextDouble();
		double tempC = input.nextDouble();
		
		//Pass in the temporary values to the QuadraticEquations instance called equation
		QuadraticEquations equation = new QuadraticEquations(tempA, tempB, tempC);
		
		//Check discriminant to determine how many roots to display
		if (equation.getDiscriminant() > 0)
		{
			System.out.println("This equation has two roots: " + equation.getRoot1() + " and " + equation.getRoot2());
		}
		else if (equation.getDiscriminant() == 0)
		{
			System.out.println("This equation has one root: " + equation.getRoot1());
		}
		else
		{
			System.out.println("This equation has no real roots");
		}
	}
	
	private double A;
	private double B;
	private double C;
	
	public QuadraticEquations(double a, double b, double c)
	{
		A = a;
		B = b;
		C = c;
	}
	
	//Getter methods for each variable
	public double getA()
	{
		return A;
	}
	
	public double getB()
	{
		return B;
	}
	
	public double getC()
	{
		return C;
	}
	
	//Discriminant = b^2 - 4ac
	public double getDiscriminant()
	{
		double discriminant = Math.pow(B, 2) - (4 * A * C);
		return discriminant;
	}
	
	//root1 = (-b + SQRT((b^2 - 4ac)) / 2a)
	public double getRoot1()
	{
		double root1 = (-(B) + Math.sqrt(getDiscriminant())) / (2 * A);
		
		//If discriminant is less than 0, return a 0
		//This indicates no root
		if (getDiscriminant() < 0)
			return 0;
		
		return root1;
	}
	
	//root2 = (-b - SQRT((b^2 - 4ac)) / 2a)
	public double getRoot2()
	{
		double root2 = (-(B) - Math.sqrt(getDiscriminant())) / (2 * A);
		
		//If discriminant is less than 0, return a 0		
		//This indicates no root
		if (getDiscriminant() < 0)
			return 0;
		
		return root2;
	}
}