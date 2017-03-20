public class Main
{

	public static void main(String[] args)
	{
		// Instantiate PlayerManager object which holds all the players in the draft
		PlayerManager players = new PlayerManager();

		System.out.println("Total number of players in the draft: " + players.PlayersList.length);

		// Testing a player's info and statistics
		// Display player at index 0
		// Player identity
		System.out.println("\r\n" + players.PlayersList[1].getFullName());
		System.out.println("Position: " + players.PlayersList[1].getPosition());
		System.out.println("College: " + players.PlayersList[1].getCollege());
		System.out.println("Height: " + players.PlayersList[1].getHeight());
		System.out.println("Weight: " + players.PlayersList[1].getWeight());

		// Combine stats
		System.out.println("40-Yard Dash: " + players.PlayersList[1].getFortyYardDash());
		System.out.println("Bench Press Reps: " + players.PlayersList[1].getBenchPressReps());
		System.out.println("Vertical Jump: " + players.PlayersList[1].getVerticalJump());
		System.out.println("Broad Jump: " + players.PlayersList[1].getBroadJump());
		System.out.println("Three Cone: " + players.PlayersList[1].getThreeConeDrill());
		System.out.println("Shuttle: " + players.PlayersList[1].getShuttleRun());

		// Season stats (2015)
		System.out.println("\r\nStats for "
				+ players.PlayersList[1].SeasonStatsList.get(0).genericStats.getYearNumber() + " season:");
		System.out.println("Games Played: "
				+ players.PlayersList[1].SeasonStatsList.get(0).genericStats.getGamesPlayed());
		System.out.println("Games Started: "
				+ players.PlayersList[1].SeasonStatsList.get(0).genericStats.getGamesStarted());
		// Passing stats
		System.out.println("Completions: "
				+ players.PlayersList[1].SeasonStatsList.get(0).offensiveStats.getPassingCompletions());
		System.out.println("Attempts: "
				+ players.PlayersList[1].SeasonStatsList.get(0).offensiveStats.getPassingAttempts());
		System.out.println("Completion %: "
				+ players.PlayersList[1].SeasonStatsList.get(0).offensiveStats.getPassingCompletionPercentage());
		System.out.println("Yards: " + players.PlayersList[1].SeasonStatsList.get(0).offensiveStats.getPassingYards());
		System.out.println("Touchdowns: "
				+ players.PlayersList[1].SeasonStatsList.get(0).offensiveStats.getPassingTouchdowns());
		System.out.println("Interceptions: "
				+ players.PlayersList[1].SeasonStatsList.get(0).offensiveStats.getPassingInterceptions());
		System.out.println("QB Rating: "
				+ players.PlayersList[1].SeasonStatsList.get(0).offensiveStats.getQuarterbackRating());

		// Season stats (2016)
		System.out.println("\r\nStats for "
				+ players.PlayersList[1].SeasonStatsList.get(1).genericStats.getYearNumber() + " season:");
		System.out.println("Games Played: "
				+ players.PlayersList[1].SeasonStatsList.get(1).genericStats.getGamesPlayed());
		System.out.println("Games Started: "
				+ players.PlayersList[1].SeasonStatsList.get(1).genericStats.getGamesStarted());
		// Passing stats
		System.out.println("Completions: "
				+ players.PlayersList[1].SeasonStatsList.get(1).offensiveStats.getPassingCompletions());
		System.out.println("Attempts: "
				+ players.PlayersList[1].SeasonStatsList.get(1).offensiveStats.getPassingAttempts());
		System.out.println("Completion %: "
				+ players.PlayersList[1].SeasonStatsList.get(1).offensiveStats.getPassingCompletionPercentage());
		System.out.println("Yards: " + players.PlayersList[1].SeasonStatsList.get(1).offensiveStats.getPassingYards());
		System.out.println("Touchdowns: "
				+ players.PlayersList[1].SeasonStatsList.get(1).offensiveStats.getPassingTouchdowns());
		System.out.println("Interceptions: "
				+ players.PlayersList[1].SeasonStatsList.get(1).offensiveStats.getPassingInterceptions());
		System.out.println("QB Rating: "
				+ players.PlayersList[1].SeasonStatsList.get(1).offensiveStats.getQuarterbackRating());
	}
}