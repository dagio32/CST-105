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
	private String FirstName;
	private String LastName;
	private String College;
	private String Position;

	private int Height;// Inches
	private int Weight; // Pounds

	// Combine stats
	private double FortyYardDash; // Seconds
	private int BenchPressReps; // Number of 225 lb. reps
	private double VerticalJump; // Inches
	private int BroadJump; // Inches
	private double ThreeConeDrill; // Seconds
	private double ShuttleRun; // Seconds (20-yard shuttle)

	// Yearly statistics
	ArrayList<SeasonStats> SeasonStatsList = new ArrayList<SeasonStats>();

	// Is player drafted?
	private boolean IsDrafted;

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
		IsDrafted = false;
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

	// Setter methods
	public void setFirstName(String firstName)
	{
		FirstName = firstName;
	}

	public void setLastName(String lastName)
	{
		LastName = lastName;
	}
	
	public void setCollege(String college)
	{
		College = college;
	}
	
	public void setPosition(String position)
	{
		Position = position;
	}
	
	public void setHeight(int height)
	{
		Height = height;
	}
	
	public void setWeight(int weight)
	{
		Weight = weight;
	}
	
	public void setFortyYardDash(double fortyYardDash)
	{
		FortyYardDash = fortyYardDash;
	}
	
	public void setBenchPressReps(int benchPressReps)
	{
		BenchPressReps = benchPressReps;
	}
	
	public void setVerticalJump(double verticalJump)
	{
		VerticalJump = verticalJump;
	}
	
	public void setBroadJump(int broadJump)
	{
		BroadJump = broadJump;
	}
	
	public void setThreeConeDrill(double threeConeDrill)
	{
		ThreeConeDrill = threeConeDrill;
	}
	
	public void setShuttleRun(double shuttleRun)
	{
		ShuttleRun = shuttleRun;
	}
	
	public void setIsDrafted(boolean isDrafted)
	{
		IsDrafted = isDrafted;
	}
	
	// Getter methods
	public String getFirstName()
	{
		return FirstName;
	}

	public String getLastName()
	{
		return LastName;
	}
	
	public String getFullName()
	{
		String fullName = FirstName + " " + LastName; 
		return fullName;
	}
	
	
	public String getCollege()
	{
		return College;
	}
	
	public String getPosition()
	{
		return Position;
	}
	
	public int getHeight()
	{
		return Height;
	}
	
	public int getWeight()
	{
		return Weight;
	}
	
	public double getFortyYardDash()
	{
		return FortyYardDash;
	}
	
	public int getBenchPressReps()
	{
		return BenchPressReps;
	}
	
	public double getVerticalJump()
	{
		return VerticalJump;
	}
	
	public int getBroadJump()
	{
		return BroadJump;
	}
	
	public double getThreeConeDrill()
	{
		return ThreeConeDrill;
	}
	
	public double getShuttleRun()
	{
		return ShuttleRun;
	}
	
	public boolean getIsDrafted()
	{
		return IsDrafted;
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
	private int YearNumber;
	private int GamesPlayed;
	private int GamesStarted;

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
	
	// Setter methods
	public void setYearNumber(int yearNumber)
	{
		YearNumber = yearNumber;
	}
	
	public void setGamesPlayed(int gamesPlayed)
	{
		GamesPlayed = gamesPlayed;
	}
	
	public void setGamesStarted(int gamesStarted)
	{
		GamesStarted = gamesStarted;
	}
	
	// Getter methods
	public int getYearNumber()
	{
		return YearNumber;
	}
	
	public int getGamesPlayed()
	{
		return GamesPlayed;
	}
	
	public int getGamesStarted()
	{
		return GamesStarted;
	}
}

class OffensiveStats
{
	// Passing stats
	private int PassingCompletions;
	private int PassingAttempts;
	//double PassingCompletionPercentage; // = PassingCompletions /
										// PassingAttempts
	private int PassingYards;
	//double PassingYardsPerAttempt; // = PassingYards / PassingAttempts
	private int PassingTouchdowns;
	private int PassingInterceptions;
	private int SacksTaken;
	private int SackYards;
	// QB rating is a double because it requires a decimal
	// Will be calculated automatically using the various passing stats
	//double QuarterbackRating;

	// Rushing stats
	private int RushingAttempts;
	private int RushingYards;
	private int RushingYardsLong; // Longest rush attempt for the season
	private int RushingTouchdowns;
	//double RushingYardsAverage; // = RushingYards / RushingAttempts
	private int Fumbles;
	private int FumblesLost;

	// Receving stats
	private int Receptions;
	private int ReceivingYards;
	private int ReceivingTouchdowns;
	//double ReceivingYardsAverage; // = ReceivingYards / Receptions

	// Assign default values to all properties to avoid null values
	public OffensiveStats()
	{
		PassingCompletions = 0;
		PassingAttempts = 0;
		//PassingCompletionPercentage = 0;
		PassingYards = 0;
		//PassingYardsPerAttempt = 0;
		PassingTouchdowns = 0;
		PassingInterceptions = 0;
		SacksTaken = 0;
		SackYards = 0;
		//QuarterbackRating = 0;
		RushingAttempts = 0;
		RushingYards = 0;
		RushingYardsLong = 0;
		RushingTouchdowns = 0;
		//RushingYardsAverage = 0;
		Fumbles = 0;
		FumblesLost = 0;
		Receptions = 0;
		ReceivingYards = 0;
		ReceivingTouchdowns = 0;
		//ReceivingYardsAverage = 0;
	}

	// Main constructor with all inputs
	public OffensiveStats(int passingCompletions, int passingAttempts, int passingYards, int passingTouchdowns,
			int passingInterceptions, int sacksTaken, int sackYards, int rushingAttempts, int rushingYards,
			int rushingYardsLong, int rushingTouchdowns, int fumbles, int fumblesLost, int receptions,
			int receivingYards, int receivingTouchdowns)
	{
		PassingCompletions = passingCompletions;
		PassingAttempts = passingAttempts;
		//PassingCompletionPercentage = (double)PassingCompletions / PassingAttempts;
		PassingYards = passingYards;
		//PassingYardsPerAttempt = (double)PassingYards / PassingAttempts;
		PassingTouchdowns = passingTouchdowns;
		PassingInterceptions = passingInterceptions;
		SacksTaken = sacksTaken;
		SackYards = sackYards;
		//QuarterbackRating = calculateQuarterbackRating(PassingCompletions, PassingAttempts, PassingTouchdowns,
		//		PassingInterceptions, PassingYards);
		RushingAttempts = rushingAttempts;
		RushingYards = rushingYards;
		RushingYardsLong = rushingYardsLong;
		RushingTouchdowns = rushingTouchdowns;
		//RushingYardsAverage = (double)RushingYards / (double)RushingAttempts;
		Fumbles = fumbles;
		FumblesLost = fumblesLost;
		Receptions = receptions;
		ReceivingYards = receivingYards;
		ReceivingTouchdowns = receivingTouchdowns;
		//ReceivingYardsAverage = (double)ReceivingYards / (double)Receptions;
	}

	// Quarterback constructor with inputs relevant to quarterbacks
	public OffensiveStats(int passingCompletions, int passingAttempts, int passingYards, int passingTouchdowns,
			int passingInterceptions, int sacksTaken, int sackYards, int rushingAttempts, int rushingYards,
			int rushingYardsLong, int rushingTouchdowns, int fumbles, int fumblesLost)
	{
		PassingCompletions = passingCompletions;
		PassingAttempts = passingAttempts;
		//PassingCompletionPercentage = (double)PassingCompletions / PassingAttempts;
		PassingYards = passingYards;
		//PassingYardsPerAttempt = (double)PassingYards / PassingAttempts;
		PassingTouchdowns = passingTouchdowns;
		PassingInterceptions = passingInterceptions;
		SacksTaken = sacksTaken;
		SackYards = sackYards;
		RushingAttempts = rushingAttempts;
		RushingYards = rushingYards;
		RushingYardsLong = rushingYardsLong;
		RushingTouchdowns = rushingTouchdowns;
		//RushingYardsAverage = (double)RushingYards / (double)RushingAttempts;
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
		//RushingYardsAverage = (double)RushingYards / (double)RushingAttempts;
		Fumbles = fumbles;
		FumblesLost = fumblesLost;
		Receptions = receptions;
		ReceivingYards = receivingYards;
		ReceivingTouchdowns = receivingTouchdowns;
		//ReceivingYardsAverage = (double)ReceivingYards / (double)Receptions;
	}

	// Receiver constructor with inputs relevant to receivers
	public OffensiveStats(int fumbles, int fumblesLost, int receptions, int receivingYards, int receivingTouchdowns)
	{
		Fumbles = fumbles;
		FumblesLost = fumblesLost;
		Receptions = receptions;
		ReceivingYards = receivingYards;
		ReceivingTouchdowns = receivingTouchdowns;
		//ReceivingYardsAverage = (double)ReceivingYards / (double)Receptions;
	}

	// Setter methods
	public void setPassingCompletions(int passingCompletions)
	{
		PassingCompletions = passingCompletions;
	}
	
	public void setPassingAttempts(int passingAttempts)
	{
		PassingAttempts = passingAttempts;
	}
	
	public void setPassingYards(int passingYards)
	{
		PassingYards = passingYards;
	}
	
	public void setPassingTouchdowns(int passingTouchdowns)
	{
		PassingTouchdowns = passingTouchdowns;
	}
	
	public void setPassingInterceptions(int passingInterceptions)
	{
		PassingInterceptions = passingInterceptions;
	}
	
	public void setSacksTaken(int sacksTaken)
	{
		SacksTaken = sacksTaken;
	}
	
	public void setSackYards(int sackYards)
	{
		SackYards = sackYards;
	}
	
	public void setRushingAttempts(int rushingAttempts)
	{
		RushingAttempts = rushingAttempts;
	}
	
	public void setRushingYards(int rushingYards)
	{
		RushingYards = rushingYards;
	}
	
	public void setRushingYardsLong(int rushingYardsLong)
	{
		RushingYardsLong = rushingYardsLong;
	}
	
	public void setRushingTouchdowns(int rushingTouchdowns)
	{
		RushingTouchdowns = rushingTouchdowns;
	}
	
	public void setFumbles(int fumbles)
	{
		Fumbles = fumbles;
	}
	
	public void setFumblesLost(int fumblesLost)
	{
		FumblesLost = fumblesLost;
	}
	
	public void setReceptions(int receptions)
	{
		Receptions = receptions;
	}
	
	public void setReceivingYards(int receivingYards)
	{
		ReceivingYards = receivingYards;
	}
	
	public void setReceivingTouchdowns(int receivingTouchdowns)
	{
		ReceivingTouchdowns = receivingTouchdowns;
	}
	
	// Getter methods
	// Gross statistics
	public int getPassingCompletions()
	{
		return PassingCompletions;
	}
	
	public int getPassingAttempts()
	{
		return PassingAttempts;
	}
	
	public int getPassingYards()
	{
		return PassingYards;
	}
	
	public int getPassingTouchdowns()
	{
		return PassingTouchdowns;
	}
	
	public int getPassingInterceptions()
	{
		return PassingInterceptions;
	}
	
	public int getSacksTaken()
	{
		return SacksTaken;
	}
	
	public int getSackYards()
	{
		return SackYards;
	}
	
	public int getRushingAttempts()
	{
		return RushingAttempts;
	}
	
	public int getRushingYards()
	{
		return RushingYards;
	}
	
	public int getRushingYardsLong()
	{
		return RushingYardsLong;
	}
	
	public int getRushingTouchdowns()
	{
		return RushingTouchdowns;
	}
	
	public int getFumbles()
	{
		return Fumbles;
	}
	
	public int getFumblesLost()
	{
		return FumblesLost;
	}
	
	public int getReceptions()
	{
		return Receptions;
	}
	
	public int getReceivingYards()
	{
		return ReceivingYards;
	}
	
	public int getReceivingTouchdowns()
	{
		return ReceivingTouchdowns;
	}
	
	// Calculated statistics
	public double getPassingCompletionPercentage()
	{
		double PassingCompletionPercentage = ((double)PassingCompletions / PassingAttempts) * 100;
		return PassingCompletionPercentage;
	}
	
	public double getPassingYardsPerAttempt()
	{
		double PassingYardsPerAttempt = (double)PassingYards / PassingAttempts;
		return PassingYardsPerAttempt;
	}
	
	public double getQuarterbackRating()
	{
		double QuarterbackRating = calculateQuarterbackRating(PassingCompletions, PassingAttempts, PassingTouchdowns,
				PassingInterceptions, PassingYards);
		return QuarterbackRating;
	}
	
	public double getRushingYardsAverage()
	{
		double RushingYardsAverage = (double)RushingYards / (double)RushingAttempts;
		return RushingYardsAverage;
	}
	
	public double getReceivingYardsAverage()
	{
		double ReceivingYardsAverage = (double)ReceivingYards / (double)Receptions;
		return ReceivingYardsAverage;
	}
	

	//QB rating helper method, not to be used as a getter
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
	private int SoloTackles;
	private int TackleAssists;
	// private int TotalTackles; // = SoloTackles + TackleAssists
	private double Sacks; // Double type to account for half sacks

	// Defensive passing stats
	private int PassesDefended;
	private int Interceptions;
	private int InterceptionReturnYards;
	private int InterceptionReturnLong; // Longest interception return for the season
	private int InterceptionTouchdowns;

	// Fumble stats
	private int ForcedFumbles;
	private int RecoveredFumbles;
	private int FumbleTouchdowns;

	// Misc stats
	private int Safeties;

	// Assign default values to all properties to avoid null values
	public DefensiveStats()
	{
		SoloTackles = 0;
		TackleAssists = 0;
		// TotalTackles = 0;
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
		// TotalTackles = SoloTackles + TackleAssists;
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
	
	// Setter methods
	public void setSoloTackles(int soloTackles)
	{
		SoloTackles = soloTackles;
	}

	public void setTackleAssists(int tackleAssists)
	{
		TackleAssists = tackleAssists;
	}

	public void setSacks(double sacks)
	{
		Sacks = sacks;
	}

	public void setPassesDefended(int passesDefended)
	{
		PassesDefended = passesDefended;
	}

	public void setInterceptions(int interceptions)
	{
		Interceptions = interceptions;
	}

	public void setInterceptionReturnYards(int interceptionReturnYards)
	{
		InterceptionReturnYards = interceptionReturnYards;
	}

	public void setInterceptionReturnLong(int interceptionReturnLong)
	{
		InterceptionReturnLong = interceptionReturnLong;
	}

	public void setInterceptionTouchdowns(int interceptionTouchdowns)
	{
		InterceptionTouchdowns = interceptionTouchdowns;
	}

	public void setForcedFumbles(int forcedFumbles)
	{
		ForcedFumbles = forcedFumbles;
	}

	public void setFumbleTouchdowns(int fumbleTouchdowns)
	{
		FumbleTouchdowns = fumbleTouchdowns;
	}

	public void setRecoveredFumbles(int recoveredFumbles)
	{
		RecoveredFumbles = recoveredFumbles;
	}

	public void setSafeties(int safeties)
	{
		Safeties = safeties;
	}
	
	// Getter methods
	// Gross statistics
	public int getSoloTackles()
	{
		return SoloTackles;
	}
	
	public int getTackleAssists()
	{
		return TackleAssists;
	}
	
	public double getSacks()
	{
		return Sacks;
	}
	
	public int getPassesDefended()
	{
		return PassesDefended;
	}
	
	public int getInterceptions()
	{
		return Interceptions;
	}
	
	public int getInterceptionReturnYards()
	{
		return InterceptionReturnYards;
	}
	
	public int getInterceptionReturnLong()
	{
		return InterceptionReturnLong;
	}
	
	public int getInterceptionTouchdowns()
	{
		return InterceptionTouchdowns;
	}
	
	public int getForcedFumbles()
	{
		return ForcedFumbles;
	}
	
	public int getFumbleTouchdowns()
	{
		return FumbleTouchdowns;
	}
	
	public int getRecoveredFumbles()
	{
		return RecoveredFumbles;
	}
	
	public int getSafeties()
	{
		return Safeties;
	}
	
	// Calculated statistics
	public int getTotalTackles()
	{
		int TotalTackles = SoloTackles + TackleAssists;
		return TotalTackles;
	}
	
}

class SpecialTeamsStats
{
	// Kicker stats
	private int FieldGoalsAttempted;
	private int FieldGoalsMade;
	private int FieldGoalLongMade; // Longest field goal converted for the season
	private int FieldGoalsBlocked;

	// Punter stats
	private int TotalPunts;
	private int PuntYardsGross; // = Total punt yards for the season
	//double PuntYardsGrossAverage; // = PuntYardsGross / TotalPunts
	private int PuntReturnYardsAgainst; // = Total yards the receiving players returned
								// the punts
	private int PuntTouchbacks;
	//int PuntYardsNet; // = PuntYardsGross - PuntReturnYardsAgainst -
						// (PuntTouchbacks * 20)
	//double PuntYardsNetAverage; // = PuntYardsNet / TotalPunts
	int PuntYardsLong; // = Longest punt for the season
	int PuntsInside20; // = Total punts downed inside the 20-yard line
	int PuntsBlocked;

	// Returner stats
	// Kickoff returns
	private int KickoffReturns;
	private int KickoffReturnYards;
	//double KickoffReturnYardsAverage;
	private int KickoffReturnYardsLong;
	private int KickoffReturnTouchdowns;
	private int KickoffReturnFumbles;
	private int KickoffReturnFairCatches;

	// Punt returns
	private int PuntReturns;
	private int PuntReturnYards;
	//double PuntReturnYardsAverage;
	private int PuntReturnYardsLong;
	private int PuntReturnTouchdowns;
	private int PuntReturnFumbles;
	private int PuntReturnFairCatches;

	// Assign default values to all properties to avoid null values
	public SpecialTeamsStats()
	{
		FieldGoalsAttempted = 0;
		FieldGoalsMade = 0;
		FieldGoalLongMade = 0;
		FieldGoalsBlocked = 0;
		TotalPunts = 0;
		PuntYardsGross = 0;
		//PuntYardsGrossAverage = 0;
		PuntReturnYardsAgainst = 0;
		PuntTouchbacks = 0;
		//PuntYardsNet = 0;
		//PuntYardsNetAverage = 0;
		PuntYardsLong = 0;
		PuntsInside20 = 0;
		PuntsBlocked = 0;
		KickoffReturns = 0;
		KickoffReturnYards = 0;
		//KickoffReturnYardsAverage = 0;
		KickoffReturnYardsLong = 0;
		KickoffReturnTouchdowns = 0;
		KickoffReturnFumbles = 0;
		KickoffReturnFairCatches = 0;
		PuntReturns = 0;
		PuntReturnYards = 0;
		//PuntReturnYardsAverage = 0;
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
		//PuntYardsGrossAverage = (double)PuntYardsGross / TotalPunts;
		PuntReturnYardsAgainst = puntReturnYardsAgainst;
		PuntTouchbacks = puntTouchbacks;
		//PuntYardsNet = PuntYardsGross - PuntReturnYardsAgainst - (PuntTouchbacks * 20);
		//PuntYardsNetAverage = (double)PuntYardsNet / totalPunts;
		PuntYardsLong = puntYardsLong;
		PuntsInside20 = puntsInside20;
		PuntsBlocked = puntsBlocked;
		KickoffReturns = kickoffReturns;
		KickoffReturnYards = kickoffReturnYards;
		//KickoffReturnYardsAverage = (double)KickoffReturnYards / KickoffReturns;
		KickoffReturnYardsLong = kickoffReturnYardsLong;
		KickoffReturnTouchdowns = kickoffReturnTouchdowns;
		KickoffReturnFumbles = kickoffReturnFumbles;
		KickoffReturnFairCatches = kickoffReturnFairCatches;
		PuntReturns = puntReturns;
		PuntReturnYards = puntReturnYards;
		//PuntReturnYardsAverage = (double)PuntReturnYards / PuntReturns;
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
		//PuntYardsGrossAverage = (double)PuntYardsGross / TotalPunts;
		PuntReturnYardsAgainst = puntReturnYardsAgainst;
		PuntTouchbacks = puntTouchbacks;
		//PuntYardsNet = PuntYardsGross - PuntReturnYardsAgainst - (PuntTouchbacks * 20);
		//PuntYardsNetAverage = (double)PuntYardsNet / totalPunts;
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
		//KickoffReturnYardsAverage = (double)KickoffReturnYards / KickoffReturns;
		KickoffReturnYardsLong = kickoffReturnYardsLong;
		KickoffReturnTouchdowns = kickoffReturnTouchdowns;
		KickoffReturnFumbles = kickoffReturnFumbles;
		KickoffReturnFairCatches = kickoffReturnFairCatches;
		PuntReturns = puntReturns;
		PuntReturnYards = puntReturnYards;
		//PuntReturnYardsAverage = (double)PuntReturnYards / PuntReturns;
		PuntReturnYardsLong = puntReturnYardsLong;
		PuntReturnTouchdowns = puntReturnTouchdowns;
		PuntReturnFumbles = puntReturnFumbles;
		PuntReturnFairCatches = puntReturnFairCatches;
	}

	// Setter methods
	public void setFieldGoalsAttempted(int fieldGoalsAttempted)
	{
		FieldGoalsAttempted = fieldGoalsAttempted;
	}

	public void setFieldGoalsMade(int fieldGoalsMade)
	{
		FieldGoalsMade = fieldGoalsMade;
	}

	public void setFieldGoalLongMade(int fieldGoalLongMade)
	{
		FieldGoalLongMade = fieldGoalLongMade;
	}
	
	public void setFieldGoalsBlocked(int fieldGoalsBlocked)
	{
		FieldGoalsBlocked = fieldGoalsBlocked;
	}
	
	public void setTotalPunts(int totalPunts)
	{
		TotalPunts = totalPunts;
	}
	
	public void setPuntYardsGross(int puntYardsGross)
	{
		PuntYardsGross = puntYardsGross;
	}
	
	public void setPuntReturnYardsAgainst(int puntReturnYardsAgainst)
	{
		PuntReturnYardsAgainst = puntReturnYardsAgainst;
	}
	
	public void setPuntTouchbacks(int puntTouchbacks)
	{
		PuntTouchbacks = puntTouchbacks;
	}
	
	public void setPuntYardsLong(int puntYardsLong)
	{
		PuntYardsLong = puntYardsLong;
	}
	
	public void setPuntsInside20(int puntsInside20)
	{
		PuntsInside20 = puntsInside20;
	}
	
	public void setPuntsBlocked(int puntsBlocked)
	{
		PuntsBlocked = puntsBlocked;
	}
	
	public void setKickoffReturns(int kickoffReturns)
	{
		KickoffReturns = kickoffReturns;
	}
	
	public void setKickoffReturnYards(int kickoffReturnYards)
	{
		KickoffReturnYards = kickoffReturnYards;
	}
	
	public void setKickoffReturnYardsLong(int kickoffReturnYardsLong)
	{
		KickoffReturnYardsLong = kickoffReturnYardsLong;
	}
	
	public void setKickoffReturnTouchdowns(int kickoffReturnTouchdowns)
	{
		KickoffReturnTouchdowns = kickoffReturnTouchdowns;
	}
	
	public void setKickoffReturnFumbles(int kickoffReturnFumbles)
	{
		KickoffReturnFumbles = kickoffReturnFumbles;
	}
	
	public void setKickoffReturnFairCatches(int kickoffReturnFairCatches)
	{
		KickoffReturnFairCatches = kickoffReturnFairCatches;
	}
	
	public void setPuntReturns(int puntReturns)
	{
		PuntReturns = puntReturns;
	}
	
	public void setPuntReturnYards(int puntReturnYards)
	{
		PuntReturnYards = puntReturnYards;
	}
	
	public void setPuntReturnYardsLong(int puntReturnYardsLong)
	{
		PuntReturnYardsLong = puntReturnYardsLong;
	}
	
	public void setPuntReturnTouchdowns(int puntReturnTouchdowns)
	{
		PuntReturnTouchdowns = puntReturnTouchdowns;
	}
	
	public void setPuntReturnFumbles(int puntReturnFumbles)
	{
		PuntReturnFumbles = puntReturnFumbles;
	}
	
	public void setPuntReturnFairCatches(int puntReturnFairCatches)
	{
		PuntReturnFairCatches = puntReturnFairCatches;
	}
	
	// Getter methods
	// Gross statistics
	public int getFieldGoalsAttempted()
	{
		return FieldGoalsAttempted;
	}

	public int getFieldGoalsMade()
	{
		return FieldGoalsMade;
	}

	public int getFieldGoalLongMade()
	{
		return FieldGoalLongMade;
	}
	
	public int getFieldGoalsBlocked()
	{
		return FieldGoalsBlocked;
	}
	
	public int getTotalPunts()
	{
		return TotalPunts;
	}
	
	public int getPuntYardsGross()
	{
		return PuntYardsGross;
	}
	
	public int getPuntReturnYardsAgainst()
	{
		return PuntReturnYardsAgainst;
	}
	
	public int getPuntTouchbacks()
	{
		return PuntTouchbacks;
	}
	
	public int getPuntYardsLong()
	{
		return PuntYardsLong;
	}
	
	public int getPuntsInside20()
	{
		return PuntsInside20;
	}
	
	public int getPuntsBlocked()
	{
		return PuntsBlocked;
	}
	
	public int getKickoffReturns()
	{
		return KickoffReturns;
	}
	
	public int getKickoffReturnYards()
	{
		return KickoffReturnYards;
	}
	
	public int getKickoffReturnYardsLong()
	{
		return KickoffReturnYardsLong;
	}
	
	public int getKickoffReturnTouchdowns()
	{
		return KickoffReturnTouchdowns;
	}
	
	public int getKickoffReturnFumbles()
	{
		return KickoffReturnFumbles;
	}
	
	public int getKickoffReturnFairCatches()
	{
		return KickoffReturnFairCatches;
	}
	
	public int getPuntReturns()
	{
		return PuntReturns;
	}
	
	public int getPuntReturnYards()
	{
		return PuntReturnYards;
	}
	
	public int getPuntReturnYardsLong()
	{
		return PuntReturnYardsLong;
	}
	
	public int getPuntReturnTouchdowns()
	{
		return PuntReturnTouchdowns;
	}
	
	public int getPuntReturnFumbles()
	{
		return PuntReturnFumbles;
	}
	
	public int getPuntReturnFairCatches()
	{
		return PuntReturnFairCatches;
	}
	
	// Calculated statistics
	public double getPuntYardsGrossAverage()
	{
		double PuntYardsGrossAverage = (double)PuntYardsGross / TotalPunts;
		return PuntYardsGrossAverage;
	}
	
	public int getPuntYardsNet()
	{
		int PuntYardsNet = PuntYardsGross - PuntReturnYardsAgainst - (PuntTouchbacks * 20);
		return PuntYardsNet;
	}
	
	public double getPuntYardsNetAverage()
	{
		double PuntYardsNetAverage =  (double)getPuntYardsNet() / TotalPunts;
		return PuntYardsNetAverage;
	}
	
	public double getKickoffReturnYardsAverage()
	{
		double KickoffReturnYardsAverage = (double)KickoffReturnYards / KickoffReturns;
		return KickoffReturnYardsAverage;
	}
	
	public double getPuntReturnYardsAverage()
	{
		double PuntReturnYardsAverage = (double)PuntReturnYards / PuntReturns;
		return PuntReturnYardsAverage;
	}
}