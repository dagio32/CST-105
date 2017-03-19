import java.util.Scanner;

/**
 * 
 * ATM Class
 * 
 * This application will create 10 accounts and allow the user
 * to access each account.  The user will be able to view each
 * account balance and deposit and withdraw money.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

public class ATM
{
	public static void main(String[] args)
	{
		// Create and initialize array of accounts
		Account[] accountsArray = new Account[10];
		
		for (int i = 0; i < accountsArray.length; i ++)
		{
			accountsArray[i] = new Account(i, 100);	
		}
		
		// Instantiate Scanner named input
		Scanner input = new Scanner(System.in);
		
		// To keep the app constantly running
		boolean appLoop = true;
		while (appLoop)
		{
			// Display instructions
			System.out.println("Enter an ID: ");
			
			int selectedID = 0;
			boolean isValidID = false;
			while (!isValidID)
			{
				String inputString = input.nextLine();

				// Parse the input string
				// -1 if it fails
				selectedID = tryParseInt(inputString);

				// Check for valid ID (between 0 and 9)
				if (selectedID >= 0 && selectedID < accountsArray.length)
				{
					isValidID = true;
				}
				else
				{
					System.out.println("ID not found.  Enter a valid ID (between 0 and " + (accountsArray.length - 1)
							+ "): ");
				}
			}

			boolean isExited = false;
			while (!isExited)
			{
				System.out.println("\r\nMain Menu");
				System.out.println("1: Check balance");
				System.out.println("2: Withdraw");
				System.out.println("3: Deposit");
				System.out.println("4: Exit");
				System.out.print("Enter a choice: ");

				String inputString = input.nextLine();

				// Parse the input string
				// -1 if it fails
				int inputMenuSelection = tryParseInt(inputString);

				// Menu options
				switch (inputMenuSelection)
				{
				case -1:
					System.out.print("Invalid choice.  Enter a number 1-4: ");
					break;
				case 1:
					System.out.println("The balance is " + accountsArray[selectedID].getBalance());
					break;
				case 2:
					System.out.print("Enter an amount to withdraw: ");
					// Parse the input string
					// -1 if it fails
					inputString = input.nextLine();
					int withdrawAmount = tryParseInt(inputString);

					if (withdrawAmount > 0)
					{
						accountsArray[selectedID].withdraw(withdrawAmount);
					}
					else
					{
						System.out.print("Invalid amount.");
					}

					break;
				case 3:
					System.out.print("Enter an amount to deposit: ");
					// Parse the input string
					// -1 if it fails
					inputString = input.nextLine();
					int depositAmount = tryParseInt(inputString);

					if (depositAmount > 0)
					{
						accountsArray[selectedID].deposit(depositAmount);
					}
					else
					{
						System.out.print("Invalid amount.");
					}

					break;
				case 4:
					isExited = true;
					break;
				}
			}
		}

	}
	
	private static int tryParseInt(String parseString)
	{		
		try 
		{
			return Integer.parseInt(parseString);	
		}
		catch (Exception e)
		{
			return -1;
		}
	}

}