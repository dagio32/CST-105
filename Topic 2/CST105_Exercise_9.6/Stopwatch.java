//Created by Nicholas Robertson for Grand Canyon University

/*
9.6 (Stopwatch) Design a class named StopWatch. The class contains:
* Private data fields startTime and endTime with getter methods.
* A no-arg constructor that initializes startTime with the current time.
* A method named start() that resets the startTime to the current time.
* A method named stop() that sets the endTime to the current time.
* A method named getElapsedTime() that returns the elapsed time for the
stopwatch in milliseconds.
Draw the UML diagram for the class and then implement the class. Write a test
program that measures the execution time of sorting 100,000 numbers using
selection sort.
*/

import java.util.Random;

public class Stopwatch
{
	
	public static void main(String[] args)
	{
		//Random will be used to generate random integers and assign them to the array
		Random random = new Random();
		
		//Create an array with 100,000 elements
		int[] intArray = new int[100000];
		
		//Assign 100,000 random numbers between 1 and 50 to the array
		for (int i = 0; i < 100000; i++)
		{
			intArray[i] = random.nextInt(50) + 1;
		}
		
		//Create a timer
		Stopwatch timer = new Stopwatch();
		
		//Start the timer
		timer.start();
		
		//Perform the selection sort
		selectionSort(intArray);
		
		//Stop the timer
		timer.stop();
		
		//Display elapsed time
		System.out.println("Elapsed time: " + timer.getElapsedTime() + " milliseconds.");
	}

	private long StartTime;
	private long EndTime;
	
	//Getter methods for both variables
	public long getStartTime()
	{
		return StartTime;
	}
	
	public long getEndTime()
	{
		return EndTime;
	}
	
	//Constructor that sets StartTime to the current time
	public Stopwatch()
	{
		StartTime = System.currentTimeMillis();
	}
	
	//Sets start time to the current time
	public void start()
	{
		StartTime = System.currentTimeMillis();
	}
	
	//Sets end time to the current time
	public void stop()
	{
		EndTime = System.currentTimeMillis();
	}
	
	//Returns elapsed time in milliseconds between start and end times
	public int getElapsedTime()
	{
		//Create long in order to use EndTime and StartTime
		long elapsedTime = EndTime - StartTime;
		
		//Cast elapsedTime as int because it's unnecessary to be in long format for a small number
		return (int)elapsedTime;
	}

	//Selection sort method from chapter 7
	public static void selectionSort(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;

			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}

			// Swap list[i] with list[currentMinIndex] if necessary
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}
}