public class Main
{

	public static void main(String[] args)
	{
		// Instantiate PlayerManager object which holds all the players in the draft
		PlayerManager players = new PlayerManager();

		System.out.println("Total number of players in the draft: " + players.getNumberOfPlayers());

		// Testing a player's info and statistics
		// Display player at index 0
		// Player identity
		System.out.println("\r\n" + players.getPlayer(1).getFullName());
		System.out.println("Position: " + players.getPlayer(1).getPosition());
		System.out.println("College: " + players.getPlayer(1).getCollege());
		System.out.println("Height: " + players.getPlayer(1).getHeight());
		System.out.println("Weight: " + players.getPlayer(1).getWeight());

		// Combine stats
		System.out.println("40-Yard Dash: " + players.getPlayer(1).getFortyYardDash());
		System.out.println("Bench Press Reps: " + players.getPlayer(1).getBenchPressReps());
		System.out.println("Vertical Jump: " + players.getPlayer(1).getVerticalJump());
		System.out.println("Broad Jump: " + players.getPlayer(1).getBroadJump());
		System.out.println("Three Cone: " + players.getPlayer(1).getThreeConeDrill());
		System.out.println("Shuttle: " + players.getPlayer(1).getShuttleRun());

		// Season stats (2015)
		System.out.println("\r\nStats for "
				+ players.getPlayer(1).SeasonStatsList.get(0).genericStats.getYearNumber() + " season:");
		System.out.println("Games Played: "
				+ players.getPlayer(1).SeasonStatsList.get(0).genericStats.getGamesPlayed());
		System.out.println("Games Started: "
				+ players.getPlayer(1).SeasonStatsList.get(0).genericStats.getGamesStarted());
		// Passing stats
		System.out.println("Completions: "
				+ players.getPlayer(1).SeasonStatsList.get(0).offensiveStats.getPassingCompletions());
		System.out.println("Attempts: "
				+ players.getPlayer(1).SeasonStatsList.get(0).offensiveStats.getPassingAttempts());
		System.out.println("Completion %: "
				+ players.getPlayer(1).SeasonStatsList.get(0).offensiveStats.getPassingCompletionPercentage());
		System.out.println("Yards: " + players.getPlayer(1).SeasonStatsList.get(0).offensiveStats.getPassingYards());
		System.out.println("Touchdowns: "
				+ players.getPlayer(1).SeasonStatsList.get(0).offensiveStats.getPassingTouchdowns());
		System.out.println("Interceptions: "
				+ players.getPlayer(1).SeasonStatsList.get(0).offensiveStats.getPassingInterceptions());
		System.out.println("QB Rating: "
				+ players.getPlayer(1).SeasonStatsList.get(0).offensiveStats.getQuarterbackRating());

		// Season stats (2016)
		System.out.println("\r\nStats for "
				+ players.getPlayer(1).SeasonStatsList.get(1).genericStats.getYearNumber() + " season:");
		System.out.println("Games Played: "
				+ players.getPlayer(1).SeasonStatsList.get(1).genericStats.getGamesPlayed());
		System.out.println("Games Started: "
				+ players.getPlayer(1).SeasonStatsList.get(1).genericStats.getGamesStarted());
		// Passing stats
		System.out.println("Completions: "
				+ players.getPlayer(1).SeasonStatsList.get(1).offensiveStats.getPassingCompletions());
		System.out.println("Attempts: "
				+ players.getPlayer(1).SeasonStatsList.get(1).offensiveStats.getPassingAttempts());
		System.out.println("Completion %: "
				+ players.getPlayer(1).SeasonStatsList.get(1).offensiveStats.getPassingCompletionPercentage());
		System.out.println("Yards: " + players.getPlayer(1).SeasonStatsList.get(1).offensiveStats.getPassingYards());
		System.out.println("Touchdowns: "
				+ players.getPlayer(1).SeasonStatsList.get(1).offensiveStats.getPassingTouchdowns());
		System.out.println("Interceptions: "
				+ players.getPlayer(1).SeasonStatsList.get(1).offensiveStats.getPassingInterceptions());
		System.out.println("QB Rating: "
				+ players.getPlayer(1).SeasonStatsList.get(1).offensiveStats.getQuarterbackRating());
	}
}