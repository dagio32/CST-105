import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TeamReview
{
	private static int stageWidth = 400;
	private static int stageHeight = 400;
	
	// Default font
	private final static Font defaultFont = new Font("Arial", 16);
	private final static Font defaultHeadingFont = new Font("Arial Bold", 16);
	
	public static void displayTeamReview(PlayerManager players)
	{
		// Create stage
		Stage stage = new Stage();
		
		// Window title		
		stage.setTitle("Team Review");
		
		// Make stage a dialog window
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		
		// vBox to hold everything
		VBox vBox = new VBox();
		
		// Back button
		Button buttonBack = new Button("Back");
		buttonBack.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		buttonBack.setOnAction(event ->
		{
			stage.close();
		});
				
		HBox hBoxHeader = new HBox();
		hBoxHeader.getChildren().add(buttonBack);
		hBoxHeader.setPadding(new Insets(10, 10, 10, 10));
		hBoxHeader.setAlignment(Pos.CENTER);
		
		// Array of players
		ArrayList<Label> playersArray = new ArrayList<>();

		VBox vBoxPlayers = new VBox();
		vBoxPlayers.setPadding(new Insets(10, 10, 10, 10));
		
		Label headingRoster = new Label("Final Roster");
		headingRoster.setFont(defaultHeadingFont);
		
		vBoxPlayers.getChildren().add(headingRoster);
		
		int numberPlayersSkipped = 0;
		// Print grid of players
		for (int i = 0; i < players.getNumberOfPlayers(); i++)
		{
			// Check for position and search filters
			// Convert player's name to lower case to avoid case sensitivity
			if (players.getPlayerInfo(i).IsDrafted)
			{
				{
					playersArray.add(new Label(players.getPlayerInfo(i).getFullName() + " - "
							+ players.getPlayerInfo(i).getPosition() + " - " + players.getPlayerInfo(i).College));

					playersArray.get(i - numberPlayersSkipped).setFont(defaultFont);
					playersArray.get(i - numberPlayersSkipped).setTextAlignment(TextAlignment.CENTER);

					vBoxPlayers.getChildren().add(playersArray.get(i - numberPlayersSkipped));
				}
			}
			else
			{
				numberPlayersSkipped++;
			}
		}
		
		// Check for no players drafted
		if (numberPlayersSkipped == players.getNumberOfPlayers())
		{
			playersArray.add(new Label("No players drafted"));
			playersArray.get(0).setFont(defaultFont);
			playersArray.get(0).setTextAlignment(TextAlignment.CENTER);
			vBoxPlayers.getChildren().add(playersArray.get(0));
		}
		
		vBoxPlayers.setAlignment(Pos.TOP_CENTER);
		
		// Create scroll pane, add in gridPane
		ScrollPane playerScrollPane = new ScrollPane();
		playerScrollPane.setPrefHeight(400);
		playerScrollPane.setContent(vBoxPlayers);
		playerScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		playerScrollPane.setFitToHeight(true);
		playerScrollPane.setVmax(400);
		playerScrollPane.setFitToWidth(true);
		playerScrollPane.setFitToHeight(true);
		
		// Close button
		Button buttonClose = new Button("Close Application");
		buttonClose.setFont(Font.font("SansSerif", FontWeight.BOLD, 14));
		buttonClose.setOnAction(event ->
		{
			System.exit(0);
		});
		
		HBox hBoxFooter = new HBox();
		hBoxFooter.getChildren().add(buttonClose);
		hBoxFooter.setPadding(new Insets(10, 10, 10, 10));
		hBoxFooter.setAlignment(Pos.CENTER);
		
		// Add gridPanes into vBox
		vBox.getChildren().addAll(hBoxHeader, playerScrollPane, hBoxFooter);
		
		// Create scene
		Scene scene = new Scene(vBox, stageWidth, stageHeight);

		// Display the scene
		stage.setScene(scene);
		stage.show();
	}
}