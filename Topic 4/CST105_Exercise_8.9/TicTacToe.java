/**
 * 
 * Tic Tac Toe
 * 
 * Plays tic tac toe on the console.  X player begins, and
 * players alternate moves until there is three in a row.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

import java.util.Scanner;

public class TicTacToe
{

	public static void main(String[] args)
	{
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);
		
		// 3 x 3 array containing an array of chars (' ', 'X', or 'O')
		char[][] gameBoard = {{ ' ', ' ', ' '},{ ' ', ' ', ' '},{ ' ', ' ', ' '}};
		
		// Show initial blank game board
		displayCurrentBoard(gameBoard);
		
		// String to hold the name of the winner, either X or O
		String winner = "";
		
		while (!isThreeInARow(gameBoard))
		{
			// Display instructions
			System.out.println("Enter a row (0, 1, or 2) for player X: ");
			int playerXRow = input.nextInt();
			System.out.println("Enter a column (0, 1, or 2) for player X: ");
			int playerXColumn = input.nextInt();
			
			// Check if move row or column exceed 2 or contain a negative
			if (!isMoveValid(playerXRow, playerXColumn))
			{
				System.out.println("Invalid move.  You lose your turn!");
			}
			// If legal move
			else
			{
				// Put X on the board
				if (!isCellTaken(gameBoard, playerXRow, playerXColumn))
				{
					gameBoard[playerXRow][playerXColumn] = 'X';	
				}
				// If cell is occupied
				else
				{
					System.out.println("That cell is already taken.  You lose your turn!");
				}
			}
			
			// Update the game board
			displayCurrentBoard(gameBoard);
			
			// Check for winner
			// If yes, assign winner and break from game loop
			if (isThreeInARow(gameBoard))
			{
				winner = "X";
				break;
			}
			
			// Check for draw
			// If yes, break from game loop
			if (isGameBoardFull(gameBoard))
			{
				winner = "Neither";
				break;
			}
			
			// Display instructions
			System.out.println("Enter a row (0, 1, or 2) for player O: ");
			int playerORow = input.nextInt();
			System.out.println("Enter a column (0, 1, or 2) for player O: ");
			int playerOColumn = input.nextInt();
			
			// Check if move row or column exceed 2 or contain a negative
			if (!isMoveValid(playerORow, playerOColumn))
			{
				System.out.println("Invalid move.  You lose your turn!");
			}
			// If legal move
			else
			{
				// Put O on the board
				if (!isCellTaken(gameBoard, playerORow, playerOColumn))
				{
					gameBoard[playerORow][playerOColumn] = 'O';	
				}
				// If cell is occupied
				else
				{
					System.out.println("That cell is already taken.  You lose your turn!");
				}
			}
			
			// Update the game board
			displayCurrentBoard(gameBoard);
			
			// Check for winner
			// If yes, assign winner and break from game loop
			if (isThreeInARow(gameBoard))
			{
				winner = "O";
				break;
			}
			
		}
		
		// Check winner
		if (winner == "Neither")
		{
			// Display draw
			System.out.println(winner + " player won.  Tie game.");
		}
		else 
		{
			// Display winner
			System.out.println(winner + " player wins!");
		}
	}

	private static boolean isGameBoardFull(char[][] gameBoard)
	{
		for (int row = 0; row < 3; row++)
		{
			for (int column = 0; column < 3; column++)
			{
				if (gameBoard[row][column] == ' ')
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static boolean isMoveValid(int row, int column)
	{
		if (row < 0 || row > 2 || column < 0 || column > 2)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	private static boolean isCellTaken(char[][] gameBoard, int row, int column)
	{
		if (gameBoard[row][column] != ' ')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private static void displayCurrentBoard(char[][] gameBoard)
	{
		System.out.println("   —————————————");
		System.out.println("0  | " + gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2] + " |");
		System.out.println("   —————————————");
		System.out.println("1  | " + gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2] + " |");
		System.out.println("   —————————————");
		System.out.println("2  | " + gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2] + " |");
		System.out.println("   —————————————");
		System.out.println("     0   1   2  ");
		System.out.println("");
	}
	
	private static boolean isThreeInARow(char[][] gameBoard)
	{
		int row = 0;
		int column = 0;
		
		// Check for vertical three in a row
		for (int i = 0; i < 3; i++)
		{
			// If blank tile, move to next iteration
			if (gameBoard[row][i] == ' ')
			{
				continue;
			}
			
			if (gameBoard[row][i] == (gameBoard[row + 1][i])
					&& gameBoard[row][i] == (gameBoard[row + 2][i]))
			{
				return true;
			}
		}
		
		// Check for horizontal three in a row
		for (int i = 0; i < 3; i++)
		{
			// If blank tile, move to next iteration
			if (gameBoard[i][column] == ' ')
			{
				continue;
			}
			
			if (gameBoard[i][column] == (gameBoard[i][column + 1])
					&& gameBoard[i][column] == (gameBoard[i][column + 2]))
			{
				return true;
			}
		}
		
		// Check for diagonal three in a row
		// If middle tile is blank, no three in a row
		if (gameBoard[1][1] == ' ')
		{
			return false;
		}
		
		// If middle tile is not blank
		if (gameBoard[0][0] == (gameBoard[1][1])
				&& gameBoard[0][0] == (gameBoard[2][2]))
		{
			return true;
		}
		if (gameBoard[2][0] == (gameBoard[1][1])
				&& gameBoard[2][0] == (gameBoard[0][2]))
		{
			return true;
		}
		
		// No three in a row
		return false;
	}
	
}
