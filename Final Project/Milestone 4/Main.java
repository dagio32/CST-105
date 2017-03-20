public class Main
{

	public static void main(String[] args)
	{
		// Call CreatePlayers() method, which creates 50 players and puts them
		// into an array of NFLPlayer[]
		NFLPlayer[] NFLPlayersArray = PlayerManager.CreatePlayers();
		
		System.out.println("Total number of players in the draft: " + NFLPlayersArray.length);
		
		// Testing a player's info and statistics
		// Display player at index 0
		// Player identity
		System.out.println("\r\n" + NFLPlayersArray[1].getFirstName() + " " + NFLPlayersArray[1].getLastName());
		System.out.println("Position: " + NFLPlayersArray[1].getPosition());
		System.out.println("College: " + NFLPlayersArray[1].getCollege());
		System.out.println("Height: " + NFLPlayersArray[1].getHeight());
		System.out.println("Weight: " + NFLPlayersArray[1].getWeight());
		
		// Combine stats
		System.out.println("40-Yard Dash: " + NFLPlayersArray[1].getFortyYardDash());
		System.out.println("Bench Press Reps: " + NFLPlayersArray[1].getBenchPressReps());
		System.out.println("Vertical Jump: " + NFLPlayersArray[1].getVerticalJump());
		System.out.println("Broad Jump: " + NFLPlayersArray[1].getBroadJump());
		System.out.println("Three Cone: " + NFLPlayersArray[1].getThreeConeDrill());
		System.out.println("Shuttle: " + NFLPlayersArray[1].getShuttleRun());
		
		// Season stats (2015)
		System.out.println("\r\nStats for " + NFLPlayersArray[1].SeasonStatsList.get(0).genericStats.getYearNumber() + " season:");
		System.out.println("Games Played: " + NFLPlayersArray[1].SeasonStatsList.get(0).genericStats.getGamesPlayed());
		System.out.println("Games Started: " + NFLPlayersArray[1].SeasonStatsList.get(0).genericStats.getGamesStarted());
		// Passing stats
		System.out.println("Completions: "
				+ NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.getPassingCompletions());
		System.out.println("Attempts: " + NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.getPassingAttempts());
		System.out.println("Completion %: "
				+ NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.getPassingCompletionPercentage());
		System.out.println("Yards: " + NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.getPassingYards());
		System.out.println("Touchdowns: " + NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.getPassingTouchdowns());
		System.out.println("Interceptions: "
				+ NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.getPassingInterceptions());
		System.out.println("QB Rating: " + NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.getQuarterbackRating());
		
		// Season stats (2016)
		System.out.println("\r\nStats for " + NFLPlayersArray[1].SeasonStatsList.get(1).genericStats.getYearNumber() + " season:");
		System.out.println("Games Played: " + NFLPlayersArray[1].SeasonStatsList.get(1).genericStats.getGamesPlayed());
		System.out.println("Games Started: " + NFLPlayersArray[1].SeasonStatsList.get(1).genericStats.getGamesStarted());
		// Passing stats
		System.out.println("Completions: "
				+ NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.getPassingCompletions());
		System.out.println("Attempts: " + NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.getPassingAttempts());
		System.out.println("Completion %: "
				+ NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.getPassingCompletionPercentage());
		System.out.println("Yards: " + NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.getPassingYards());
		System.out.println("Touchdowns: " + NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.getPassingTouchdowns());
		System.out.println("Interceptions: "
				+ NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.getPassingInterceptions());
		System.out.println("QB Rating: " + NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.getQuarterbackRating());
	}
}