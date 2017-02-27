import java.util.Scanner;


public class GreatCircleDistance 
{
	public static void main(String[] args)
	{	
		//Average earth radius in kilometers
		double radius = 6371.01;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("This program will calculate the distance between two points on Earth.");
		System.out.println("When entering the coordinates, be sure to enter them one at a time and on separate lines.");
		
		System.out.println("Enter the latitude (x) of point 1: ");
		double point1XCoord = input.nextDouble();
		System.out.println("Enter the longitude (y) of point 1: ");
		double point1YCoord = input.nextDouble();
		System.out.println("Enter the latitude (x) of point 2: ");
		double point2XCoord = input.nextDouble();
		System.out.println("Enter the longitude (y) of point 2: ");
		double point2YCoord = input.nextDouble();
		
		//Convert all degrees to radians
		point1XCoord = Math.toRadians(point1XCoord);
		point1YCoord = Math.toRadians(point1YCoord);
		point2XCoord = Math.toRadians(point2XCoord);
		point2YCoord = Math.toRadians(point2YCoord);
		
		//Formula:
		//d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))
		double distance = radius * Math.acos(Math.sin(point1XCoord) * Math.sin(point2XCoord) + 
				Math.cos(point1XCoord) * Math.cos(point2XCoord) *
				Math.cos(point1YCoord - point2YCoord));
		
		System.out.println("The distance between the two points is " + distance + " kilometers.");
	}
}
