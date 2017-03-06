//Created by Nicholas Robertson for Grand Canyon University

/*
9.2 (The Stock class) Following the example of the Circle class in Section 9.2,
design a class named Stock that contains:
* A string data field named symbol for the stock’s symbol.
* A string data field named name for the stock’s name.
* A double data field named previousClosingPrice that stores the stock
price for the previous day.
* A double data field named currentPrice that stores the stock price for the
current time.
* A constructor that creates a stock with the specified symbol and name.
* A method named getChangePercent() that returns the percentage changed
from previousClosingPrice to currentPrice.
Draw the UML diagram for the class and then implement the class. Write a test
program that creates a Stock object with the stock symbol ORCL, the name
Oracle Corporation, and the previous closing price of 34.5.
*/

import java.text.NumberFormat;

public class StockClass {
	
	public static void main(String[] args)
	{
		//Create instance of StockClass and assign values
		StockClass tempStock = new StockClass("ORCL", "Oracle Corporation");
		tempStock.PreviousClosingPrice = 34.5;
		tempStock.CurrentPrice = 40.0;
		
		//Assign percentChanged by calling the getChangePercent method
		double percentChanged = getChangePercent(tempStock.PreviousClosingPrice, tempStock.CurrentPrice); 
		
		//Format to percentage
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		percentFormat.setMinimumFractionDigits(2);
		
		//Print results
		System.out.println("Displaying information for " + tempStock.Name + ", symbol " + tempStock.Symbol);
		System.out.println("Previous price: " + tempStock.PreviousClosingPrice);
		System.out.println("Current price: " + tempStock.CurrentPrice);
		System.out.println("Stock has changed by " + percentFormat.format(percentChanged));
	}
	
	//Property values for StockClass
	String Symbol;
	String Name;
	double PreviousClosingPrice;
	double CurrentPrice;
	
	//Constructor that assigns symbol and name
	public StockClass(String symbol, String name)
	{
		Symbol = symbol;
		Name = name;
	}
	
	//Takes in previous price and current price, then calculates the percentage it has changed
	//Will return a decimal value (.08 = 8%, .5 = 50%, 1.0 = 100%)
	//Negative number means a drop
	public static double getChangePercent(double previousClosingPrice, double currentPrice)
	{
		double totalIncrease = currentPrice - previousClosingPrice;
		double percentChange = totalIncrease / previousClosingPrice;
		return percentChange;
	}
}