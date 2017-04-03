/**
 * 
 * Octagon Class
 * 
 * The Octagon class extends the abstract GeometricObject class and
 * implements the Comparable and Cloneable interfaces.  Instances of
 * the Octagon should be able to be cloned as well as compared to
 * each other.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable
{
	// Main method for testing
	public static void main(String[] args)
	{
		// Instantiate octagon with side size of 5
		Octagon octagon1 = new Octagon(5);

		// Print information
		System.out.println("Size of sides: " + octagon1.getSideSize());
		System.out.println("Area: " + octagon1.getArea());
		System.out.println("Perimeter: " + octagon1.getPerimeter());

		// Clone octagon1 to octagon2
		Octagon octagon2 = (Octagon)octagon1.clone();
		
		// Print result of clone
		System.out.println("octagon1 compared to octagon2: " + octagon1.compareTo(octagon2));
	}

	//
	// Class fields and methods
	//
	private double sideSize;

	public Octagon()
	{
		sideSize = 0;
	}

	public Octagon(double Side)
	{
		sideSize = Side;
	}

	public double getSideSize()
	{
		return sideSize;
	}

	public double getArea()
	{
		return (2 + 4 / Math.sqrt(2)) * sideSize * sideSize;
	}

	public double getPerimeter()
	{
		return sideSize * 8;
	}

	// Comparable implementation
	@Override
	public int compareTo(Octagon o)
	{
		if (getArea() > o.getArea())
			return 1;
		else if (getArea() < o.getArea())
			return -1;
		else
			return 0;
	}

	// Cloneable implementation
	@Override
	public Object clone()
	{
		try
		{
			Octagon octagonClone = (Octagon)super.clone();
			return octagonClone;
		}
		catch (CloneNotSupportedException ex)
		{
			return null;
		}
	}

}