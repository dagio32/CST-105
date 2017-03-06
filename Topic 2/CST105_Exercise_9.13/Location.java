//Created by Nicholas Robertson for Grand Canyon University

/*
9.13 (The Location class) Design a class named Location for locating a maximal
value and its location in a two-dimensional array. The class contains public data
fields row, column, and maxValue that store the maximal value and its indices
in a two-dimensional array with row and column as int types and maxValue as
a double type.

Write the following method that returns the location of the largest element in a
two-dimensional array:

public static Location locateLargest(double[][] a)

The return value is an instance of Location. Write a test program that prompts
the user to enter a two-dimensional array and displays the location of the largest
element in the array. Here is a sample run:

Enter the number of rows and columns in the array: 3 4
Enter the array:
23.5 35 2 10
4.5 3 45 3.5
35 44 5.5 9.6
The location of the largest element is 45 at (1, 2)
*/

import java.util.Scanner;

public class Location
{
	
	public static void main(String[] args) 
	{
		//Create input scanner			
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the number of rows and columns in the array: ");
		int rows = input.nextInt();
		int columns = input.nextInt();
		
		//Array containing double values
		double[][] doubleArray = new double[rows][columns];
		
		System.out.println("Enter the array: ");
		
		/*
		  Accepts values starting with the row number, then progressing through each column
		  After the column is done, go to the next row of input
		  
		  3 rows, 4 columns may look like:
	      2 5 8 10
		  9 2 4 8
		  14 1 4 3
		  
		  Max value is 14.0 at location (3, 1)
		  Row 3, column 1
		*/ 
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				doubleArray[i][j] = input.nextInt();
			}
		}
		
		//Create instance of Location
		Location location = new Location();
		
		//Assign location its variables (row, column, max value)
		location = locateLargest(doubleArray);
		
		//Display the results
		System.out.println("The location of the largest element is " + location.maxValue + 
				" at point (" + location.row + ", " + location.column + ")");
	}
	
	public int row;
	public int column;
	public double maxValue;
	
	public static Location locateLargest(double[][] theArray)
	{
		int largestRow = 0;
		int largestColumn = 0;
		double largestValue = 0;
		
		//theArray.length = number of rows
		for (int i = 0; i < theArray.length; i++)
		{
			//theArray.length[i] = number of columns in row
			for (int j = 0; j < theArray[i].length; j++)
			{
				if (theArray[i][j] > largestValue)
				{
					largestValue = theArray[i][j];
					largestRow = i;
					largestColumn = j;
				}
			}
		}
		
		Location location = new Location();
		
		//Because array is zero-based, need to add 1 to row and column to display properly
		location.row = largestRow + 1;
		location.column = largestColumn + 1;
		location.maxValue = largestValue;
		return location;
	}
}