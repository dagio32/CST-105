import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application
{	
	// Default font
	private static Font defaultFont = new Font("Arial", 12);
	private static Font defaultHeadingFont = new Font("Arial Bold", 12);
	
	// Default strings
	private static String stringButtonName = "Name";
	private static String stringButtonPosition = "Position";
	private static String stringButtonCollege = "College";
	private static String stringSortAscending = " " + (char)11015; // Down arrow
	private static String stringSortDescending = " " + (char)11014; // Up arrow
	
	public static void main(String[] args)
	{
		launch(args);
	}
		
	@Override
	public void start(Stage stage)
	{
		// Name of app
		stage.setTitle("NFL Draft Simulator");
		
		createGrid(stage);
	}
	
	private void createGrid(Stage stage)
	{
		// Create players
		PlayerManager players = new PlayerManager();
		
		// Create grid pane
		GridPane gridPane = new GridPane();

		// Grid padding
		gridPane.setHgap(10);
		gridPane.setVgap(5);
		gridPane.setPadding(new Insets(10, 10, 10, 10));

		/*
		 * // Create headings Label labelName = new Label("Name"); Label labelPosition = new Label("Position"); Label
		 * labelCollege = new Label("College");
		 * 
		 * labelName.setFont(defaultHeadingFont); labelPosition.setFont(defaultHeadingFont);
		 * labelCollege.setFont(defaultHeadingFont);
		 * 
		 * gridPane.add(labelName, 0, 0); gridPane.add(labelPosition, 1, 0); gridPane.add(labelCollege, 2, 0);
		 */

		// Create headings
		Button buttonName = new Button(stringButtonName);
		Button buttonPosition = new Button(stringButtonPosition);
		Button buttonCollege = new Button(stringButtonCollege);

		buttonName.setFont(defaultHeadingFont);
		buttonPosition.setFont(defaultHeadingFont);
		buttonCollege.setFont(defaultHeadingFont);

		gridPane.add(buttonName, 0, 0);
		gridPane.add(buttonPosition, 1, 0);
		gridPane.add(buttonCollege, 2, 0);
		
		// Create scene
		Scene scene = new Scene(gridPane, 640, 640);
		
		// Button actions
		buttonName.setOnAction(event ->
		{
			if (players.getIsSortedAscending())
			{
				players.sortByNameDescending();

				buttonPosition.setText(stringButtonPosition);
				buttonCollege.setText(stringButtonCollege);
				buttonName.setText(stringButtonName + stringSortDescending);
			}
			else
			{
				players.sortByNameAscending();
				
				buttonPosition.setText(stringButtonPosition);
				buttonCollege.setText(stringButtonCollege);
				buttonName.setText(stringButtonName + stringSortAscending);
			}
			
			displayPlayers(stage, gridPane, players, scene);
		});

		buttonPosition.setOnAction(event ->
		{
			if (players.getIsSortedAscending())
			{
				players.sortByPositionDescending();	
				
				buttonName.setText(stringButtonName);
				buttonCollege.setText(stringButtonCollege);
				buttonPosition.setText(stringButtonPosition + stringSortDescending);
			}
			else
			{
				players.sortByPositionAscending();
				
				buttonName.setText(stringButtonName);
				buttonCollege.setText(stringButtonCollege);
				buttonPosition.setText(stringButtonPosition + stringSortAscending);
			}
			
			displayPlayers(stage, gridPane, players, scene);
		});

		buttonCollege.setOnAction(event ->
		{
			if (players.getIsSortedAscending())
			{
				players.sortByCollegeDescending();
				
				buttonName.setText(stringButtonName);
				buttonPosition.setText(stringButtonPosition);
				buttonCollege.setText(stringButtonCollege + stringSortDescending);
			}
			else
			{
				players.sortByCollegeAscending();
				
				buttonName.setText(stringButtonName);
				buttonPosition.setText(stringButtonPosition);
				buttonCollege.setText(stringButtonCollege + stringSortAscending);
			}
			
			displayPlayers(stage, gridPane, players, scene);
		});
		
		// Initial display of players
		displayPlayers(stage, gridPane, players, scene);
	}
	
	private void displayPlayers(Stage stage, GridPane gridPane, PlayerManager players, Scene scene)
	{
		// Temp grid to hold header buttons
		GridPane tempGridPane = new GridPane();
		tempGridPane.add(gridPane.getChildren().get(0), 0, 0);
		tempGridPane.add(gridPane.getChildren().get(0), 1, 0);
		tempGridPane.add(gridPane.getChildren().get(0), 2, 0);
		
		// Clear gridPane
		gridPane.getChildren().clear();
		
		// Add back in the buttons
		gridPane.add(tempGridPane.getChildren().get(0), 0, 0);
		gridPane.add(tempGridPane.getChildren().get(0), 1, 0);
		gridPane.add(tempGridPane.getChildren().get(0), 2, 0);
		
		// Print grid of players
		for (int i = 0; i < players.getNumberOfPlayers(); i++)
		{
			Label currentRowColumn1 = new Label(players.getPlayerInfo(i).getFullName());
			Label currentRowColumn2 = new Label(players.getPlayerInfo(i).getPosition());
			Label currentRowColumn3 = new Label(players.getPlayerInfo(i).getCollege());

			currentRowColumn1.setFont(defaultFont);
			currentRowColumn2.setFont(defaultFont);
			currentRowColumn3.setFont(defaultFont);

			gridPane.add(currentRowColumn1, 0, i + 1);
			gridPane.add(currentRowColumn2, 1, i + 1);
			gridPane.add(currentRowColumn3, 2, i + 1);
		}

		// Update the scene
		stage.setScene(scene);
		stage.show();
	}
}

// Early test code for retrieving player information

/*
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
*/