//Created by Nicholas Robertson for Grand Canyon University

import java.util.Scanner;
import java.util.Random;

public class AddThreeNumbers {
	public static void main(String[] args) {
		Random random = new Random();

		int number1 = random.nextInt(10) + 1;
		int number2 = random.nextInt(10) + 1;
		int number3 = random.nextInt(10) + 1;

		// Create a Scanner
		Scanner input = new Scanner(System.in);

		System.out.print("What is " + number1 + " + " + number2 + " + "
				+ number3 + "? ");

		int answer = input.nextInt();

		System.out.println(number1 + " + " + number2 + " + " + number3 + " = "
				+ answer + " is " + (number1 + number2 + number3 == answer));
	}
}