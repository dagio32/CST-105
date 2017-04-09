/**
 * 
 * Pro Football Draft Simulator
 * 
 * This application displays a list of players in the draft and allows
 * the user to view that player's statistics, draft them to their team,
 * or remove them from their roster.  Players can be filtered by their
 * position or searched by their name.  Searches are not case sensitive.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application
{	
	// Default font
	private final static Font defaultFont = new Font("Arial", 12);
	private final static Font defaultHeadingFont = new Font("Arial Bold", 12);
	
	// Default strings
	private final static String stringButtonName = "Name";
	private final static String stringButtonPosition = "Position";
	private final static String stringButtonCollege = "College";
	private final static String stringButtonIsDrafted = "Drafted";
	private final static String stringSortAscending = " " + (char)11015; // Down arrow
	private final static String stringSortDescending = " " + (char)11014; // Up arrow
	
	// For searching by player's name, default to blank String
	private static String positionFilter = "";
	private static String searchFilter = "";
	
	// Create grid pane
	private static GridPane gridPane = new GridPane();
	// Create HBox to hold header (title and search box)
	private static HBox headerBox = new HBox();
	// Create HBox to hold footer buttons
	private static HBox footerBox = new HBox();
	// Create VBox to hold all panes
	private static VBox vBox = new VBox();
	
	public static void main(String[] args)
	{
		launch(args);
	}
		
	@Override
	public void start(Stage stage)
	{
		// Name of app
		stage.setTitle("Pro Football Draft Simulator");
		
		// Disable resizing the window
		stage.setResizable(false);

		// Create VBox to hold all panes
		VBox vBoxTitle = new VBox();
		
		// Create scene
		Scene scene = new Scene(vBoxTitle, 480, 640);
		
		// Title Screen
		VBox titleScreen = new VBox();
		
		// Title image
		Image image = new Image("title.png");
		ImageView imageTitle = new ImageView();
		imageTitle.setImage(image);
		
		titleScreen.getChildren().addAll(imageTitle);
		titleScreen.setAlignment(Pos.CENTER);
		
		// Enter draft button
		Button buttonEnterDraft = new Button("Enter Draft");
		buttonEnterDraft.setFont(defaultHeadingFont);
		
		buttonEnterDraft.setOnAction(event ->
		{
			// Display the draft
			createGrid(stage);
		});
		
		// Add all items to vBox
		vBoxTitle.getChildren().addAll(titleScreen, buttonEnterDraft);
		vBoxTitle.setSpacing(10);
		vBoxTitle.setAlignment(Pos.CENTER);
		
		updateScene(stage, scene);
	}

	private void createGrid(Stage stage)
	{
		// Create players
		PlayerManager players = new PlayerManager();
		
		// Create scene
		Scene scene = new Scene(vBox, 480, 640);
		
		// Filter by position
		ChoiceBox<String> choiceBoxPosition = new ChoiceBox<>();
		choiceBoxPosition.getItems().add("All Players");
		choiceBoxPosition.getItems().add("Quarterback");
		choiceBoxPosition.getItems().add("Halfback");
		choiceBoxPosition.getItems().add("Fullback");
		choiceBoxPosition.getItems().add("Wide Receiver");
		choiceBoxPosition.getItems().add("Tight End");
		choiceBoxPosition.getItems().add("Offensive Tackle");
		choiceBoxPosition.getItems().add("Guard");
		choiceBoxPosition.getItems().add("Center");
		choiceBoxPosition.getItems().add("Defensive End");
		choiceBoxPosition.getItems().add("Defensive Tackle");
		choiceBoxPosition.getItems().add("Inside Linebacker");
		choiceBoxPosition.getItems().add("Outside Linebacker");
		choiceBoxPosition.getItems().add("Cornerback");
		choiceBoxPosition.getItems().add("Free Safety");
		choiceBoxPosition.getItems().add("Strong Safety");
		choiceBoxPosition.getItems().add("Kicker");
		choiceBoxPosition.getItems().add("Punter");
		choiceBoxPosition.setValue("All Players");
		Button buttonPositionFilter = new Button("Filter");
		
		// Used to separate search and position filter
		Label headerWhiteSpace = new Label(" ");
		
		// Search box at the top
		TextField textFieldSearch = new TextField();
		textFieldSearch.setMaxWidth(130);
		textFieldSearch.setPromptText("Search by name");
		Button buttonSearch = new Button("Search");
		Button buttonClear = new Button("Clear");
		
		// Add in header items
		headerBox.getChildren().addAll(choiceBoxPosition, buttonPositionFilter, headerWhiteSpace, textFieldSearch, buttonSearch, buttonClear);
		headerBox.setAlignment(Pos.CENTER);
		headerBox.setSpacing(10);
		headerBox.setPadding(new Insets(10, 10, 10, 10));
		
		// Create scroll pane, add in gridPane
		ScrollPane playerScrollPane = new ScrollPane();
		playerScrollPane.setPrefHeight(640);
		playerScrollPane.setContent(gridPane);
		playerScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		playerScrollPane.setFitToHeight(true);
		playerScrollPane.setVmax(480);
		playerScrollPane.setFitToWidth(true);
		playerScrollPane.setFitToHeight(true);
		
		// Footer button settings
		footerBox.setAlignment(Pos.CENTER);
		footerBox.setSpacing(30);
		footerBox.setPadding(new Insets(10, 10, 10, 10));
		
		// Grid padding
		//gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(2);
		gridPane.setPadding(new Insets(10, 10, 10, 10));

		// Create headings
		Button buttonName = new Button(stringButtonName);
		Button buttonPosition = new Button(stringButtonPosition);
		Button buttonCollege = new Button(stringButtonCollege);
		Button buttonIsDrafted = new Button(stringButtonIsDrafted);

		buttonName.setFont(defaultHeadingFont);
		buttonPosition.setFont(defaultHeadingFont);
		buttonCollege.setFont(defaultHeadingFont);
		buttonIsDrafted.setFont(defaultHeadingFont);

		gridPane.add(buttonName, 1, 0);
		gridPane.add(buttonPosition, 2, 0);
		gridPane.add(buttonCollege, 3, 0);
		gridPane.add(buttonIsDrafted, 4, 0);
			
		// Add all items to vBox
		vBox.getChildren().addAll(headerBox, playerScrollPane, footerBox);
		
		// Button actions
		// Filter by position
		buttonPositionFilter.setOnAction(event ->
		{
			positionFilter = choiceBoxPosition.getValue().toString();
			
			// Convert "All Players" to a blank position filter
			// All others will match the player's position
			if (positionFilter == "All Players")
			{
				positionFilter = "";
			}
			
			displayPlayers(stage, gridPane, players, scene);
		});
		
		// Search by name
		buttonSearch.setOnAction(event ->
		{
			// Convert to lower case to avoid case sensitivity
			searchFilter = textFieldSearch.getText().toLowerCase();

			displayPlayers(stage, gridPane, players, scene);
		});
		
		// Clear search text field
		buttonClear.setOnAction(event ->
		{
			textFieldSearch.setText("");
			searchFilter = "";

			displayPlayers(stage, gridPane, players, scene);
		});
		
		// Sort by name
		buttonName.setOnAction(event ->
		{
			if (players.getIsSortedAscending())
			{
				players.sortByNameDescending();

				buttonPosition.setText(stringButtonPosition);
				buttonCollege.setText(stringButtonCollege);
				buttonIsDrafted.setText(stringButtonIsDrafted);
				buttonName.setText(stringButtonName + stringSortDescending);
			}
			else
			{
				players.sortByNameAscending();
				
				buttonPosition.setText(stringButtonPosition);
				buttonCollege.setText(stringButtonCollege);
				buttonIsDrafted.setText(stringButtonIsDrafted);
				buttonName.setText(stringButtonName + stringSortAscending);
			}
			
			displayPlayers(stage, gridPane, players, scene);
		});

		// Sort by position
		buttonPosition.setOnAction(event ->
		{
			if (players.getIsSortedAscending())
			{
				players.sortByPositionDescending();	
				
				buttonName.setText(stringButtonName);
				buttonCollege.setText(stringButtonCollege);
				buttonIsDrafted.setText(stringButtonIsDrafted);
				buttonPosition.setText(stringButtonPosition + stringSortDescending);
			}
			else
			{
				players.sortByPositionAscending();
				
				buttonName.setText(stringButtonName);
				buttonCollege.setText(stringButtonCollege);
				buttonIsDrafted.setText(stringButtonIsDrafted);
				buttonPosition.setText(stringButtonPosition + stringSortAscending);
			}
			
			displayPlayers(stage, gridPane, players, scene);
		});

		// Sort by college
		buttonCollege.setOnAction(event ->
		{
			if (players.getIsSortedAscending())
			{
				players.sortByCollegeDescending();
				
				buttonName.setText(stringButtonName);
				buttonPosition.setText(stringButtonPosition);
				buttonIsDrafted.setText(stringButtonIsDrafted);
				buttonCollege.setText(stringButtonCollege + stringSortDescending);
			}
			else
			{
				players.sortByCollegeAscending();
				
				buttonName.setText(stringButtonName);
				buttonPosition.setText(stringButtonPosition);
				buttonIsDrafted.setText(stringButtonIsDrafted);
				buttonCollege.setText(stringButtonCollege + stringSortAscending);
			}
			
			displayPlayers(stage, gridPane, players, scene);
		});
		
		// Sort by drafted
		buttonIsDrafted.setOnAction(event ->
		{
			if (players.getIsSortedAscending())
			{
				players.sortByIsDraftedDescending();
				
				buttonName.setText(stringButtonName);
				buttonPosition.setText(stringButtonPosition);
				buttonCollege.setText(stringButtonCollege);
				buttonIsDrafted.setText(stringButtonIsDrafted+ stringSortDescending);
			}
			else
			{
				players.sortByIsDraftedAscending();
				
				buttonName.setText(stringButtonName);
				buttonPosition.setText(stringButtonPosition);
				buttonCollege.setText(stringButtonCollege);
				buttonIsDrafted.setText(stringButtonIsDrafted + stringSortAscending);
			}
			
			displayPlayers(stage, gridPane, players, scene);
		});
		
		// Initial display of players
		displayPlayers(stage, gridPane, players, scene);
	}
	
	private void updateScene(Stage stage, Scene scene)
	{
		// Update the scene
		stage.setScene(scene);
		stage.show();
	}
	
	private void displayPlayers(Stage stage, GridPane gridPane, PlayerManager players, Scene scene)
	{		
		// Temp grid to hold header buttons
		GridPane tempGridPane = new GridPane();
		int column = 1;
		tempGridPane.add(gridPane.getChildren().get(0), column++, 0);
		tempGridPane.add(gridPane.getChildren().get(0), column++, 0);
		tempGridPane.add(gridPane.getChildren().get(0), column++, 0);
		tempGridPane.add(gridPane.getChildren().get(0), column++, 0);
		
		// Clear gridPane
		gridPane.getChildren().clear();
		
		column = 1;
		// Add back in the buttons
		gridPane.add(tempGridPane.getChildren().get(0), column++, 0);
		gridPane.add(tempGridPane.getChildren().get(0), column++, 0);
		gridPane.add(tempGridPane.getChildren().get(0), column++, 0);
		gridPane.add(tempGridPane.getChildren().get(0), column++, 0);
		
		// For grouping radio buttons
		final ToggleGroup group = new ToggleGroup();
		
		// ArrayList of radio buttons
		ArrayList<RadioButton> radioButtons = new ArrayList<>();
		
		// Arrays
		ArrayList<Label> columnName = new ArrayList<>();
		ArrayList<Label> columnPosition = new ArrayList<>();
		ArrayList<Label> columnCollege = new ArrayList<>();
		ArrayList<Label> columnIsDrafted = new ArrayList<>();
		
		int numberPlayersSkipped = 0;
		// Print grid of players
		for (int i = 0; i < players.getNumberOfPlayers(); i++)
		{
			// Check for position and search filters
			// Convert player's name to lower case to avoid case sensitivity
			if (players.getPlayerInfo(i).getPosition().contains(positionFilter)
					&& players.getPlayerInfo(i).getFullName().toLowerCase().contains(searchFilter))
			{
				{
					radioButtons.add(new RadioButton());
					radioButtons.get(i - numberPlayersSkipped).setToggleGroup(group);

					// Radio button ID will match the player's ID
					radioButtons.get(i - numberPlayersSkipped).setId("" + players.getPlayerInfo(i).getPlayerID());

					columnName.add(new Label(players.getPlayerInfo(i).getFullName()));
					columnPosition.add(new Label(players.getPlayerInfo(i).getPosition()));
					columnCollege.add(new Label(players.getPlayerInfo(i).getCollege()));
					columnIsDrafted.add(new Label("" + players.getPlayerInfo(i).getIsDraftedString()));

					columnName.get(i - numberPlayersSkipped).setFont(defaultFont);
					columnPosition.get(i - numberPlayersSkipped).setFont(defaultFont);
					columnCollege.get(i - numberPlayersSkipped).setFont(defaultFont);
					columnIsDrafted.get(i - numberPlayersSkipped).setFont(defaultFont);

					gridPane.add(radioButtons.get(i - numberPlayersSkipped), 0, i + 1 - numberPlayersSkipped);
					gridPane.add(columnName.get(i - numberPlayersSkipped), 1, i + 1 - numberPlayersSkipped);
					gridPane.add(columnPosition.get(i - numberPlayersSkipped), 2, i + 1 - numberPlayersSkipped);
					gridPane.add(columnCollege.get(i - numberPlayersSkipped), 3, i + 1 - numberPlayersSkipped);
					gridPane.add(columnIsDrafted.get(i - numberPlayersSkipped), 4, i + 1 - numberPlayersSkipped);
				}
			}
			else
			{
				numberPlayersSkipped++;
			}
		}
			
		// Create footer buttons
		// Draft Player
		Button buttonDraftPlayer = new Button("Draft Player");
		buttonDraftPlayer.setFont(defaultHeadingFont);
		buttonDraftPlayer.setOnAction(event ->
		{
			try
			{
				// Cast Toggle as RadioButton
				// selectedRadio gets the selected radio button's properties
				RadioButton selectedRadio = (RadioButton)group.getSelectedToggle();
				int selectedPlayerID = Integer.parseInt(selectedRadio.getId());

				if (!players.getPlayerInfoByID(selectedPlayerID).getIsDrafted())
				{
					players.getPlayerInfoByID(selectedPlayerID).celebrate();

					// Set player's draft status to true
					players.getPlayerInfoByID(selectedPlayerID).setIsDrafted(true);
				}
				else
				{
					DialogBox.displayDialogBox("Warning",
							players.getPlayerInfoByID(selectedPlayerID).getFullName() + " has already been drafted.");
				}

				displayPlayers(stage, gridPane, players, scene);
			}
			catch (Exception e)
			{
				// If no radio button is selected
				DialogBox.displayDialogBox("Warning", "No player selected.  Please select a player before drafting.");
				return;
			}
		});
		
		// Remove Player
		Button buttonRemovePlayer = new Button("Remove Player");
		buttonRemovePlayer.setFont(defaultHeadingFont);
		buttonRemovePlayer.setOnAction(event ->
		{
			try
			{
				// Cast Toggle as RadioButton
				// selectedRadio gets the selected radio button's properties
				RadioButton selectedRadio = (RadioButton)group.getSelectedToggle();
				int selectedPlayerID = Integer.parseInt(selectedRadio.getId());

				if (players.getPlayerInfoByID(selectedPlayerID).getIsDrafted())
				{
					// Set player's draft status to false
					players.getPlayerInfoByID(selectedPlayerID).setIsDrafted(false);
				}
				else
				{
					DialogBox.displayDialogBox("Warning", players.getPlayerInfoByID(selectedPlayerID).getFullName()
							+ " is not on the roster and cannot be removed.");
				}

				displayPlayers(stage, gridPane, players, scene);
			}
			catch (Exception e)
			{
				// If no radio button is selected
				DialogBox.displayDialogBox("Warning", "No player selected.  Please select a player before removing.");
				return;
			}
		});
		
		// Player Card
		Button buttonPlayerCard = new Button("Player Card");
		buttonPlayerCard.setFont(defaultHeadingFont);
		buttonPlayerCard.setOnAction(event ->
		{

			try
			{
				// Cast Toggle as RadioButton
				// selectedRadio gets the selected radio button's properties
				RadioButton selectedRadio = (RadioButton)group.getSelectedToggle();
				int selectedPlayerID = Integer.parseInt(selectedRadio.getId());
				String type = players.getPlayerInfoByID(selectedPlayerID).getPlayerType();
				
				switch (type)
				{
				case "Offense":
					PlayerCard.displayOffensivePlayerCard(players.getOffensivePlayerInfoByID(selectedPlayerID));
					break;
				case "Defense":
					PlayerCard.displayDefensivePlayerCard(players.getDefensivePlayerInfoByID(selectedPlayerID));
					break;
				case "Special Teams":
					PlayerCard.displaySpecialTeamsPlayerCard(players.getSpecialTeamsPlayerInfoByID(selectedPlayerID));
					break;
				default:
					PlayerCard.displayOffensivePlayerCard(players.getOffensivePlayerInfoByID(selectedPlayerID));
					break;
				}
			}
			catch (Exception e)
			{
				// If no radio button is selected
				DialogBox.displayDialogBox("Warning", "No player selected.  Please select a player before opening a player card.");
				return;
			}
		});
		
		// End Draft
		Button buttonEndDraft = new Button("End Draft");
		buttonEndDraft.setFont(defaultHeadingFont);
		buttonEndDraft.setOnAction(event ->
		{
			TeamReview.displayTeamReview(players);
		});
		
		// Footer
		footerBox.getChildren().clear();
		footerBox.getChildren().addAll(buttonDraftPlayer, buttonRemovePlayer, buttonPlayerCard, buttonEndDraft);

		// Update the scene
		updateScene(stage, scene);
	}
}