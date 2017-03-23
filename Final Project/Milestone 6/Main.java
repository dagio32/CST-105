public class Main
{

	public static void main(String[] args)
	{
		// Instantiate PlayerManager object which holds all the players in the draft
		PlayerManager players = new PlayerManager();
		
		System.out.println("Number of offensive players in the draft: " + players.getNumberOfOffensivePlayers());
		System.out.println("Number of defensive players in the draft: " + players.getNumberOfDefensivePlayers());
		System.out.println("Number of special teams players in the draft: " + players.getNumberOfSpecialTeamsPlayers());
		System.out.println("Total number of players in the draft: " + players.getNumberOfPlayers());

		// Testing a player's info and statistics
		// Display player at index 0
		// Player identity
		System.out.println("\r\n" + players.getOffensivePlayer(1).getFullName());
		System.out.println("Position: " + players.getOffensivePlayer(1).getPosition());
		System.out.println("College: " + players.getOffensivePlayer(1).getCollege());
		System.out.println("Height: " + players.getOffensivePlayer(1).getHeight());
		System.out.println("Weight: " + players.getOffensivePlayer(1).getWeight());

		// Combine stats
		System.out.println("40-Yard Dash: " + players.getOffensivePlayer(1).getFortyYardDash());
		System.out.println("Bench Press Reps: " + players.getOffensivePlayer(1).getBenchPressReps());
		System.out.println("Vertical Jump: " + players.getOffensivePlayer(1).getVerticalJump());
		System.out.println("Broad Jump: " + players.getOffensivePlayer(1).getBroadJump());
		System.out.println("Three Cone: " + players.getOffensivePlayer(1).getThreeConeDrill());
		System.out.println("Shuttle: " + players.getOffensivePlayer(1).getShuttleRun());
		
		// Test overridden methods
		System.out.println("\r\nType: " + players.getOffensivePlayer(1).getPlayerType());
		System.out.println("Specialty: " + players.getOffensivePlayer(1).getPlayerSpecialty());

		// Season stats (2015)
		System.out.println("\r\nStats for " + players.getOffensivePlayer(1).SeasonStatsList.get(0).getYearNumber()
				+ " season:");
		System.out.println("Games Played: " + players.getOffensivePlayer(1).SeasonStatsList.get(0).getGamesPlayed());
		System.out.println("Games Started: " + players.getOffensivePlayer(1).SeasonStatsList.get(0).getGamesStarted());
		// Passing stats
		System.out.println("Completions: "
				+ players.getOffensivePlayer(1).SeasonStatsList.get(0).getPassingCompletions());
		System.out.println("Attempts: " + players.getOffensivePlayer(1).SeasonStatsList.get(0).getPassingAttempts());
		System.out.println("Completion %: "
				+ players.getOffensivePlayer(1).SeasonStatsList.get(0).getPassingCompletionPercentage());
		System.out.println("Yards: " + players.getOffensivePlayer(1).SeasonStatsList.get(0).getPassingYards());
		System.out
				.println("Touchdowns: " + players.getOffensivePlayer(1).SeasonStatsList.get(0).getPassingTouchdowns());
		System.out.println("Interceptions: "
				+ players.getOffensivePlayer(1).SeasonStatsList.get(0).getPassingInterceptions());
		System.out.println("QB Rating: " + players.getOffensivePlayer(1).SeasonStatsList.get(0).getQuarterbackRating());

		// Season stats (2016)
		System.out.println("\r\nStats for " + players.getOffensivePlayer(1).SeasonStatsList.get(1).getYearNumber()
				+ " season:");
		System.out.println("Games Played: " + players.getOffensivePlayer(1).SeasonStatsList.get(1).getGamesPlayed());
		System.out.println("Games Started: " + players.getOffensivePlayer(1).SeasonStatsList.get(1).getGamesStarted());
		// Passing stats
		System.out.println("Completions: "
				+ players.getOffensivePlayer(1).SeasonStatsList.get(1).getPassingCompletions());
		System.out.println("Attempts: " + players.getOffensivePlayer(1).SeasonStatsList.get(1).getPassingAttempts());
		System.out.println("Completion %: "
				+ players.getOffensivePlayer(1).SeasonStatsList.get(1).getPassingCompletionPercentage());
		System.out.println("Yards: " + players.getOffensivePlayer(1).SeasonStatsList.get(1).getPassingYards());
		System.out
				.println("Touchdowns: " + players.getOffensivePlayer(1).SeasonStatsList.get(1).getPassingTouchdowns());
		System.out.println("Interceptions: "
				+ players.getOffensivePlayer(1).SeasonStatsList.get(1).getPassingInterceptions());
		System.out.println("QB Rating: " + players.getOffensivePlayer(1).SeasonStatsList.get(1).getQuarterbackRating());
	}
}