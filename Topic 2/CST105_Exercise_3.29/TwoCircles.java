//Created by Nicholas Robertson for Grand Canyon University

import java.util.Scanner;
import java.util.Random;

public class TwoCircles {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);

		System.out.println("This application will accept the coordinates and radii of two circles and output the relationship between the two."); 		
		System.out.println("Separate input by spaces and do not use special characters other than a decimal.");
		
		System.out.print("Enter circle 1's center x-, y-coordinates, and radius: ");
		double circle1X = input.nextDouble();
		double circle1Y = input.nextDouble();
		double circle1Radius = input.nextDouble();
		
		System.out.print("Enter circle 2's center x-, y-coordinates, and radius: ");
		double circle2X = input.nextDouble();
		double circle2Y = input.nextDouble();
		double circle2Radius = input.nextDouble();
		
		//Distance formula = SQRT((x2 - x1)^2 + (y2 - y1)^2)
		double totalDistance = Math.sqrt(Math.pow(circle2X - circle1X, 2) + Math.pow(circle2Y - circle1Y, 2));
		
		double radiiSubtracted = Math.abs(circle1Radius - circle2Radius);
		double radiiAdded = circle1Radius + circle2Radius;
		
		System.out.println("Distance between the two centers is " + totalDistance);
		System.out.println("Math.abs(circle1Radius - circle2Radius) = " + radiiSubtracted);
		System.out.println("circle1Radius + circle2Radius = " + radiiAdded);
		
		//Check if circle2 is inside circle 1
		//This is true if totalDistance is <= radiiSubracted
		if (totalDistance <= radiiSubtracted)
		{
			System.out.println("Circle 2 is inside circle 1.");
		}
		else
		{
			System.out.println("Circle 2 is not inside circle 1.");
		}
		
		//Check if circle2 overlaps circle 1
		//This is true if totalDistance <= radiiAdded
		if (totalDistance <= radiiAdded)
		{
			System.out.println("Circle 2 overlaps circle 1.");
		}
		else
		{
			System.out.println("Circle 2 does not overlap circle 1.");
		}
	}
}