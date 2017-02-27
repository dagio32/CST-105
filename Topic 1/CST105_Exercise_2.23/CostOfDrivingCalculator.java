import java.util.Scanner;


public class CostOfDrivingCalculator 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the driving distance: ");
		double drivingDistance = input.nextDouble();
		System.out.println("Enter the miles per gallon: ");
		double milesPerGallon = input.nextDouble();
		System.out.println("Enter the price per gallon: ");
		double pricePerGallon = input.nextDouble();
		double totalGallonsNeeded = drivingDistance / milesPerGallon;
		double totalCostOfDriving = totalGallonsNeeded * pricePerGallon;
		System.out.println("The total cost of driving is $" + totalCostOfDriving);
	}
}
