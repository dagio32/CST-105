/**
 * 
 * Rectanguloid Display
 * 
 * This program will display a cube that dynamically
 * expands and shrinks with the size of the window.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Rectanguloid extends Application
{
	// Create shape objects
	// Needs to be accessible within class
	private static Rectangle upperSquare = new Rectangle(75, 25, 100, 100);
	private static Rectangle lowerSquare = new Rectangle(25, 75, 100, 100);
	
	// LT = Left Top, RB = Left Bottom
	private static Line lineLT = new Line(75, 25, 25, 75);
	private static Line lineRT = new Line(175, 25, 125, 75);
	private static Line lineLB = new Line(75, 125, 25, 175);
	private static Line lineRB = new Line(175, 125, 125, 175);
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		stage.setTitle("Exercise 14.14");
		
		// Set common variables
		Color strokeColor = Color.BLACK;
		int strokeWidth = 1;

		// Build squares
		// Fill is null for transparency
		upperSquare.setFill(null);
		upperSquare.setStroke(strokeColor);
		upperSquare.setStrokeWidth(strokeWidth);
	
		lowerSquare.setFill(null);
		lowerSquare.setStroke(strokeColor);
		lowerSquare.setStrokeWidth(strokeWidth);

		// Create border pane
		BorderPane borderPane = new BorderPane();

		// Add squares and lines to border pane
		borderPane.getChildren().addAll(upperSquare, lowerSquare, lineLT, lineRT, lineLB, lineRB);

		// Create scene
		Scene scene = new Scene(borderPane, 200, 200);
		
		// Display scene
		stage.setScene(scene);
		stage.show();

		// Add listeners for scene height and width
		scene.widthProperty().addListener(listenerWidth);
		scene.heightProperty().addListener(listenerHeight);
	}
	
	// Listeners for scene height and width
	ChangeListener<Number> listenerWidth = new ChangeListener<Number>()
	{
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number xOld, Number xNew)
		{
			// Old X minus new X is how much the X needs to increase for each object 
			double xFinal = xNew.doubleValue() - xOld.doubleValue();

			// Lines on the right will expand right, left will stay put
			lineRT.setStartX(lineRT.getStartX() + xFinal);
			lineRT.setEndX(lineRT.getEndX() + xFinal);
			lineRB.setStartX(lineRB.getStartX() + xFinal);
			lineRB.setEndX(lineRB.getEndX() + xFinal);
			
			// Increase width of squares
			upperSquare.setWidth(upperSquare.getWidth() + xFinal);
			lowerSquare.setWidth(lowerSquare.getWidth() + xFinal);

		}
	};

	ChangeListener<Number> listenerHeight = new ChangeListener<Number>()
	{
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number yOld, Number yNew)
		{
			// Old Y minus new Y is how much the Y needs to increase for each object
			double yFinal = yNew.doubleValue() - yOld.doubleValue();

			// Lines at the bottom will stretch downward
			lineLB.setStartY(lineLB.getStartY() + yFinal);
			lineLB.setEndY(lineLB.getEndY() + yFinal);
			lineRB.setStartY(lineRB.getStartY() + yFinal);
			lineRB.setEndY(lineRB.getEndY() + yFinal);
			
			// Increase height of squares
			upperSquare.setHeight(upperSquare.getHeight() + yFinal);
			lowerSquare.setHeight(lowerSquare.getHeight() + yFinal);
		}
	};

}
