//This file is for testing out the NFLPlayer.java class
public class ClassTester {

	public static void main(String[] args) {
		//Temporary objects will be created and assigned values, then tested at the end by printing them to console
		
		// Initialize data for internal
		// NFLPlayer
		NFLPlayer tempPlayer = new NFLPlayer();
		tempPlayer.FirstName = "Nicholas";
		tempPlayer.LastName = "Robertson";
		tempPlayer.Height = 71;
		tempPlayer.Weight = 215;
		tempPlayer.Position = "Halfback";
		tempPlayer.College = "Grand Canyon University";
		
		// Initialize data for internal
		// SeasonNumber
		SeasonNumber tempSeasonNumber = new SeasonNumber();
		tempSeasonNumber.GamesPlayed = 10;
		tempSeasonNumber.GamesStarted = 8;
		tempSeasonNumber.YearNumber = 2017;

		// Initialize data for internal
		// OffensivePlayer
		OffensivePlayer tempOffensivePlayer = new OffensivePlayer();
		tempOffensivePlayer.FumblesLost = 1;
		tempOffensivePlayer.Fumbles = 2;
		tempOffensivePlayer.ReceivingTouchdowns = 1;
		tempOffensivePlayer.ReceivingYards = 181;
		tempOffensivePlayer.Receptions = 20;
		tempOffensivePlayer.ReceivingYardsAverage = 9.1;
		tempOffensivePlayer.RushingAttempts = 255;
		tempOffensivePlayer.RushingYards = 1420;
		tempOffensivePlayer.RushingTouchdowns = 15;
		tempOffensivePlayer.RushingYardsLong = 53;
		tempOffensivePlayer.RushingYardsAverage = (double)tempOffensivePlayer.RushingYards / (double)tempOffensivePlayer.RushingAttempts;
		tempOffensivePlayer.SeasonNum = tempSeasonNumber;

		// Initialize data for internal
		// SeasonStats
		SeasonStats tempSeason = new SeasonStats();
		tempSeason.offensivePlayer = tempOffensivePlayer;

		//Add the single season to the list of season stats
		tempPlayer.SeasonStatsList.add(tempSeason);

		//Print player information
		System.out.println(tempPlayer.FirstName + " " + tempPlayer.LastName);
		System.out.println(tempPlayer.Position + " from " + tempPlayer.College);
		System.out.println(tempPlayer.Height + " inches tall and weighs " + tempPlayer.Weight + " pounds");
		
		System.out.println("Stats for the year " + tempPlayer.SeasonStatsList.get(0).offensivePlayer.SeasonNum.YearNumber);
		System.out.println("Games played: " + tempPlayer.SeasonStatsList.get(0).offensivePlayer.SeasonNum.GamesPlayed);
		
		//Test a statistic that was not assigned
		System.out.println("Passing yards: " + tempPlayer.SeasonStatsList.get(0).offensivePlayer.PassingYards);
		
		//Test some rushing stats
		System.out.println("Rushing attempts: " + tempPlayer.SeasonStatsList.get(0).offensivePlayer.RushingAttempts);
		System.out.println("Rushing yards: " + tempPlayer.SeasonStatsList.get(0).offensivePlayer.RushingYards);
		System.out.println("Rushing average: " + tempPlayer.SeasonStatsList.get(0).offensivePlayer.RushingYardsAverage);
		System.out.println("Rushing touchdowns: " + tempPlayer.SeasonStatsList.get(0).offensivePlayer.RushingTouchdowns);
		System.out.println("Fumbles: " + tempPlayer.SeasonStatsList.get(0).offensivePlayer.Fumbles);
	}
}