
public class AverageSpeed
{
	public static void main(String[] args) 
	{
		double kilometers = 14.0;
		double miles = kilometers * 0.62;
		double minutes = 45.5;
		double hours = (60.0 / minutes);
		double mph = miles * hours;
		System.out.println(kilometers + " kilometers run in " + minutes + " minutes.");
		System.out.println("Miles per hour: " + mph);
	}
}
