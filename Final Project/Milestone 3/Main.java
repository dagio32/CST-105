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
		System.out.println("\r\n" + NFLPlayersArray[1].FirstName + " " + NFLPlayersArray[1].LastName);
		System.out.println("Position: " + NFLPlayersArray[1].Position);
		System.out.println("College: " + NFLPlayersArray[1].College);
		System.out.println("Height: " + NFLPlayersArray[1].Height);
		System.out.println("Weight: " + NFLPlayersArray[1].Weight);

		// Combine stats
		System.out.println("40-Yard Dash: " + NFLPlayersArray[1].FortyYardDash);
		System.out.println("Bench Press Reps: " + NFLPlayersArray[1].BenchPressReps);
		System.out.println("Vertical Jump: " + NFLPlayersArray[1].VerticalJump);
		System.out.println("Broad Jump: " + NFLPlayersArray[1].BroadJump);
		System.out.println("Three Cone: " + NFLPlayersArray[1].ThreeConeDrill);
		System.out.println("Shuttle: " + NFLPlayersArray[1].ShuttleRun);
		
		// Season stats (2015)
		System.out.println("\r\nStats for " + NFLPlayersArray[1].SeasonStatsList.get(0).genericStats.YearNumber + " season:");
		System.out.println("Games Played: " + NFLPlayersArray[1].SeasonStatsList.get(0).genericStats.GamesPlayed);
		System.out.println("Games Started: " + NFLPlayersArray[1].SeasonStatsList.get(0).genericStats.GamesStarted);
		// Passing stats
		System.out.println("Completions: "
				+ NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.PassingCompletions);
		System.out.println("Attempts: " + NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.PassingAttempts);
		System.out.println("Completion %: "
				+ NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.PassingCompletionPercentage * 100);
		System.out.println("Yards: " + NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.PassingYards);
		System.out.println("Touchdowns: " + NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.PassingTouchdowns);
		System.out.println("Interceptions: "
				+ NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.PassingInterceptions);
		System.out.println("QB Rating: " + NFLPlayersArray[1].SeasonStatsList.get(0).offensiveStats.QuarterbackRating);
		
		// Season stats (2016)
		System.out.println("\r\nStats for " + NFLPlayersArray[1].SeasonStatsList.get(1).genericStats.YearNumber + " season:");
		System.out.println("Games Played: " + NFLPlayersArray[1].SeasonStatsList.get(1).genericStats.GamesPlayed);
		System.out.println("Games Started: " + NFLPlayersArray[1].SeasonStatsList.get(1).genericStats.GamesStarted);
		// Passing stats
		System.out.println("Completions: "
				+ NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.PassingCompletions);
		System.out.println("Attempts: " + NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.PassingAttempts);
		System.out.println("Completion %: "
				+ NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.PassingCompletionPercentage * 100);
		System.out.println("Yards: " + NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.PassingYards);
		System.out.println("Touchdowns: " + NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.PassingTouchdowns);
		System.out.println("Interceptions: "
				+ NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.PassingInterceptions);
		System.out.println("QB Rating: " + NFLPlayersArray[1].SeasonStatsList.get(1).offensiveStats.QuarterbackRating);
	}
}