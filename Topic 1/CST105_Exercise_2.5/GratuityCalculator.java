import java.util.Scanner;


public class GratuityCalculator 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the subtotal: ");
		double subtotal = input.nextDouble();
		System.out.println("Enter the gratuity rate: ");
		double gratuityRate = input.nextDouble();
		//Convert whole number to percentage
		gratuityRate *= .01;
		double tipAmount = subtotal * gratuityRate;
		double total = subtotal + tipAmount;
		System.out.println("The tip is $" + tipAmount + " and the total is $" + total);
	}
}
