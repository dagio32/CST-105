import java.util.ArrayList;

/*
 Explanation of class design:

 NFLPlayer class will hold base information that applies to all players, such as name, height, weight, college, and position

 SeasonStats holds one season's worth of statistics
 This may include both offensive and defensive stats for a player that plays both sides of the ball
 For example, a quarterback may not have a DefensiveStats object instantiated
 However these values will still be set to 0, not null

 SeasonStats also includes GenericStats for each player
 GenericStats holds generic stats that all players have on a yearly basis, such as YearNumber, GamesPlayed and GamesStarted

 OffensiveStats and DefensiveStats will include stat categories specific to that side of the ball and will not limit the player based on their particular position
 For example, quarterbacks may have receiving yards, running backs may have passing stats, receivers may have rushing stats, etc.
 This is to account for players who sometimes line up in different positions
 The same applies to defensive players, who regardless of their position may still record the same type of statistics

 */

public class NFLPlayer
{
	// Player identity
	String FirstName;
	String LastName;
	String College;
	String Position;

	int Height;// Inches
	int Weight; // Pounds

	// Combine stats
	double FortyYardDash; // Seconds
	int BenchPressReps; // Number of 225 lb. reps
	double VerticalJump; // Inches
	int BroadJump; // Inches
	double ThreeConeDrill; // Seconds
	double ShuttleRun; // Seconds (20-yard shuttle)

	// Yearly statistics
	ArrayList<SeasonStats> SeasonStatsList = new ArrayList<SeasonStats>();

	//Is player drafted?
	boolean isDrafted;
	
	// Assign default values to all properties to avoid null values
	public NFLPlayer()
	{
		FirstName = "Generic";
		LastName = "Player";
		College = "None";
		Position = "None";
		Height = 0;
		Weight = 0;
		FortyYardDash = 0;
		BenchPressReps = 0;
		VerticalJump = 0;
		BroadJump = 0;
		ThreeConeDrill = 0;
		ShuttleRun = 0;
		isDrafted = false;
	}

	// Main constructor with all inputs
	public NFLPlayer(String firstName, String lastName, String college, String position, int height, int weight,
			double fortyYardDash, int benchPressReps, double verticalJump, int broadJump, double threeConeDrill,
			double shuttleRun)
	{
		FirstName = firstName;
		LastName = lastName;
		College = college;
		Position = position;
		Height = height;
		Weight = weight;
		FortyYardDash = fortyYardDash;
		BenchPressReps = benchPressReps;
		VerticalJump = verticalJump;
		BroadJump = broadJump;
		ThreeConeDrill = threeConeDrill;
		ShuttleRun = shuttleRun;
	}
}

class SeasonStats
{
	GenericStats genericStats;
	OffensiveStats offensiveStats;
	DefensiveStats defensiveStats;
	SpecialTeamsStats specialTeamsStats;
}

class GenericStats
{
	/*
	 * GenericStats will specify the particular year these stats are from as
	 * well as include the number of games played and started
	 */
	int YearNumber;
	int GamesPlayed;
	int GamesStarted;

	// Assign default values to all properties to avoid null values
	public GenericStats()
	{
		YearNumber = 0;
		GamesPlayed = 0;
		GamesStarted = 0;
	}

	// Main constructor with all inputs
	public GenericStats(int yearNumber, int gamesPlayed, int gamesStarted)
	{
		YearNumber = yearNumber;
		GamesPlayed = gamesPlayed;
		GamesStarted = gamesStarted;
	}
}

class OffensiveStats
{
	// Passing stats
	int PassingCompletions;
	int PassingAttempts;
	double PassingCompletionPercentage; // = PassingCompletions /
										// PassingAttempts
	int PassingYards;
	double PassingYardsPerAttempt; // = PassingYards / PassingAttempts
	int PassingTouchdowns;
	int PassingInterceptions;
	int SacksTaken;
	int SackYards;
	// QB rating is a double because it requires a decimal
	// Will be calculated automatically using the various passing stats
	double QuarterbackRating;

	// Rushing stats
	int RushingAttempts;
	int RushingYards;
	int RushingYardsLong; // Longest rush attempt for the season
	int RushingTouchdowns;
	double RushingYardsAverage; // = RushingYards / RushingAttempts
	int Fumbles;
	int FumblesLost;

	// Receving stats
	int Receptions;
	int ReceivingYards;
	int ReceivingTouchdowns;
	double ReceivingYardsAverage; // = ReceivingYards / Receptions

	// Assign default values to all properties to avoid null values
	public OffensiveStats()
	{
		PassingCompletions = 0;
		PassingAttempts = 0;
		PassingCompletionPercentage = 0;
		PassingYards = 0;
		PassingYardsPerAttempt = 0;
		PassingTouchdowns = 0;
		PassingInterceptions = 0;
		SacksTaken = 0;
		SackYards = 0;
		QuarterbackRating = 0;
		RushingAttempts = 0;
		RushingYards = 0;
		RushingYardsLong = 0;
		RushingTouchdowns = 0;
		RushingYardsAverage = 0;
		Fumbles = 0;
		FumblesLost = 0;
		Receptions = 0;
		ReceivingYards = 0;
		ReceivingTouchdowns = 0;
		ReceivingYardsAverage = 0;
	}

	// Main constructor with all inputs
	public OffensiveStats(int passingCompletions, int passingAttempts, int passingYards, int passingTouchdowns,
			int passingInterceptions, int sacksTaken, int sackYards, int rushingAttempts, int rushingYards,
			int rushingYardsLong, int rushingTouchdowns, int fumbles, int fumblesLost, int receptions,
			int receivingYards, int receivingTouchdowns)
	{
		PassingCompletions = passingCompletions;
		PassingAttempts = passingAttempts;
		PassingCompletionPercentage = (double)PassingCompletions / PassingAttempts;
		PassingYards = passingYards;
		PassingYardsPerAttempt = (double)PassingYards / PassingAttempts;
		PassingTouchdowns = passingTouchdowns;
		PassingInterceptions = passingInterceptions;
		SacksTaken = sacksTaken;
		SackYards = sackYards;
		QuarterbackRating = calculateQuarterbackRating(PassingCompletions, PassingAttempts, PassingTouchdowns,
				PassingInterceptions, PassingYards);
		RushingAttempts = rushingAttempts;
		RushingYards = rushingYards;
		RushingYardsLong = rushingYardsLong;
		RushingTouchdowns = rushingTouchdowns;
		RushingYardsAverage = (double)RushingYards / (double)RushingAttempts;
		Fumbles = fumbles;
		FumblesLost = fumblesLost;
		Receptions = receptions;
		ReceivingYards = receivingYards;
		ReceivingTouchdowns = receivingTouchdowns;
		ReceivingYardsAverage = (double)ReceivingYards / (double)Receptions;
	}

	// Quarterback constructor with inputs relevant to quarterbacks
	public OffensiveStats(int passingCompletions, int passingAttempts, int passingYards, int passingTouchdowns,
			int passingInterceptions, int sacksTaken, int sackYards, int rushingAttempts, int rushingYards,
			int rushingYardsLong, int rushingTouchdowns, int fumbles, int fumblesLost)
	{
		PassingCompletions = passingCompletions;
		PassingAttempts = passingAttempts;
		PassingCompletionPercentage = (double)PassingCompletions / PassingAttempts;
		PassingYards = passingYards;
		PassingYardsPerAttempt = (double)PassingYards / PassingAttempts;
		PassingTouchdowns = passingTouchdowns;
		PassingInterceptions = passingInterceptions;
		SacksTaken = sacksTaken;
		SackYards = sackYards;
		QuarterbackRating = calculateQuarterbackRating(PassingCompletions, PassingAttempts, PassingTouchdowns,
				PassingInterceptions, PassingYards);
		RushingAttempts = rushingAttempts;
		RushingYards = rushingYards;
		RushingYardsLong = rushingYardsLong;
		RushingTouchdowns = rushingTouchdowns;
		RushingYardsAverage = (double)RushingYards / (double)RushingAttempts;
		Fumbles = fumbles;
		FumblesLost = fumblesLost;
	}

	// Running back constructor with inputs relevant to running backs
	public OffensiveStats(int rushingAttempts, int rushingYards, int rushingYardsLong, int rushingTouchdowns,
			int fumbles, int fumblesLost, int receptions, int receivingYards, int receivingTouchdowns)
	{
		RushingAttempts = rushingAttempts;
		RushingYards = rushingYards;
		RushingYardsLong = rushingYardsLong;
		RushingTouchdowns = rushingTouchdowns;
		RushingYardsAverage = (double)RushingYards / (double)RushingAttempts;
		Fumbles = fumbles;
		FumblesLost = fumblesLost;
		Receptions = receptions;
		ReceivingYards = receivingYards;
		ReceivingTouchdowns = receivingTouchdowns;
		ReceivingYardsAverage = (double)ReceivingYards / (double)Receptions;
	}

	// Receiver constructor with inputs relevant to receivers

	public OffensiveStats(int fumbles, int fumblesLost, int receptions, int receivingYards, int receivingTouchdowns)
	{
		Fumbles = fumbles;
		FumblesLost = fumblesLost;
		Receptions = receptions;
		ReceivingYards = receivingYards;
		ReceivingTouchdowns = receivingTouchdowns;
		ReceivingYardsAverage = (double)ReceivingYards / (double)Receptions;
	}

	private double calculateQuarterbackRating(int completions, int attempts, int touchdowns, int interceptions,
			int yards)
	{
		/*
		 * Note: This is for the NCAA quarterback rating, not the NFL
		 * quarterback rating.
		 * 
		 * Formula: a = (Comp/Att) * 100 b = (TDs/Att) * 100 c = (Int/Att) * 100
		 * d = Yards/Att
		 * 
		 * QB Rating = a+(3.3*b)-(2*c)+(8.4*d)
		 */

		double a = ((double)completions / attempts) * 100;
		double b = ((double)touchdowns / attempts) * 100;
		double c = ((double)interceptions / attempts) * 100;
		double d = (double)yards / attempts;

		double quarterbackRating = a + (3.3 * b) - (2 * c) + (8.4 * d);

		return quarterbackRating;
	}
}

class DefensiveStats
{
	// Tackling stats
	int SoloTackles;
	int TackleAssists;
	int TotalTackles; // = SoloTackles + TackleAssists
	double Sacks; // Double type to account for half sacks

	// Defensive passing stats
	int PassesDefended;
	int Interceptions;
	int InterceptionReturnYards;
	int InterceptionReturnLong; // Longest interception return for the season
	int InterceptionTouchdowns;

	// Fumble stats
	int ForcedFumbles;
	int RecoveredFumbles;
	int FumbleTouchdowns;

	// Misc stats
	int Safeties;

	// Assign default values to all properties to avoid null values
	public DefensiveStats()
	{
		SoloTackles = 0;
		TackleAssists = 0;
		TotalTackles = 0;
		Sacks = 0;
		PassesDefended = 0;
		Interceptions = 0;
		InterceptionReturnYards = 0;
		InterceptionReturnLong = 0;
		InterceptionTouchdowns = 0;
		ForcedFumbles = 0;
		RecoveredFumbles = 0;
		FumbleTouchdowns = 0;
		Safeties = 0;
	}

	// Main constructor with all inputs
	public DefensiveStats(int soloTackles, int tackleAssists, int sacks, int passesDefended, int interceptions,
			int interceptionReturnYards, int interceptionReturnLong, int interceptionTouchdowns, int forcedFumbles,
			int recoveredFumbles, int fumbleTouchdowns, int safeties)
	{
		SoloTackles = soloTackles;
		TackleAssists = tackleAssists;
		TotalTackles = SoloTackles + TackleAssists;
		Sacks = sacks;
		PassesDefended = passesDefended;
		Interceptions = interceptions;
		InterceptionReturnYards = interceptionReturnYards;
		InterceptionReturnLong = interceptionReturnLong;
		InterceptionTouchdowns = interceptionTouchdowns;
		ForcedFumbles = forcedFumbles;
		RecoveredFumbles = recoveredFumbles;
		FumbleTouchdowns = fumbleTouchdowns;
		Safeties = safeties;
	}
}

class SpecialTeamsStats
{
	// Kicker stats
	int FieldGoalsAttempted;
	int FieldGoalsMade;
	int FieldGoalLongMade; // Longest field goal converted for the season
	int FieldGoalsBlocked;

	// Punter stats
	int TotalPunts;
	int PuntYardsGross; // = Total punt yards for the season
	double PuntYardsGrossAverage; // = PuntYardsGross / TotalPunts
	int PuntReturnYardsAgainst; // = Total yards the receiving players returned
								// the punts
	int PuntTouchbacks;
	int PuntYardsNet; // = PuntYardsGross - PuntReturnYardsAgainst -
						// (PuntTouchbacks * 20)
	double PuntYardsNetAverage; // = PuntYardsNet / TotalPunts
	int PuntYardsLong; // = Longest punt for the season
	int PuntsInside20; // = Total punts downed inside the 20-yard line
	int PuntsBlocked;

	// Returner stats
	// Kickoff returns
	int KickoffReturns;
	int KickoffReturnYards;
	double KickoffReturnYardsAverage;
	int KickoffReturnYardsLong;
	int KickoffReturnTouchdowns;
	int KickoffReturnFumbles;
	int KickoffReturnFairCatches;

	// Punt returns
	int PuntReturns;
	int PuntReturnYards;
	double PuntReturnYardsAverage;
	int PuntReturnYardsLong;
	int PuntReturnTouchdowns;
	int PuntReturnFumbles;
	int PuntReturnFairCatches;

	// Assign default values to all properties to avoid null values
	public SpecialTeamsStats()
	{
		FieldGoalsAttempted = 0;
		FieldGoalsMade = 0;
		FieldGoalLongMade = 0;
		FieldGoalsBlocked = 0;
		TotalPunts = 0;
		PuntYardsGross = 0;
		PuntYardsGrossAverage = 0;
		PuntReturnYardsAgainst = 0;
		PuntTouchbacks = 0;
		PuntYardsNet = 0;
		PuntYardsNetAverage = 0;
		PuntYardsLong = 0;
		PuntsInside20 = 0;
		PuntsBlocked = 0;
		KickoffReturns = 0;
		KickoffReturnYards = 0;
		KickoffReturnYardsAverage = 0;
		KickoffReturnYardsLong = 0;
		KickoffReturnTouchdowns = 0;
		KickoffReturnFumbles = 0;
		KickoffReturnFairCatches = 0;
		PuntReturns = 0;
		PuntReturnYards = 0;
		PuntReturnYardsAverage = 0;
		PuntReturnYardsLong = 0;
		PuntReturnTouchdowns = 0;
		PuntReturnFumbles = 0;
		PuntReturnFairCatches = 0;
	}

	// Main constructor with all inputs
	public SpecialTeamsStats(int fieldGoalsAttempted, int fieldGoalsMade, int fieldGoalLongMade, int fieldGoalsBlocked,
			int totalPunts, int puntYardsGross, int puntReturnYardsAgainst, int puntTouchbacks, int puntYardsLong,
			int puntsInside20, int puntsBlocked, int kickoffReturns, int kickoffReturnYards,
			int kickoffReturnYardsLong, int kickoffReturnTouchdowns, int kickoffReturnFumbles,
			int kickoffReturnFairCatches, int puntReturns, int puntReturnYards, int puntReturnYardsLong,
			int puntReturnTouchdowns, int puntReturnFumbles, int puntReturnFairCatches)
	{
		FieldGoalsAttempted = fieldGoalsAttempted;
		FieldGoalsMade = fieldGoalsMade;
		FieldGoalLongMade = fieldGoalLongMade;
		FieldGoalsBlocked = fieldGoalsBlocked;
		TotalPunts = totalPunts;
		PuntYardsGross = puntYardsGross;
		PuntYardsGrossAverage = (double)PuntYardsGross / TotalPunts;
		PuntReturnYardsAgainst = puntReturnYardsAgainst;
		PuntTouchbacks = puntTouchbacks;
		PuntYardsNet = PuntYardsGross - PuntReturnYardsAgainst - (PuntTouchbacks * 20);
		PuntYardsNetAverage = (double)PuntYardsNet / totalPunts;
		PuntYardsLong = puntYardsLong;
		PuntsInside20 = puntsInside20;
		PuntsBlocked = puntsBlocked;
		KickoffReturns = kickoffReturns;
		KickoffReturnYards = kickoffReturnYards;
		KickoffReturnYardsAverage = (double)KickoffReturnYards / KickoffReturns;
		KickoffReturnYardsLong = kickoffReturnYardsLong;
		KickoffReturnTouchdowns = kickoffReturnTouchdowns;
		KickoffReturnFumbles = kickoffReturnFumbles;
		KickoffReturnFairCatches = kickoffReturnFairCatches;
		PuntReturns = puntReturns;
		PuntReturnYards = puntReturnYards;
		PuntReturnYardsAverage = (double)PuntReturnYards / PuntReturns;
		PuntReturnYardsLong = puntReturnYardsLong;
		PuntReturnTouchdowns = puntReturnTouchdowns;
		PuntReturnFumbles = puntReturnFumbles;
		PuntReturnFairCatches = puntReturnFairCatches;
	}

	// Kicker constructor with inputs relevant to kickers
	public SpecialTeamsStats(int fieldGoalsAttempted, int fieldGoalsMade, int fieldGoalLongMade, int fieldGoalsBlocked)
	{
		FieldGoalsAttempted = fieldGoalsAttempted;
		FieldGoalsMade = fieldGoalsMade;
		FieldGoalLongMade = fieldGoalLongMade;
		FieldGoalsBlocked = fieldGoalsBlocked;
	}

	// Punter constructor with inputs relevant to kickers
	public SpecialTeamsStats(int totalPunts, int puntYardsGross, int puntReturnYardsAgainst, int puntTouchbacks,
			int puntYardsLong, int puntsInside20, int puntsBlocked)
	{
		TotalPunts = totalPunts;
		PuntYardsGross = puntYardsGross;
		PuntYardsGrossAverage = (double)PuntYardsGross / TotalPunts;
		PuntReturnYardsAgainst = puntReturnYardsAgainst;
		PuntTouchbacks = puntTouchbacks;
		PuntYardsNet = PuntYardsGross - PuntReturnYardsAgainst - (PuntTouchbacks * 20);
		PuntYardsNetAverage = (double)PuntYardsNet / totalPunts;
		PuntYardsLong = puntYardsLong;
		PuntsInside20 = puntsInside20;
		PuntsBlocked = puntsBlocked;
	}

	// Returner constructor with inputs relevant to returners
	public SpecialTeamsStats(int kickoffReturns, int kickoffReturnYards, int kickoffReturnYardsLong,
			int kickoffReturnTouchdowns, int kickoffReturnFumbles, int kickoffReturnFairCatches, int puntReturns,
			int puntReturnYards, int puntReturnYardsLong, int puntReturnTouchdowns, int puntReturnFumbles,
			int puntReturnFairCatches)
	{
		KickoffReturns = kickoffReturns;
		KickoffReturnYards = kickoffReturnYards;
		KickoffReturnYardsAverage = (double)KickoffReturnYards / KickoffReturns;
		KickoffReturnYardsLong = kickoffReturnYardsLong;
		KickoffReturnTouchdowns = kickoffReturnTouchdowns;
		KickoffReturnFumbles = kickoffReturnFumbles;
		KickoffReturnFairCatches = kickoffReturnFairCatches;
		PuntReturns = puntReturns;
		PuntReturnYards = puntReturnYards;
		PuntReturnYardsAverage = (double)PuntReturnYards / PuntReturns;
		PuntReturnYardsLong = puntReturnYardsLong;
		PuntReturnTouchdowns = puntReturnTouchdowns;
		PuntReturnFumbles = puntReturnFumbles;
		PuntReturnFairCatches = puntReturnFairCatches;
	}
}