//Created by Nicholas Robertson for Grand Canyon University

public class PrimeNumbers
{
	public static void main(String[] args)
	{
		System.out.println("This application will display the first 50 prime numbers in descending order.");
		
		GenericStack<String> stack = new GenericStack<>();
		
		//229 is the 50th prime number
		//End loop at 2, as 1 is not a prime number
		for (int i = 230; i >= 2; i --)
		{	
			if (CheckIfPrime(i) == true)
			{
				stack.push(i + "");
			}
		}
		
		System.out.println(stack);
	}
	
	public static boolean CheckIfPrime(int number)
	{
		//Start at 2, as every number is divisible by 1
		//End the loop one before the actual number so it does not divide by itself
		for (int i = 2; i < number; i++)
		{
			if (number % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}