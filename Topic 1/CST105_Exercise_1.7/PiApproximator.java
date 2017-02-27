
public class PiApproximator
{

	public static void main(String[] args) 
	{
		double operation1 = 4 * (1 - (1.0 / 3) + (1.0 / 5) - (1.0 / 7) + (1.0 / 9) - (1.0 / 11));
		double operation2 = 4 * (1 - (1.0 / 3) + (1.0 / 5) - (1.0 / 7) + (1.0 / 9) - (1.0 / 11) + (1.0 / 13));
		
		System.out.println("Pi Estimator");
		System.out.println("Estimate 1: " + operation1);
		System.out.println("Estimate 2: " + operation2);
	}

}
