
public class PopulationProjection
{

	public static void main(String[] args) 
	{
		int currentPopulation = 312032486;
		int daysInYear = 365;
		int secondsInDay = 86400;
		int secondsInYear = daysInYear * secondsInDay;
		
		//One birth every 7 seconds
		int totalYearlyBirths = secondsInYear / 7;
		
		//One death every 13 seconds
		int totalYearlyDeaths = secondsInYear / 13;
		
		//One new immigrant every 45 seconds
		int totalYearlyImmigrants = secondsInYear / 45;
		
		System.out.println("Births in a year " + totalYearlyBirths);
		System.out.println("Deaths in a year " + totalYearlyDeaths);
		System.out.println("Immigrants in a year " + totalYearlyImmigrants);
		
		for (int i = 1; i <= 5; i++)
		{
			//Add births to population
			currentPopulation += totalYearlyBirths;
			//Subtract deaths from population
			currentPopulation -= totalYearlyDeaths;
			//Add immigrants to population
			currentPopulation += totalYearlyImmigrants;
			
			System.out.println("Population in year " + i + ": " + currentPopulation);
		}
	}

}
