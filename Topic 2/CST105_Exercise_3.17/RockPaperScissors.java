//Created by Nicholas Robertson for Grand Canyon University

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	public static void main(String[] args) {
		Random random = new Random();

		//Generate 0-2 number for the computer's move
		int computerMoveNumber = random.nextInt(3);

		// Create a Scanner
		Scanner input = new Scanner(System.in);

		//User enters their move
		System.out.println("Scissor is 0, rock is 1, paper is 2.");
		System.out.println("Enter your choice: ");
		int humanMoveNumber = input.nextInt();

		//Assign move word for each player
		String humanMoveWord = "";
		switch(humanMoveNumber)
		{
		case 0:
			humanMoveWord = "scissor";
			break;
		case 1:
			humanMoveWord = "rock";
			break;
		case 2:
			humanMoveWord = "paper";
			break;
		case 3:
			System.out.println("Invalid number entered.  Exiting program.");
			System.exit(1);
			break;
		}
		
		String computerMoveWord = "";
		switch(computerMoveNumber)
		{
		case 0:
			computerMoveWord = "scissor";
			break;
		case 1:
			computerMoveWord = "rock";
			break;
		case 2:
			computerMoveWord = "paper";
			break;
		}

		//Determine outcome of game
		boolean didPlayerWin = false;
		
		//If move is same
		if (computerMoveNumber == humanMoveNumber)
		{
			System.out.println("The computer is " + computerMoveWord + ". You are " + humanMoveWord + " too. It is a draw.");
		}
		
		//All other scenarios
		else
		{
			//If human is scissor
			if(humanMoveNumber == 0)
			{
				//If computer is rock
				if (computerMoveNumber == 1)
				{
					didPlayerWin = false;
				}
				//If computer is paper
				else
				{
					didPlayerWin = true;
				}
			}
			//If human is rock
			else if(humanMoveNumber == 1)
			{
				//If computer is scissor
				if (computerMoveNumber == 0)
				{
					didPlayerWin = true;
				}
				//If computer is paper
				else
				{
					didPlayerWin = false;
				}
			}
			//If human is paper
			else if(humanMoveNumber == 2)
			{
				//If computer is scissor
				if (computerMoveNumber == 0)
				{
					didPlayerWin = false;
				}
				//If computer is rock
				else
				{
					didPlayerWin = true;
				}
			}
			
			//Print both moves
			System.out.print("The computer is " + computerMoveWord + ". You are " + humanMoveWord + ".");
			
			//Print winner
			if (didPlayerWin)
			{
				System.out.print(" You won.");				
			}
			else
			{
				System.out.print(" You lost.");
			}
		}
	}
}