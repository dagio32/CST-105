/**
 * 
 * Great Circle Distance Calculator
 * 
 * This program will accept coordinates from the user
 * and calculate the distance between the two points.
 * 
 * @author  Nicholas Robertson
 * Grand Canyon University
 * 
*/

import java.util.Scanner;

public class GreatCircleDistance 
{

	public static void main(String[] args) 
	{
		//Instantiate Scanner named input
		Scanner input = new Scanner(System.in);
		
		System.out.println("This program will calculate the distance between two points on Earth.");
		System.out.println("When entering the coordinates, separate the latitude and longitude by a space or a separate line.");
		
		//Accept inputs
		System.out.println("Enter the latitude and longitude point 1: ");
		double point1XCoord = input.nextDouble();
		double point1YCoord = input.nextDouble();
		System.out.println("Enter the latitude and longitude point 2: ");
		double point2XCoord = input.nextDouble();
		double point2YCoord = input.nextDouble();
		
		//Convert points to radians
		point1XCoord = Math.toRadians(point1XCoord);
		point1YCoord = Math.toRadians(point1YCoord);
		point2XCoord = Math.toRadians(point2XCoord);
		point2YCoord = Math.toRadians(point2YCoord);
		
		//Calculate the distance between the two points
		double distance = calculateDistance(point1XCoord, point1YCoord, point2XCoord, point2YCoord); 
		
		//Display result
		System.out.println("The distance between the two points is " + distance + " kilometers.");
	}
	
	public static double calculateDistance(double point1XCoord, double point1YCoord, double point2XCoord, double point2YCoord)
	{
		//Average earth radius in kilometers
		double radius = 6371.01;
		
		//Formula:
		//d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))
		double distance = radius * Math.acos(Math.sin(point1XCoord) * Math.sin(point2XCoord) + 
				Math.cos(point1XCoord) * Math.cos(point2XCoord) *
				Math.cos(point1YCoord - point2YCoord));
		
		return distance;
	}

}
