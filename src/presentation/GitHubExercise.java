package presentation;

import students.*;

public class GitHubExercise {

	public static void main(String[] args) {
		printGreeting();

		boolean shouldContinue = true;

		while (shouldContinue) {
			printMenu();

			int input = Console.inputIntWithinRangeInclusive("Which student are you?: ", 1, 9);

			String favoriteFood = "";

			switch (input) {
				case 1:
					favoriteFood = Amy.FAVORITE_FOOD;
					break;
				case 2:
					favoriteFood = Ike.FAVORITE_FOOD;
					break;
				case 3:
					favoriteFood = Steven.FAVORITE_FOOD;
					break;
				case 4:
					favoriteFood = Emily.FAVORITE_FOOD;
					break;
				case 5:
					favoriteFood = Casey.FAVORITE_FOOD;
					break;
				case 6:
					favoriteFood = Jacob.FAVORITE_FOOD;
					break;
				case 7:
					favoriteFood = Trent.FAVORITE_FOOD;
					break;
				case 8:
					favoriteFood = Ted.FAVORITE_FOOD;
					break;
				case 9:
					favoriteFood = James.FAVORITE_FOOD;
					break;
			}

			Console.println("My favorite food is " + favoriteFood);

			shouldContinue = Console.promptToContinue();
		}
		
		Console.println("See ya!");
	}

	private static void printGreeting() {
		Console.println("Hello Java Learners!");
		Console.printEmptyLine();
		Console.println("Today we are going to explore branching and merging with GitHub.");
		Console.println("Each of you have a file assigned to you in Teams.");
		Console.println("You also have a change to that file that you have been asked to make.");
		Console.println("Clone this project to your local repos folder.");
		Console.println("Make a branch according to the branch naming strategy provided to you in Teams.");
		Console.println("Make your changes on your branch.");
		Console.println("Test your branch locally to make sure that it works.");
		Console.println("Push your branch up to GitHub.");
		Console.println("Make a pull request for your branch into the main branch of the repository.");
		Console.printEmptyLine();
		Console.println(
				"I'll either approve your pull request, or I'll ask you to make changes and re-push your branch.");
		Console.println("Note that when you re-push new changes, you do not have to make a new pull request!");
		Console.printEmptyLine();
		Console.println("Good luck, and do not be afraid to ask me or each other for help!");
		Console.printEmptyLine();
	}

	private static void printMenu() {
		Console.println("---MAIN MENU---");
		Console.println("1 - Amy");
		Console.println("2 - Ike");
		Console.println("3 - Steven");
		Console.println("4 - Emily");
		Console.println("5 - Casey");
		Console.println("6 - Jacob");
		Console.println("7 - Trent");
		Console.println("8 - Ted");
		Console.println("9 - James");
	}
}
