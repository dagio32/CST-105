/**
 * 
 * Hangman
 * 
 * This game chooses a random word for the user to guess.
 * Each correct guess will display all instances of that letter in the word.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

import java.util.Random;
import java.util.Scanner;

public class Hangman
{

	public static void main(String[] args)
	{
		// Create array to store words
		String[] wordsArray = { "hockey", "football", "basketball", "soccer", "baseball", "rugby", "golf", "boxing",
				"tennis", "cricket", "wrestling", "volleyball" };

		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);
		
		// Starts as true, set to false when user quits
		boolean isPlayingGame = true;
		
		while (isPlayingGame)
		{
			// Display category
			System.out.println("Hint:  The category is sports.");
			
			// Create Random object
			Random random = new Random();
			
			// Randomly select an index of the wordsArray
			String chosenWord = wordsArray[random.nextInt(wordsArray.length)];
			
			// Put asterisks over the word to hide answer
			String currentWord = hideCharacters(chosenWord);
			
			boolean isWordCompleted = false;
			char letterGuess;
			int numberIncorrectGuesses = 0;
			
			// Game loop
			while (!isWordCompleted)
			{
				// Accept input
				System.out.print("(Guess) Enter a letter in word " + currentWord + " > ");
				
				letterGuess = input.nextLine().charAt(0);
				
				// Check for incorrect guess
				if (checkForMiss(chosenWord, letterGuess))
				{
					System.out.println(letterGuess + " is not in the word.");
					numberIncorrectGuesses++;
				}
				// If correct guess
				else
				{
					// Replace all instances of * with the typed character
					currentWord = showCharacters(chosenWord, currentWord, letterGuess);	
				}
				
				// If no more asterisks, game is over
				if (!checkForAsterisks(currentWord))
				{
					isWordCompleted = true;
				}
			}
			
			// Check for plurality in number of incorrect guesses
			String stringTimes = " time";
			if (numberIncorrectGuesses!=1)
				stringTimes = " times";
			
			// Display result
			System.out.println("The word is " + chosenWord + ". You missed " + numberIncorrectGuesses + stringTimes);
			
			// Play again?
			System.out.print("Do you want to guess another word? Enter y or n > ");
			
			// Set as something other than y or n
			char exitConfirmChar = 'z';
			
			// Accept inputs until user types y or n
			while (exitConfirmChar != 'y' && exitConfirmChar != 'n')
			{
				exitConfirmChar = input.nextLine().charAt(0);
				Character.toLowerCase(exitConfirmChar);
				
				if (exitConfirmChar == 'y')
				{
					isPlayingGame = true;
				}
				else if (exitConfirmChar == 'n')
				{
					isPlayingGame = false;
				}
			}
		}
		
		// Close application
		System.exit(0);
	}
	
	private static String hideCharacters(String word)
	{
		String hiddenWord = "";
		for (int i = 0; i < word.length(); i++)
		{
			hiddenWord += '*';
		}
		return hiddenWord;
	}
	
	private static boolean checkForMiss(String chosenWord, char character)
	{
		for (int i = 0; i < chosenWord.length(); i++)
		{
			if (chosenWord.charAt(i) == character)
			{
				return false;
			}
		}
		return true;
	}
	
	private static String showCharacters(String chosenWord, String currentWord, char character)
	{
		// Create a char array to allow for modifying one letter at a time
		char[] modifiedWord = currentWord.toCharArray();
		
		for (int i = 0; i < chosenWord.length(); i++)
		{
			// If the entered character matches the element of the char array
			// Then replace the * with the character
			if (chosenWord.charAt(i) == character)
			{
				modifiedWord[i] = character;
				
				if (currentWord.charAt(i) == character)
				{
					System.out.println("	" + character + " is already in the word");
					break;
				}
			}
		}
		
		// Convert char array to String
		String returnString = new String(modifiedWord);
		
		return returnString;
	}
	
	
	private static boolean checkForAsterisks(String word)
	{
		for (int i = 0; i < word.length(); i++)
		{
			// Found asterisk
			if (word.charAt(i) == '*')
			{
				return true;
			}
		}
		
		// No asterisks
		return false;
	}

}
