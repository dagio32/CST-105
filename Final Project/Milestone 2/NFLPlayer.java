import java.util.ArrayList;

/*
Explanation of class design:

NFLPlayer class will hold base information that applies to all players, such as name, height, weight, college, and position

SeasonStats holds one season's worth of statistics
This may include both offensive and defensive stats for a player that plays both sides of the ball

SeasonNumber will be an included class for each OffensivePlayer, DefensivePlayer, and SpecialTeamsPlayer
This will have a unique property to specify the YearNumber, as well as generic stats such as GamesPlayed and GamesStarted

OffensivePlayer and DefensivePlayer will include stat categories specific to their side of the ball...
... and will not limit them based on their particular position
For example, quarterbacks may have receiving yards, running backs may have passing stats, receivers may have rushing stats, etc.
This is to account for players who sometimes line up in different positions
The same applies to defensive players, who regardless of their position may still record the same type of statistics

*/

public class NFLPlayer
{
	String FirstName;
	String LastName;
	String College;
	String Position;
	
	ArrayList<SeasonStats> SeasonStatsList = new ArrayList<SeasonStats>();

	//Height is measured in inches
	int Height;
	//Weight is measured in pounds
	int Weight;
	
	//Assign default values to all properties to avoid null values
	public NFLPlayer()
	{
		FirstName = "Generic";
		LastName = "Player";
		College = "None";
		Position = "None";
		Height = 0;
		Weight = 0;
	}
}
class SeasonStats
{
	OffensivePlayer offensivePlayer;
	DefensivePlayer defensivePlayer;
	SpecialTeamsPlayer specialTeamsPlayer;
}
class SeasonNumber
{
	int YearNumber;
	int GamesPlayed;
	int GamesStarted;
	
	//Assign default values to all properties to avoid null values
	public SeasonNumber()
	{
		YearNumber = 0;
		GamesPlayed = 0;
		GamesStarted = 0;
	}
}
class OffensivePlayer
{
	/*
	SeasonNum will specify the particular year these stats are from...
	...as well as include the number of games played and started
	*/
	SeasonNumber SeasonNum;
	
	//Passing stats
	int PassingCompletions;
	int PassingAttempts;
	int PassingYards;
	//PassingYardsPerAttempt = PassingYards / PassingAttempts; 
	double PassingYardsPerAttempt;
	int PassingTouchdowns;
	int PassingInterceptions;
	int SacksTaken;
	int SackYards;
	//QB rating is a double because it requires a decimal
	//Will be calculated automatically using the various passing stats
	double QuarterbackRating;
	
	//Rushing stats
	int RushingAttempts;
	int RushingYards;
	//Longest rush attempt for the season
	int RushingYardsLong;
	int RushingTouchdowns;
	//RushingYardsAverage = RushingYards / RushingAttempts 
	double RushingYardsAverage;
	int Fumbles;
	int FumblesLost;
	
	//Receving stats
	int Receptions;
	int ReceivingYards;
	int ReceivingTouchdowns;
	//ReceivingYardsAverage = ReceivingYards / Receptions  
	double ReceivingYardsAverage;
	
	//Assign default values to all properties to avoid null values
	public OffensivePlayer()
	{
		PassingCompletions = 0;
		PassingAttempts = 0;
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
}
class DefensivePlayer
{
	/*
	SeasonNum will specify the particular year these stats are from...
	...as well as include the number of games played and started
	*/
	SeasonNumber SeasonNum;
	
	//Tackling stats
	int TotalTackles;
	int Tackles;
	int TackleAssists;
	//Sacks will be a double to account for half sacks
	double Sacks;
	
	//Defensive passing stats
	int PassesDefended;
	int Interceptions;
	int InterceptionReturnYards;
	//Longest interception return for the season
	int InterceptionReturnLong;
	
	//Fumble stats
	int ForcedFumbles;
	int RecoveredFumbles;
	
	//Misc stats
	int Safeties;
	
	//Assign default values to all properties to avoid null values
	public DefensivePlayer()
	{
		TotalTackles = 0;
		Tackles = 0;
		TackleAssists = 0;
		Sacks = 0;
		PassesDefended = 0;
		Interceptions = 0;
		InterceptionReturnYards = 0;
		InterceptionReturnLong = 0;
		ForcedFumbles = 0;
		RecoveredFumbles = 0;
		Safeties = 0;
	}
}
class SpecialTeamsPlayer
{
	/*
	SeasonNum will specify the particular year these stats are from...
	...as well as include the number of games played and started
	*/
	SeasonNumber SeasonNum;
	
	//Kicker stats
	int FieldGoalsAttempted;
	int FieldGoalsMade;
	//Longest field goal converted for the season
	int FieldGoalLongMade;
	int FieldGoalsBlocked;
	
	//Punter stats
	int TotalPunts;
	//PuntYardsGross = total punt yards for the season
	int PuntYardsGross;
	//PuntYardsGrossAverage = PuntYardsGross / TotalPunts 
	double PuntYardsGrossAverage;
	//PuntYardsNet = PuntYardsGross - PuntReturnYardsAgainst - (PuntTouchbacks * 20)
	int PuntYardsNet;
	//PuntYardsNetAverage = PuntYardsNet / TotalPunts 
	double PuntYardsNetAverage;
	//PuntYardLong = longest punt for the season
	int PuntYardLong;
	int PuntTouchbacks;
	//PuntsInside20 = total punts downed inside the 20-yard line
	int PuntsInside20;
	int PuntsBlocked;
	//PuntReturnYardsAgainst = total yards the receiving players returned punts for
	//Will be used to calculate PuntYardsNet
	int PuntReturnYardsAgainst;
	
	//Returner stats
	//Kickoff returns
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
	
	//Assign default values to all properties to avoid null values
	public SpecialTeamsPlayer()
	{
		FieldGoalsAttempted = 0;
		FieldGoalsMade = 0;
		FieldGoalLongMade = 0;
		FieldGoalsBlocked = 0;
		TotalPunts = 0;
		PuntYardsGross = 0;
		PuntYardsGrossAverage = 0;
		PuntYardsNet = 0;
		PuntYardsNetAverage = 0;
		PuntYardLong = 0;
		PuntTouchbacks = 0;
		PuntsInside20 = 0;
		PuntsBlocked = 0;
		PuntReturnYardsAgainst = 0;
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
}