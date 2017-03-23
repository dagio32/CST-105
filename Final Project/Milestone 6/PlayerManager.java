public class PlayerManager
{
	/*
	 *  This array will hold all the players in the draft.
	 *  Each element in the array represents one player and his career statistics.
	 *  The SeasonStatsList contains as many elements as number of seasons played.
	 *  Season 1 = [0], Season 2 = [1], etc.
	 */
	
	// Arrays that contain all the players in the draft based on their sode of the ball
	private OffensivePlayer[] OffensivePlayersList = new OffensivePlayer[25];
	private DefensivePlayer[] DefensivePlayersList = new DefensivePlayer [22];
	private SpecialTeamsPlayer[] SpecialTeamsPlayersList = new SpecialTeamsPlayer[3];
	
	// Default constructor
	// Creates 50 players
	public PlayerManager()
	{
		CreateOffensivePlayers();
		CreateDefensivePlayers();
		CreateSpecialTeamsPlayers();
	}
	
	// Retrieve info for player at given index
	public OffensivePlayer getOffensivePlayer(int index)
	{
		return OffensivePlayersList[index];
	}
	public DefensivePlayer getDefensivePlayer(int index)
	{
		return DefensivePlayersList[index];
	}
	public SpecialTeamsPlayer getSpecialTeamsPlayer(int index)
	{
		return SpecialTeamsPlayersList[index];
	}
	
	// Total number of players in the draft
	public int getNumberOfPlayers()
	{
		return OffensivePlayersList.length + DefensivePlayersList.length + SpecialTeamsPlayersList.length;
	}

	// Number of offensive players in the draft
	public int getNumberOfOffensivePlayers()
	{
		return OffensivePlayersList.length;
	}
	
	// Number of defensive players in the draft
	public int getNumberOfDefensivePlayers()
	{
		return DefensivePlayersList.length;
	}
	
	// Number of special teams players in the draft
	public int getNumberOfSpecialTeamsPlayers()
	{
		return SpecialTeamsPlayersList.length;
	}
	
	private OffensivePlayer[] CreateOffensivePlayers()
	{
		// Offensive players
		int i = 0; // Start counter at index 0
					// Increase by 1 for each new player
		
		/*
		 * Quarterbacks
		 */
		OffensivePlayersList[i] = new OffensivePlayer("John", "Smith", "Arizona State", "Quarterback", 75, 225, 4.67, 18, 37.0,
				124, 6.80, 4.28);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsQB(2014, 8, 8, 106, 161, 1283, 9, 4, 31, 278, 4,
				14, 4, 1, 8, 5));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsQB(2015, 13, 13, 301, 451, 3858, 36, 18, 38, 325,
				3, 34, 20, 0, 7, 4));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsQB(2016, 14, 14, 340, 517, 4400, 40, 9, 40, 315,
				10, 51, 15, 2, 5, 3));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Joe", "Bailey", "LSU", "Quarterback", 75, 228, 4.93, 12, 27.5, 105, 7.23,
				4.47);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsQB(2015, 12, 12, 364, 573, 4653, 36, 15, 27, 212,
				11, 45, 20, 1, 9, 6));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsQB(2016, 13, 13, 388, 591, 5052, 41, 10, 27, 240,
				8, 30, 7, 0, 8, 5));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Ronald", "Murphy", "Auburn", "Quarterback", 76, 215, 4.87, 11, 25.0, 108,
				8.01, 4.52);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsQB(2014, 4, 3, 93, 175, 1083, 3, 9, 11, 99, 10,
				51, 10, 1, 4, 1));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsQB(2015, 8, 6, 122, 242, 1639, 8, 7, 16, 160, 12,
				60, 12, 0, 5, 2));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsQB(2016, 12, 12, 280, 416, 4363, 37, 7, 18, 168,
				8, 40, 14, 0, 6, 4));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Daniel", "Coleman", "Texas Tech", "Quarterback", 73, 189, 4.38, 15, 30.0,
				110, 6.68, 4.00);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsQB(2015, 12, 12, 241, 431, 3701, 20, 6, 16, 160,
				81, 508, 25, 10, 10, 5));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsQB(2016, 13, 13, 300, 456, 4001, 29, 7, 21, 190,
				108, 675, 40, 8, 6, 3));
		/*
		 *
		 */

		/*
		 * Halfbacks
		 */
		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Henry", "Green", "USC", "Halfback", 69, 186, 4.28, 14, 33.0, 122, 6.48,
				3.89);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2015, 13, 13, 298, 1761, 80, 11, 1, 1, 28,
				298, 3));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2016, 13, 13, 341, 2205, 98, 15, 3, 2, 31,
				308, 4));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Bobby", "Washington", "Georgia", "Halfback", 73, 219, 4.45, 20, 35.0, 118,
				6.85, 4.32);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2015, 12, 10, 281, 1631, 72, 6, 2, 0, 20, 132,
				0));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2016, 12, 12, 349, 1860, 66, 22, 3, 2, 8, 67,
				1));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Craig", "Williams", "Oregon", "Halfback", 69, 180, 4.35, 18, 34.5, 121,
				6.64, 4.25);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2014, 12, 12, 276, 1867, 79, 17, 5, 3, 23,
				160, 0));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2015, 13, 13, 309, 1653, 72, 17, 4, 2, 28,
				416, 3));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2016, 13, 13, 349, 2133, 93, 17, 5, 2, 27,
				231, 0));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Ernest", "Thomas", "Stanford", "Halfback", 72, 240, 4.68, 28, 30.5, 100,
				6.95, 4.58);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2014, 11, 11, 315, 1767, 58, 22, 2, 1, 11, 58,
				0));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2015, 12, 11, 349, 1953, 40, 16, 1, 0, 8, 65,
				0));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2016, 14, 14, 389, 2033, 61, 24, 2, 0, 12,
				108, 0));
		/*
		 *
		 */

		/*
		 * Fullbacks
		 */
		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Barry", "Martin", "Utah", "Fullback", 70, 245, 4.73, 26, 29.5, 98, 6.80,
				4.55);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2014, 1, 0, 1, 3, 3, 0, 0, 0, 0, 0, 0));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2015, 9, 7, 14, 69, 10, 0, 0, 0, 8, 65, 0));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2016, 10, 9, 24, 100, 15, 1, 0, 0, 11, 70, 0));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Victor", "Jenkins", "Clemson", "Fullback", 71, 252, 5.01, 28, 31.5, 100,
				7.15, 4.61);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2014, 12, 0, 25, 91, 12, 1, 0, 0, 3, 8, 0));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsRB(2015, 12, 7, 28, 109, 11, 0, 0, 0, 15, 88, 0));
		OffensivePlayersList[i].SeasonStatsList
				.add(CreateSingleSeasonStatsRB(2016, 13, 11, 24, 100, 15, 1, 1, 1, 21, 161, 1));
		/*
		 *
		 */

		/*
		 * Wide Receivers
		 */
		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Richard", "Patterson", "Michigan", "Wide Receiver", 76, 215, 4.29, 21,
				45.0, 141, 6.59, 3.94);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2015, 13, 13, 2, 0, 128, 1751, 17));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2016, 13, 13, 1, 0, 135, 1980, 20));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Eugene", "Simmons", "UCLA", "Wide Receiver", 77, 242, 4.50, 22, 42.5, 136,
				6.80, 4.15);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2014, 6, 5, 0, 0, 43, 561, 3));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2015, 12, 11, 3, 3, 108, 1284, 8));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2016, 12, 12, 0, 0, 125, 1505, 12));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Michael", "Perez", "Ohio State", "Wide Receiver", 73, 210, 4.39, 15, 39.0,
				130, 6.71, 4.04);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2014, 8, 5, 2, 1, 61, 611, 2));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2015, 10, 9, 3, 1, 98, 1189, 9));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2016, 13, 13, 2, 1, 120, 1401, 11));
		/*
		 *
		 */

		/*
		 * Tight ends
		 */
		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Todd", "Stewart", "Notre Dame", "Tight End", 78, 251, 4.69, 28, 37.5, 108,
				7.25, 4.64);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2014, 11, 11, 2, 2, 61, 598, 3));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2015, 13, 13, 5, 4, 88, 954, 8));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2016, 8, 8, 2, 0, 71, 809, 6));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Benjamin", "Davis", "Arizona", "Tight End", 77, 260, 4.68, 30, 38.5, 105,
				7.31, 4.70);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2015, 13, 13, 0, 0, 91, 1204, 8));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2016, 12, 12, 1, 0, 81, 1000, 7));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Russell", "Hernandez", "Texas", "Tight End", 76, 234, 4.51, 21, 40.0, 112,
				6.99, 4.48);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2014, 8, 0, 0, 0, 11, 85, 0));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2015, 13, 9, 1, 0, 80, 1057, 10));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsWR(2016, 12, 12, 1, 0, 76, 986, 10));
		/*
		 *
		 */

		/*
		 * Offensive linemen
		 */
		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Albert", "Thomas", "Marshall", "Tackle", 79, 329, 5.10, 38, 31.5, 103,
				7.31, 4.55);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2013, 10, 9));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2014, 8, 8));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2015, 13, 13));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2016, 14, 14));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Joseph", "Long", "Wisconsin", "Guard", 76, 309, 4.99, 33, 30.5, 105, 7.21,
				4.49);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2014, 11, 11));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2015, 13, 13));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2016, 14, 14));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Danny", "Daniels", "Kentucky", "Center", 75, 298, 4.85, 32, 32.0, 102,
				7.18, 4.50);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2014, 12, 12));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2015, 11, 11));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2016, 13, 13));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("John", "Peterson", "Florida State", "Tackle", 80, 359, 5.30, 45, 35.5, 109,
				7.71, 4.75);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2013, 14, 14));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2014, 14, 14));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2015, 13, 13));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2016, 14, 14));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Reggie", "Ray", "Arkansas", "Guard", 75, 329, 4.99, 34, 31.5, 99, 7.18,
				4.45);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2013, 3, 0));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2014, 12, 10));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2015, 14, 14));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2016, 10, 10));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Red", "Butler", "Iowa", "Center", 74, 290, 4.75, 28, 30.5, 102, 6.99, 4.40);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2015, 13, 10));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2016, 13, 13));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Fred", "King", "Tennessee", "Tackle", 77, 319, 4.99, 37, 33.5, 105, 7.40,
				4.60);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2014, 6, 0));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2015, 10, 5));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2016, 12, 12));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Stephen", "Gonzales", "Colorado", "Guard", 76, 305, 4.85, 30, 32.5, 101,
				7.24, 4.58);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2013, 5, 0));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2014, 12, 12));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2015, 2, 2));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2016, 11, 11));

		i++;
		OffensivePlayersList[i] = new OffensivePlayer("Clarence", "Erickson", "Nebraska", "Center", 75, 305, 4.80, 29, 31.5, 104,
				7.05, 4.43);
		// Season stats
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2014, 11, 11));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2015, 13, 11));
		OffensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsOL(2016, 12, 12));
		/*
		 *
		 */
		
		return OffensivePlayersList;
	}
	
	private DefensivePlayer[] CreateDefensivePlayers()
	{
		// Defensive players
		int i = 0; // Start counter at index 0
					// Increase by 1 for each new player

		/*
		 * Defensive ends
		 */
		DefensivePlayersList[i] = new DefensivePlayer("Jeremy", "Campbell", "Alabama", "Defensive End", 76, 315, 4.85, 31, 33.5,
				108, 7.01, 4.39);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 11, 11, 51, 22, 11, 3, 1, -1, -1,
				0, 4, 0, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 13, 13, 60, 19, 12, 8, 0, 0, 0, 0,
				3, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 13, 13, 55, 20, 15, 5, 2, 18, 12,
				0, 6, 1, 0, 0));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Gregory", "Williams", "Penn State", "Defensive End", 75, 295, 4.68, 32,
				32.0, 112, 6.79, 4.25);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 12, 12, 41, 18, 9, 5, 0, 0, 0, 0,
				3, 0, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 13, 13, 50, 16, 13, 5, 0, 0, 0, 0,
				4, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 13, 13, 45, 18, 16, 6, 0, 0, 0, 0,
				4, 2, 1, 0));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("James", "Rodgers", "California", "Defensive End", 74, 286, 4.71, 31, 32.5,
				106, 6.89, 4.31);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 13, 13, 41, 16, 7, 8, 0, 0, 0, 0,
				3, 2, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 13, 13, 39, 15, 5, 10, 0, 0, 0, 0,
				5, 4, 0, 0));
		/*
		 *
		 */

		/*
		 * Defensive tackles
		 */
		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Leroy", "Rowe", "Cincinnati", "Defensive Tackle", 76, 328, 4.98, 32, 34.5,
				105, 8.00, 4.59);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 13, 13, 60, 19, 12, 8, 0, 0, 0, 0,
				3, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 13, 13, 55, 20, 15, 5, 2, 18, 12,
				0, 6, 1, 0, 0));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Owen", "Perkins", "Florida", "Defensive Tackle", 77, 295, 4.70, 27, 32.0,
				112, 7.69, 4.45);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 10, 10, 38, 12, 4, 3, 0, 0, 0, 0,
				4, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 13, 13, 49, 15, 5, 3, 0, 0, 0, 0,
				3, 0, 0, 1));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Homer", "Walker", "Georgia Tech", "Defensive Tackle", 74, 286, 4.61, 22,
				32.5, 102, 7.64, 4.35);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2013, 12, 12, 45, 13, 3, 2, 0, 0, 0, 0,
				0, 0, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 10, 10, 30, 10, 1, 4, 0, 0, 0, 0,
				4, 0, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 14, 14, 51, 17, 1, 5, 1, 51, 51, 1,
				3, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 13, 13, 53, 18, 2, 2, 0, 0, 0, 0,
				1, 3, 0, 0));
		/*
		 *
		 */

		/*
		 * Inside linebackers
		 */
		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Troy", "Duncan", "TCU", "Inside Linebacker", 73, 250, 4.78, 28, 39.0, 122,
				6.81, 4.69);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 11, 11, 61, 20, 2, 10, 0, 0, 0, 0,
				1, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 12, 12, 69, 19, 1, 6, 1, 5, 5, 0,
				2, 3, 0, 1));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Lawrence", "Collins", "Washington", "Inside Linebacker", 70, 248, 4.65, 25,
				36.0, 120, 6.79, 4.45);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2013, 10, 2, 56, 22, 1, 7, 2, 25, 20, 0,
				2, 3, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 12, 12, 71, 30, 2, 7, 1, 9, 9, 0,
				3, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 8, 8, 39, 49, 0, 6, 1, 0, 0, 0, 0,
				1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 12, 12, 38, 70, 3, 9, 3, 30, 15, 0,
				2, 2, 0, 0));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Darrell", "Ward", "Boise State", "Inside Linebacker", 74, 238, 4.41, 19,
				39.5, 128, 6.54, 4.28);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2013, 13, 13, 70, 28, 5, 5, 1, 19, 19, 0,
				2, 3, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 13, 13, 72, 28, 4, 7, 0, 0, 0, 0,
				2, 0, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 14, 14, 78, 30, 7, 11, 2, 108, 88,
				1, 2, 1, 0, 0));
		/*
		 *
		 */

		/*
		 * Outside linebackers
		 */
		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Floyd", "Park", "Duke", "Outside Linebacker", 72, 238, 4.48, 21, 36.0, 125,
				6.51, 4.09);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 11, 11, 61, 20, 8, 8, 3, 31, 21, 0,
				3, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 11, 11, 68, 20, 11, 7, 1, 15, 15,
				0, 3, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 12, 12, 71, 22, 10, 9, 2, 75, 70,
				1, 6, 1, 0, 0));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Domingo", "Logan", "Missouri", "Outside Linebacker", 71, 251, 4.60, 24,
				35.0, 118, 6.89, 4.35);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 13, 9, 39, 14, 10, 6, 3, 41, 20, 1,
				2, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 13, 13, 38, 18, 9, 4, 2, 8, 4, 0,
				4, 2, 0, 0));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Malcolm", "Holt", "Purdue", "Outside Linebacker", 74, 240, 4.55, 21, 37.5,
				120, 6.94, 4.22);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2013, 10, 10, 31, 13, 9, 7, 2, 32, 28, 0,
				3, 2, 1, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 13, 13, 50, 18, 12, 5, 0, 0, 0, 0,
				6, 3, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 12, 12, 49, 18, 16, 11, 2, 18, 19,
				1, 5, 5, 2, 0));
		/*
		 *
		 */

		/*
		 * Cornerbacks
		 */
		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Clayton", "Warren", "Tulane", "Cornerback", 75, 190, 4.38, 21, 40.0, 122,
				6.51, 3.98);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 12, 9, 28, 10, 0, 12, 2, 42, 35, 1,
				0, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 12, 12, 31, 15, 0, 15, 5, 0, 0, 0,
				0, 0, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 12, 12, 36, 17, 0, 19, 4, 5, 5, 0,
				0, 0, 0, 0));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Raymond", "Robinson", "Kansas State", "Cornerback", 71, 196, 4.45, 19,
				38.5, 119, 6.69, 4.10);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 10, 10, 30, 10, 0, 8, 4, 80, 45, 0,
				1, 2, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 12, 12, 28, 12, 0, 15, 6, 151, 81,
				1, 0, 0, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 12, 12, 35, 14, 1, 12, 6, 98, 40,
				0, 0, 1, 0, 0));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Ruben", "Schmidt", "Baylor", "Cornerback", 69, 181, 4.42, 21, 37.5, 128,
				6.54, 4.01);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 13, 13, 36, 14, 0, 11, 2, 25, 23,
				0, 0, 2, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 14, 14, 34, 15, 0, 15, 3, 16, 8, 0,
				2, 1, 0, 0));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Nicholas", "Bell", "Miami", "Cornerback", 74, 190, 4.29, 20, 41.5, 132,
				6.44, 3.90);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 13, 13, 41, 13, 0, 16, 2, 60, 50,
				1, 2, 2, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 13, 13, 38, 13, 0, 15, 6, 121, 55,
				1, 0, 0, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 14, 14, 44, 18, 1, 18, 8, 214, 99,
				2, 3, 2, 1, 0));
		/*
		 *
		 */

		/*
		 * Free safeties
		 */
		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Daniel", "Ross", "Syracuse", "Free Safety", 71, 185, 4.45, 18, 41.0, 125,
				6.86, 4.19);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 10, 6, 48, 16, 1, 10, 1, 8, 8, 0,
				0, 0, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 10, 10, 39, 18, 0, 5, 5, 2, 28, 18,
				0, 0, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 11, 11, 52, 21, 2, 11, 3, 49, 29,
				0, 0, 0, 0, 0));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Allan", "Patterson", "NC State", "Free Safety", 72, 205, 4.50, 24, 39.5,
				122, 6.79, 4.26);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 9, 9, 35, 10, 0, 8, 3, 48, 22, 0,
				1, 2, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 12, 12, 38, 12, 0, 10, 1, 15, 15,
				0, 2, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 12, 12, 35, 14, 0, 12, 4, 68, 30,
				0, 1, 2, 0, 0));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Jaime", "Cobb", "Oklahoma", "Free Safety", 74, 197, 4.35, 20, 37.5, 120,
				6.62, 4.08);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 13, 13, 55, 21, 0, 14, 2, 58, 55,
				1, 0, 0, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 14, 14, 61, 31, 0, 18, 5, 91, 48,
				1, 0, 0, 0, 0));
		/*
		 *
		 */

		/*
		 * Strong safeties
		 */
		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Albert", "Martin", "Oregon State", "Strong Safety", 74, 199, 4.46, 20,
				38.0, 118, 6.85, 4.15);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 12, 12, 58, 23, 0, 12, 2, 8, 8, 0,
				0, 0, 0, 1));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 12, 12, 55, 22, 0, 12, 2, 58, 51,
				1, 0, 0, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 12, 12, 61, 28, 0, 9, 4, 40, 20, 0,
				0, 0, 0, 1));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Larry", "Edwards", "Alabama", "Strong Safety", 73, 215, 4.52, 25, 38.0,
				111, 6.88, 4.21);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 14, 14, 46, 22, 1, 12, 0, 48, 22,
				0, 3, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2015, 14, 14, 51, 20, 0, 15, 2, 8, 6, 0,
				2, 0, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 13, 13, 57, 20, 1, 15, 1, 20, 20,
				0, 3, 3, 0, 0));

		i++;
		DefensivePlayersList[i] = new DefensivePlayer("Patrick", "Lee", "Oklahoma State", "Strong Safety", 70, 185, 4.30, 20,
				36.5, 122, 6.55, 3.90);
		// Season stats
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2014, 14, 14, 52, 24, 2, 12, 1, 11, 11,
				0, 2, 1, 0, 0));
		DefensivePlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsDefense(2016, 14, 14, 58, 24, 3, 15, 6, 150, 55,
				2, 2, 2, 0, 0));
		/*
		 *
		 */
		
		return DefensivePlayersList;
	}
	
	private SpecialTeamsPlayer[] CreateSpecialTeamsPlayers()
	{
		// Special teams players
		int i = 0; // Start counter at index 0
					// Increase by 1 for each new player
		
		/*
		 * Punters
		 */
		SpecialTeamsPlayersList[i] = new SpecialTeamsPlayer("Jeffrey", "Garcia", "BYU", "Punter", 74, 178, 4.89, 17, 29.5, 98, 7.95,
				4.56);
		// Season stats
		SpecialTeamsPlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsP(2013, 12, 12, 60, 2728, 62, 11, 15, 0, 508));
		SpecialTeamsPlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsP(2014, 11, 11, 52, 2439, 55, 9, 12, 0, 399));
		SpecialTeamsPlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsP(2015, 12, 12, 59, 2792, 60, 9, 16, 0, 451));
		SpecialTeamsPlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsP(2016, 13, 13, 70, 3242, 59, 12, 20, 0, 511));
		/*
		 *
		 */

		/*
		 * Kickers
		 */
		i++;
		SpecialTeamsPlayersList[i] = new SpecialTeamsPlayer("Billy", "Lopez", "Wake Forest", "Kicker", 68, 168, 5.11, 15, 27.5, 92,
				8.02, 4.64);
		// Season stats
		SpecialTeamsPlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsK(2013, 12, 12, 20, 18, 45, 0));
		SpecialTeamsPlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsK(2014, 13, 13, 30, 25, 46, 0));
		SpecialTeamsPlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsK(2015, 12, 12, 28, 26, 49, 0));
		SpecialTeamsPlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsK(2016, 12, 12, 30, 27, 51, 1));

		i++;
		SpecialTeamsPlayersList[i] = new SpecialTeamsPlayer("Steve", "Cooper", "Louisville", "Kicker", 72, 192, 4.80, 17, 28.0, 95,
				7.96, 4.55);
		// Season stats
		SpecialTeamsPlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsK(2013, 3, 3, 6, 5, 38, 0));
		SpecialTeamsPlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsK(2014, 11, 11, 26, 22, 48, 0));
		SpecialTeamsPlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsK(2015, 13, 13, 28, 26, 58, 0));
		SpecialTeamsPlayersList[i].SeasonStatsList.add(CreateSingleSeasonStatsK(2016, 13, 13, 34, 34, 56, 0));
		/*
		 *
		 */

		return SpecialTeamsPlayersList;
	}

	// Base offensive stats builder
	// Use when building position-specific methods
	private static OffensiveStats CreateSingleSeasonStatsOffense(int year, int gamesPlayed, int gamesStarted,
			int passingCompletions, int passingAttempts, int passingYards, int passingTouchdowns,
			int passingInterceptions, int sacksTaken, int sackYards, int rushingAttempts, int rushingYards,
			int rushingYardsLong, int rushingTouchdowns, int fumbles, int fumblesLost, int receptions,
			int receivingYards, int receivingTouchdowns)
	{
		// OffensiveStats
		OffensiveStats tempSeason = new OffensiveStats(passingCompletions, passingAttempts, passingYards,
				passingTouchdowns, passingInterceptions, sacksTaken, sackYards, rushingAttempts, rushingYards,
				rushingYardsLong, rushingTouchdowns, fumbles, fumblesLost, receptions, receivingYards,
				receivingTouchdowns);
		
		// GenericStats
		tempSeason.setYearNumber(year);
		tempSeason.setGamesPlayed(gamesPlayed);
		tempSeason.setGamesStarted(gamesStarted);
		
		return tempSeason;
	}

	// Quarterback
	private static OffensiveStats CreateSingleSeasonStatsQB(int year, int gamesPlayed, int gamesStarted,
			int passingCompletions, int passingAttempts, int passingYards, int passingTouchdowns,
			int passingInterceptions, int sacksTaken, int sackYards, int rushingAttempts, int rushingYards,
			int rushingYardsLong, int rushingTouchdowns, int fumbles, int fumblesLost)
	{
		// OffensiveStats
		OffensiveStats tempSeason = new OffensiveStats(passingCompletions, passingAttempts, passingYards,
				passingTouchdowns, passingInterceptions, sacksTaken, sackYards, rushingAttempts, rushingYards,
				rushingYardsLong, rushingTouchdowns, fumbles, fumblesLost);
		
		// GenericStats
		tempSeason.setYearNumber(year);
		tempSeason.setGamesPlayed(gamesPlayed);
		tempSeason.setGamesStarted(gamesStarted);

		return tempSeason;
	}

	// Running back
	private static OffensiveStats CreateSingleSeasonStatsRB(int year, int gamesPlayed, int gamesStarted,
			int rushingAttempts, int rushingYards, int rushingYardsLong, int rushingTouchdowns, int fumbles,
			int fumblesLost, int receptions, int receivingYards, int receivingTouchdowns)
	{
		// OffensiveStats
		OffensiveStats tempSeason = new OffensiveStats(rushingAttempts, rushingYards, rushingYardsLong,
				rushingTouchdowns, fumbles, fumblesLost, receptions, receivingYards, receivingTouchdowns);
		
		// GenericStats
		tempSeason.setYearNumber(year);
		tempSeason.setGamesPlayed(gamesPlayed);
		tempSeason.setGamesStarted(gamesStarted);
		
		return tempSeason;
	}

	// Wide receiver
	private static OffensiveStats CreateSingleSeasonStatsWR(int year, int gamesPlayed, int gamesStarted, int fumbles,
			int fumblesLost, int receptions, int receivingYards, int receivingTouchdowns)
	{
		// OffensiveStats
		OffensiveStats tempSeason = new OffensiveStats(fumbles, fumblesLost, receptions, receivingYards,
				receivingTouchdowns);
		
		// GenericStats
		tempSeason.setYearNumber(year);
		tempSeason.setGamesPlayed(gamesPlayed);
		tempSeason.setGamesStarted(gamesStarted);
		
		return tempSeason;
	}

	// O-linemen
	private static OffensiveStats CreateSingleSeasonStatsOL(int year, int gamesPlayed, int gamesStarted)
	{
		OffensiveStats tempSeason = new OffensiveStats();
		
		// GenericStats
		tempSeason.setYearNumber(year);
		tempSeason.setGamesPlayed(gamesPlayed);
		tempSeason.setGamesStarted(gamesStarted);
		
		return tempSeason;
	}

	// Base defensive stats builder
	// Use when building position-specific methods
	private static DefensiveStats CreateSingleSeasonStatsDefense(int year, int gamesPlayed, int gamesStarted,
			int soloTackles, int tackleAssists, int sacks, int passesDefended, int interceptions,
			int interceptionReturnYards, int interceptionReturnLong, int interceptionTouchdowns, int forcedFumbles,
			int recoveredFumbles, int fumbleTouchdowns, int safeties)
	{
		// DefensiveStats
		DefensiveStats tempSeason = new DefensiveStats(soloTackles, tackleAssists, sacks, passesDefended,
				interceptions, interceptionReturnYards, interceptionReturnLong, interceptionTouchdowns, forcedFumbles,
				recoveredFumbles, fumbleTouchdowns, safeties);
		
		// GenericStats
		tempSeason.setYearNumber(year);
		tempSeason.setGamesPlayed(gamesPlayed);
		tempSeason.setGamesStarted(gamesStarted);
		
		return tempSeason;
	}

	// Base special teams stats builder
	// Use when building position-specific methods
	private static SpecialTeamsStats CreateSingleSeasonStatsSpecialTeams(int year, int gamesPlayed, int gamesStarted,
			int fieldGoalsAttempted, int fieldGoalsMade, int fieldGoalLongMade, int fieldGoalsBlocked, int totalPunts,
			int puntYardsGross, int puntYardsLong, int puntTouchbacks, int puntsInside20, int puntsBlocked,
			int puntReturnYardsAgainst, int kickoffReturns, int kickoffReturnYards, int kickoffReturnYardsLong,
			int kickoffReturnTouchdowns, int kickoffReturnFumbles, int kickoffReturnFairCatches, int puntReturns,
			int puntReturnYards, int puntReturnYardsLong, int puntReturnTouchdowns, int puntReturnFumbles,
			int puntReturnFairCatches)
	{
		// SpecialTeamsStats
		SpecialTeamsStats tempSeason = new SpecialTeamsStats(fieldGoalsAttempted, fieldGoalsMade,
				fieldGoalLongMade, fieldGoalsBlocked, totalPunts, puntYardsGross, puntYardsLong, puntTouchbacks,
				puntsInside20, puntsBlocked, puntReturnYardsAgainst, kickoffReturns, kickoffReturnYards,
				kickoffReturnYardsLong, kickoffReturnTouchdowns, kickoffReturnFumbles, kickoffReturnFairCatches,
				puntReturns, puntReturnYards, puntReturnYardsLong, puntReturnTouchdowns, puntReturnFumbles,
				puntReturnFairCatches);
		
		// GenericStats
		tempSeason.setYearNumber(year);
		tempSeason.setGamesPlayed(gamesPlayed);
		tempSeason.setGamesStarted(gamesStarted);

		return tempSeason;
	}

	// Kicker
	private static SpecialTeamsStats CreateSingleSeasonStatsK(int year, int gamesPlayed, int gamesStarted,
			int fieldGoalsAttempted, int fieldGoalsMade, int fieldGoalLongMade, int fieldGoalsBlocked)
	{
		// SpecialTeamsStats
		SpecialTeamsStats tempSeason = new SpecialTeamsStats(fieldGoalsAttempted, fieldGoalsMade,
				fieldGoalLongMade, fieldGoalsBlocked);
		
		// GenericStats
		tempSeason.setYearNumber(year);
		tempSeason.setGamesPlayed(gamesPlayed);
		tempSeason.setGamesStarted(gamesStarted);
		
		return tempSeason;
	}

	// Punter
	private static SpecialTeamsStats CreateSingleSeasonStatsP(int year, int gamesPlayed, int gamesStarted, int totalPunts,
			int puntYardsGross, int puntYardsLong, int puntTouchbacks, int puntsInside20, int puntsBlocked,
			int puntReturnYardsAgainst)
	{
		// SpecialTeamsStats
		SpecialTeamsStats tempSeason = new SpecialTeamsStats(totalPunts, puntYardsGross, puntYardsLong,
				puntTouchbacks, puntsInside20, puntsBlocked, puntReturnYardsAgainst);
		
		// GenericStats
		tempSeason.setYearNumber(year);
		tempSeason.setGamesPlayed(gamesPlayed);
		tempSeason.setGamesStarted(gamesStarted);
		
		return tempSeason;
	}

	// Returner
	private static SpecialTeamsStats CreateSingleSeasonStatsRET(int year, int gamesPlayed, int gamesStarted,
			int kickoffReturns, int kickoffReturnYards, int kickoffReturnYardsLong, int kickoffReturnTouchdowns,
			int kickoffReturnFumbles, int kickoffReturnFairCatches, int puntReturns, int puntReturnYards,
			int puntReturnYardsLong, int puntReturnTouchdowns, int puntReturnFumbles, int puntReturnFairCatches)
	{
		// SpecialTeamsStats
		SpecialTeamsStats tempSeason = new SpecialTeamsStats(kickoffReturns, kickoffReturnYards,
				kickoffReturnYardsLong, kickoffReturnTouchdowns, kickoffReturnFumbles, kickoffReturnFairCatches,
				puntReturns, puntReturnYards, puntReturnYardsLong, puntReturnTouchdowns, puntReturnFumbles,
				puntReturnFairCatches);
		
		// GenericStats
		tempSeason.setYearNumber(year);
		tempSeason.setGamesPlayed(gamesPlayed);
		tempSeason.setGamesStarted(gamesStarted);
		
		return tempSeason;
	}
}