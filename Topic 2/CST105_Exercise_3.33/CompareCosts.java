//Created by Nicholas Robertson for Grand Canyon University

import java.util.Scanner;
import java.util.Random;

public class CompareCosts {
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		System.out.println("This application will accept the weight and price for two packages and determine the better deal."); 		
		
		System.out.print("Enter weight and price for package 1: ");
		double packageOneWeight = input.nextDouble();
		double packageOnePrice = input.nextDouble();
		
		System.out.print("Enter weight and price for package 2: ");
		double packageTwoWeight = input.nextDouble();
		double packageTwoPrice = input.nextDouble();
		
		//Determine price per pound
		//Lower number means better price
		double packageOnePricePerPound = packageOnePrice / packageOneWeight;
		double packageTwoPricePerPound = packageTwoPrice / packageTwoWeight;
		
		//Display which is a better deal
		if (packageOnePricePerPound == packageTwoPricePerPound)
		{
			System.out.println("Both packages have the same price.");
		}
		else if (packageOnePricePerPound < packageTwoPricePerPound)
		{
			System.out.println("Package 1 has a better price.");
		}
		else
		{
			System.out.println("Package 2 has a better price.");
		}
	}
}