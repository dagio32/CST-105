import java.util.ArrayList;
import java.util.Random;

/*

 Explanation of class design:

 NFLPlayer class will hold base information that applies to all players, such as name,
 height, weight, college, and position.

 Each type of player (OffensivePlayer, DefenisvePlayer, and SpecialTeamsPlayer)
 holds an arrayList of  SeasonStats, which inherits from GenericStats.  This means that
 an offensive player will have statistics unique to offense, as well as generic
 stats that apply to all players, such as year number and games played.

 */

public abstract class NFLPlayer implements Celebrator
{	
	// Used to ID player for sorting methods
	protected int PlayerID;
	
	// Player identity
	protected String FirstName;
	protected String LastName;
	protected String College;
	protected String Position;

	protected int Height;// Inches
	protected int Weight; // Pounds

	// Combine stats
	protected double FortyYardDash; // Seconds
	protected int BenchPressReps; // Number of 225 lb. reps
	protected double VerticalJump; // Inches
	protected int BroadJump; // Inches
	protected double ThreeConeDrill; // Seconds
	protected double ShuttleRun; // Seconds (20-yard shuttle)
	
	// Is player drafted?
	protected boolean IsDrafted;

	// Setter methods
	public void setPlayerID(int playerID)
	{
		PlayerID = playerID;
	}
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
	public int getPlayerID()
	{
		return PlayerID;
	}
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
		return FirstName + " " + LastName;
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
	
	public String getIsDraftedString()
	{
		if (IsDrafted)
		{
			return "X";
		}
		else
		{
			return "";
		}
	}
	
	// To be overridden in the derived classes
	public abstract String getPlayerType();
	
	public abstract String getPlayerSpecialty();
	
	// Helper method for getPlayerSpecialty
	protected String checkCombineSpecialty()
	{
		if (FortyYardDash <= 4.3)
		{
			return "Speedster";
		}
		else if (BenchPressReps >= 30)
		{
			return "Weightlifter";
		}
		// Bigger than 300 lbs
		else if (Weight >= 300)
		{
			return "Big Body";
		}
		// 6'3" and above
		else if (Height >= 75)
		{
			return "Tall Frame";
		}
		else
		{
			return "Undetermined";
		}
	}
	
	// Implementation of Celebrator interface
	// Default celebration
	public void celebrate()
	{
		// Display message in console
		System.out.println(this.getFullName() + " smiles for the cameras!");
	}
	
}

abstract class GenericStats
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

class OffensivePlayer extends NFLPlayer implements Celebrator
{
	ArrayList<OffensiveStats> SeasonStatsList = new ArrayList<OffensiveStats>();

	// Assign default values to all properties to avoid null values
	public OffensivePlayer()
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
	public OffensivePlayer(String firstName, String lastName, String college, String position, int height, int weight,
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
	
	@Override
	public String getPlayerType()
	{
		return "Offense";
	}
	
	@Override
	public String getPlayerSpecialty()
	{
		// 4000 passing yards = 8 interceptions = 1500 rushing yards = 1000 receiving yards
		int passingYards = 0;
		int passingInterceptions = 0;
		int rushingYards = 0;
		int receivingYards = 0;
		int seasonsPlayed = SeasonStatsList.size();
		int baseline = 10;
		
		// Add up career stats
		for (int i = 0; i < seasonsPlayed; i ++)
		{
			passingYards += SeasonStatsList.get(i).getPassingYards();
			passingInterceptions += SeasonStatsList.get(i).getPassingInterceptions(); 
			rushingYards += SeasonStatsList.get(i).getRushingYards();
			receivingYards += SeasonStatsList.get(i).getReceivingYards();
		}
		
		// Calculate season averages
		passingYards /= seasonsPlayed;
		passingInterceptions /= seasonsPlayed;
		rushingYards /= seasonsPlayed;
		receivingYards /= seasonsPlayed;
		
		// Equalize each stat to baseline
		passingYards /= 400; //4000 becomes 10
		passingInterceptions *= 1.25; // 8 becomes 10
		rushingYards /= 150; // 1500 becomes 10
		receivingYards /= 100; // 1000 becomes 10
		
		if (passingYards >= baseline)
		{
			return "Gunslinger";
		}
		// Check for below baseline, if interceptions are low
		// Confirm passing yards are at least half the baseline (otherwise all non-QBs would get Game Manager)
		else if (passingInterceptions <= baseline & passingYards > baseline / 2)
		{
			return "Game Manager";
		}
		else if (rushingYards >= baseline)
		{
			return "Rushing Threat";
		}
		else if (receivingYards >= baseline)
		{
			return "Receiving Threat";
		}
		// If no specialty determined, check for combine results
		else
		{
			return checkCombineSpecialty();	
		}
	}
	
	// Implementation of Celebrator interface
	public void celebrate()
	{
		// Randomly generate a number
		Random random = new Random();
		int numberOfCelebrations = random.nextInt(3);
		
		// To hold the celebration String
		String celebrationText;

		switch (numberOfCelebrations)
		{
		case 0:
			celebrationText = this.getFullName() + " hugs the commissioner in excitement!";
			break;
		case 1:
			celebrationText = this.getFullName() + " begins to shed tears of joy!";
			break;
		default:
			celebrationText = this.getFullName() + " does the Heisman pose!";
			break;
		}

		// Display message in console
		System.out.println(celebrationText);
	}

}

class OffensiveStats extends GenericStats
{
	// Passing stats
	private int PassingCompletions;
	private int PassingAttempts;
	private int PassingYards;
	private int PassingTouchdowns;
	private int PassingInterceptions;
	private int SacksTaken;
	private int SackYards;

	// Rushing stats
	private int RushingAttempts;
	private int RushingYards;
	private int RushingYardsLong; // Longest rush attempt for the season
	private int RushingTouchdowns;
	private int Fumbles;
	private int FumblesLost;

	// Receving stats
	private int Receptions;
	private int ReceivingYards;
	private int ReceivingYardsLong; // Longest reception for the season
	private int ReceivingTouchdowns;

	// Assign default values to all properties to avoid null values
	public OffensiveStats()
	{
		PassingCompletions = 0;
		PassingAttempts = 0;
		PassingYards = 0;
		PassingTouchdowns = 0;
		PassingInterceptions = 0;
		SacksTaken = 0;
		SackYards = 0;
		RushingAttempts = 0;
		RushingYards = 0;
		RushingYardsLong = 0;
		RushingTouchdowns = 0;
		Fumbles = 0;
		FumblesLost = 0;
		Receptions = 0;
		ReceivingYards = 0;
		ReceivingYardsLong = 0;
		ReceivingTouchdowns = 0;
	}

	// Main constructor with all inputs
	public OffensiveStats(int passingCompletions, int passingAttempts, int passingYards, int passingTouchdowns,
			int passingInterceptions, int sacksTaken, int sackYards, int rushingAttempts, int rushingYards,
			int rushingYardsLong, int rushingTouchdowns, int fumbles, int fumblesLost, int receptions,
			int receivingYards, int receivingYardsLong, int receivingTouchdowns)
	{
		PassingCompletions = passingCompletions;
		PassingAttempts = passingAttempts;
		PassingYards = passingYards;
		PassingTouchdowns = passingTouchdowns;
		PassingInterceptions = passingInterceptions;
		SacksTaken = sacksTaken;
		SackYards = sackYards;
		RushingAttempts = rushingAttempts;
		RushingYards = rushingYards;
		RushingYardsLong = rushingYardsLong;
		RushingTouchdowns = rushingTouchdowns;
		Fumbles = fumbles;
		FumblesLost = fumblesLost;
		Receptions = receptions;
		ReceivingYards = receivingYards;
		ReceivingYardsLong = receivingYardsLong;
		ReceivingTouchdowns = receivingTouchdowns;
	}

	// Quarterback constructor with inputs relevant to quarterbacks
	public OffensiveStats(int passingCompletions, int passingAttempts, int passingYards, int passingTouchdowns,
			int passingInterceptions, int sacksTaken, int sackYards, int rushingAttempts, int rushingYards,
			int rushingYardsLong, int rushingTouchdowns, int fumbles, int fumblesLost)
	{
		PassingCompletions = passingCompletions;
		PassingAttempts = passingAttempts;
		PassingYards = passingYards;
		PassingTouchdowns = passingTouchdowns;
		PassingInterceptions = passingInterceptions;
		SacksTaken = sacksTaken;
		SackYards = sackYards;
		RushingAttempts = rushingAttempts;
		RushingYards = rushingYards;
		RushingYardsLong = rushingYardsLong;
		RushingTouchdowns = rushingTouchdowns;
		Fumbles = fumbles;
		FumblesLost = fumblesLost;
	}

	// Running back constructor with inputs relevant to running backs
	public OffensiveStats(int rushingAttempts, int rushingYards, int rushingYardsLong, int rushingTouchdowns,
			int fumbles, int fumblesLost, int receptions, int receivingYards, int receivingYardsLong, int receivingTouchdowns)
	{
		RushingAttempts = rushingAttempts;
		RushingYards = rushingYards;
		RushingYardsLong = rushingYardsLong;
		RushingTouchdowns = rushingTouchdowns;
		Fumbles = fumbles;
		FumblesLost = fumblesLost;
		Receptions = receptions;
		ReceivingYards = receivingYards;
		ReceivingYardsLong = receivingYardsLong;
		ReceivingTouchdowns = receivingTouchdowns;
	}

	// Receiver constructor with inputs relevant to receivers
	public OffensiveStats(int fumbles, int fumblesLost, int receptions, int receivingYards, int receivingYardsLong, int receivingTouchdowns)
	{
		Fumbles = fumbles;
		FumblesLost = fumblesLost;
		Receptions = receptions;
		ReceivingYards = receivingYards;
		ReceivingYardsLong = receivingYardsLong;
		ReceivingTouchdowns = receivingTouchdowns;
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
	
	public void setReceivingYardsLong(int receivingYardsLong)
	{
		ReceivingYardsLong = receivingYardsLong;
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
	
	public int getReceivingYardsLong()
	{
		return ReceivingYardsLong;
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

class DefensivePlayer extends NFLPlayer implements Celebrator
{
	ArrayList<DefensiveStats> SeasonStatsList = new ArrayList<DefensiveStats>();

	// Assign default values to all properties to avoid null values
	public DefensivePlayer()
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
	public DefensivePlayer(String firstName, String lastName, String college, String position, int height, int weight,
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
	
	@Override
	public String getPlayerType()
	{
		return "Defense";
	}

	@Override
	public String getPlayerSpecialty()
	{
		// 10 sacks = 5 interceptions = 5 forced fumbles = 50 tackles
		int sacks = 0;
		int interceptions = 0;
		int forcedFumbles = 0;
		int tackles = 0;
		int seasonsPlayed = SeasonStatsList.size();
		int baseline = 10;
		
		// Add up career stats
		for (int i = 0; i < seasonsPlayed; i ++)
		{
			sacks += SeasonStatsList.get(i).getSacks();
			interceptions += SeasonStatsList.get(i).getInterceptions();
			forcedFumbles += SeasonStatsList.get(i).getForcedFumbles();
			tackles += SeasonStatsList.get(i).getTotalTackles();
		}
		
		// Calculate season averages
		sacks /= seasonsPlayed;
		interceptions /= seasonsPlayed;
		forcedFumbles /= seasonsPlayed;
		tackles /= seasonsPlayed;
		
		// Equalize each stat to baseline
		interceptions *= 2; // 5 becomes 10
		forcedFumbles *= 2; // 5 becomes 10
		tackles /= 5; // 50 becomes 10
		
		if (sacks >= baseline)
		{
			return "Sack Artist";
		}
		else if (interceptions >= baseline)
		{
			return "Ball Hawk";
		}
		else if (forcedFumbles >= baseline)
		{
			return "Fumble Causer";
		}
		else if (tackles >= baseline)
		{
			return "Sure Tackler";
		}
		// Combine stats
		else if (FortyYardDash <= 4.3)
		{
			return "Speedster";
		}
		// If no specialty determined, check for combine results
		else
		{
			return checkCombineSpecialty();	
		}
	}
	
	// Implementation of Celebrator interface
	public void celebrate()
	{
		// Randomly generate a number
		Random random = new Random();
		int numberOfCelebrations = random.nextInt(3);
		
		// To hold the celebration String
		String celebrationText;

		switch (numberOfCelebrations)
		{
		case 0:
			celebrationText = this.getFullName() + " dances with the commissioner!";
			break;
		case 1:
			celebrationText = this.getFullName() + " runs around the room in excitement!";
			break;
		default:
			celebrationText = this.getFullName() + " hugs his mom!";
			break;
		}

		// Display message in console
		System.out.println(celebrationText);
	}
	
}

class DefensiveStats extends GenericStats
{
	// Tackling stats
	private int SoloTackles;
	private int TackleAssists;
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
	public DefensiveStats(int soloTackles, int tackleAssists, double sacks, int passesDefended, int interceptions,
			int interceptionReturnYards, int interceptionReturnLong, int interceptionTouchdowns, int forcedFumbles,
			int recoveredFumbles, int fumbleTouchdowns, int safeties)
	{
		SoloTackles = soloTackles;
		TackleAssists = tackleAssists;
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

class SpecialTeamsPlayer extends NFLPlayer implements Celebrator
{
	ArrayList<SpecialTeamsStats> SeasonStatsList = new ArrayList<SpecialTeamsStats>();

	// Assign default values to all properties to avoid null values
	public SpecialTeamsPlayer()
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
	public SpecialTeamsPlayer(String firstName, String lastName, String college, String position, int height,
			int weight, double fortyYardDash, int benchPressReps, double verticalJump, int broadJump,
			double threeConeDrill, double shuttleRun)
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
	
	private double getCareerFieldGoalPercentage()
	{
		int seasonsPlayed = SeasonStatsList.size();
		int fieldGoalsMade = 0;
		int fieldGoalsAttempted = 0;
		
		// Add up career stats
		for (int i = 0; i < seasonsPlayed; i ++)
		{
			fieldGoalsMade += SeasonStatsList.get(i).getFieldGoalsMade();
			fieldGoalsAttempted += SeasonStatsList.get(i).getFieldGoalsAttempted();
		}
		
		double fieldGoalPercentage = (double)fieldGoalsAttempted / (double)fieldGoalsMade;
		
		return fieldGoalPercentage;
	}
	
	@Override
	public String getPlayerType()
	{
		return "Special Teams";
	}
	
	@Override
	public String getPlayerSpecialty()
	{
		// Base career stats
		// 500 return yards
		// 80% field goal accuracy
		// 55 long field goal
		// 55 long punt
		// 15 punts inside 20
		// Baseline is 10, stats will be equalized below
		
		int returnYards = 0;
		double fieldGoalPercentage = getCareerFieldGoalPercentage();
		int fieldGoalLong = 0;
		int puntsInside20 = 0;
		int puntLong = 0;
		int seasonsPlayed = SeasonStatsList.size();
		int baseline = 10;
		
		// Add up career stats
		for (int i = 0; i < seasonsPlayed; i ++)
		{
			returnYards += SeasonStatsList.get(i).getKickoffReturnYards();
			returnYards += SeasonStatsList.get(i).getPuntReturnYards();
			puntsInside20 += SeasonStatsList.get(i).getPuntsInside20();
			
			// Career field goal long
			if (SeasonStatsList.get(i).getFieldGoalLongMade() > fieldGoalLong)
			{
				fieldGoalLong = SeasonStatsList.get(i).getFieldGoalLongMade();
			}
			
			// Career punt long
			if (SeasonStatsList.get(i).getPuntYardsLong() > puntLong)
			{
				puntLong = SeasonStatsList.get(i).getPuntYardsLong();
			}
		}
		
		
		// Calculate season averages
		returnYards /= seasonsPlayed;
		puntsInside20 /= seasonsPlayed;
		
		// Equalize each stat to baseline
		returnYards /= 50; // 500 becomes 10
		fieldGoalPercentage *= 12.5; // .80 becomes 10
		fieldGoalLong /= 5.5; // 55 becomes 10
		puntsInside20 /= 1.5; // 15 becomes 10
		puntLong /= 5.5; // 55 becomes 10

		if (returnYards >= baseline)
		{
			return "Return Specialist";
		}
		else if (fieldGoalPercentage >= baseline)
		{
			return "Accurate Kicker";
		}
		else if (fieldGoalLong >= baseline)
		{
			return "Power Kicker";
		}
		else if (puntsInside20 >= baseline)
		{
			return "Accurate Punter";
		}
		else if (puntLong >= baseline)
		{
			return "Power Punter";
		}
		// Combine stats
		else if (FortyYardDash <= 4.3)
		{
			return "Speedster";
		}
		// If no specialty determined, check for combine results
		else
		{
			return checkCombineSpecialty();	
		}
	}

	// Implementation of Celebrator interface
	public void celebrate()
	{
		// Randomly generate a number
		Random random = new Random();
		int numberOfCelebrations = random.nextInt(3);
		
		// To hold the celebration String
		String celebrationText;

		switch (numberOfCelebrations)
		{
		case 0:
			celebrationText = this.getFullName() + " can't believe he was actually drafted!";
			break;
		case 1:
			celebrationText = this.getFullName() + " texts all his friends the news!";
			break;
		default:
			celebrationText = this.getFullName() + " can't contain his excitement!";
			break;
		}

		// Display message in console
		System.out.println(celebrationText);
	}
	
}

class SpecialTeamsStats extends GenericStats
{
	// Kicker stats
	private int FieldGoalsAttempted;
	private int FieldGoalsMade;
	private int FieldGoalLongMade; // Longest field goal converted for the season
	private int FieldGoalsBlocked;

	// Punter stats
	private int TotalPunts;
	private int PuntYardsGross; // = Total punt yards for the season
	private int PuntReturnYardsAgainst; // = Total yards the receiving players returned
								// the punts
	private int PuntTouchbacks;
	int PuntYardsLong; // = Longest punt for the season
	int PuntsInside20; // = Total punts downed inside the 20-yard line
	int PuntsBlocked;

	// Returner stats
	// Kickoff returns
	private int KickoffReturns;
	private int KickoffReturnYards;
	private int KickoffReturnYardsLong;
	private int KickoffReturnTouchdowns;
	private int KickoffReturnFumbles;
	private int KickoffReturnFairCatches;

	// Punt returns
	private int PuntReturns;
	private int PuntReturnYards;
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
		PuntReturnYardsAgainst = 0;
		PuntTouchbacks = 0;
		PuntYardsLong = 0;
		PuntsInside20 = 0;
		PuntsBlocked = 0;
		KickoffReturns = 0;
		KickoffReturnYards = 0;
		KickoffReturnYardsLong = 0;
		KickoffReturnTouchdowns = 0;
		KickoffReturnFumbles = 0;
		KickoffReturnFairCatches = 0;
		PuntReturns = 0;
		PuntReturnYards = 0;
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
		PuntReturnYardsAgainst = puntReturnYardsAgainst;
		PuntTouchbacks = puntTouchbacks;
		PuntYardsLong = puntYardsLong;
		PuntsInside20 = puntsInside20;
		PuntsBlocked = puntsBlocked;
		KickoffReturns = kickoffReturns;
		KickoffReturnYards = kickoffReturnYards;
		KickoffReturnYardsLong = kickoffReturnYardsLong;
		KickoffReturnTouchdowns = kickoffReturnTouchdowns;
		KickoffReturnFumbles = kickoffReturnFumbles;
		KickoffReturnFairCatches = kickoffReturnFairCatches;
		PuntReturns = puntReturns;
		PuntReturnYards = puntReturnYards;
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
	public SpecialTeamsStats(int totalPunts, int puntYardsGross, int puntYardsLong,
			int puntTouchbacks, int puntsInside20, int puntsBlocked, int puntReturnYardsAgainst)
	{
		TotalPunts = totalPunts;
		PuntYardsGross = puntYardsGross;
		PuntYardsLong = puntYardsLong;
		PuntTouchbacks = puntTouchbacks;
		PuntsInside20 = puntsInside20;
		PuntsBlocked = puntsBlocked;
		PuntReturnYardsAgainst = puntReturnYardsAgainst;
	}

	// Returner constructor with inputs relevant to returners
	public SpecialTeamsStats(int kickoffReturns, int kickoffReturnYards, int kickoffReturnYardsLong,
			int kickoffReturnTouchdowns, int kickoffReturnFumbles, int kickoffReturnFairCatches, int puntReturns,
			int puntReturnYards, int puntReturnYardsLong, int puntReturnTouchdowns, int puntReturnFumbles,
			int puntReturnFairCatches)
	{
		KickoffReturns = kickoffReturns;
		KickoffReturnYards = kickoffReturnYards;
		KickoffReturnYardsLong = kickoffReturnYardsLong;
		KickoffReturnTouchdowns = kickoffReturnTouchdowns;
		KickoffReturnFumbles = kickoffReturnFumbles;
		KickoffReturnFairCatches = kickoffReturnFairCatches;
		PuntReturns = puntReturns;
		PuntReturnYards = puntReturnYards;
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
	public double getFieldGoalPercentage()
	{
		double FieldGoalPercentage = (double)FieldGoalsMade / FieldGoalsAttempted;
		return FieldGoalPercentage;
	}
	
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