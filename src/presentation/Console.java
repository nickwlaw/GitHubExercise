package presentation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Console {
	private static Scanner scanner = new Scanner(System.in);
	
	private final static String REQUIRED_ENTRY_ERROR = "This entry is required. Please try again.";
	private final static String INVALID_NUMBER_ERROR = "Invalid number. Please try again.";
	private final static String EMPTY_STRING = "";
	private final static String PROMPT_CONTINUE = "Play again? (y/n): ";
	private final static Pattern OPTION_AFFIRMATIVE = Pattern.compile("[yY]");
	private final static Pattern OPTION_NEGATIVE = Pattern.compile("[nN]");
	private final static String INVALID_CONTINUE_ERROR = "Please enter \"y\" to continue or \"n\" to quit.";
	
	public static void println(String message) {
		System.out.println(message);
	}

	public static void println(Object object) {
		System.out.println(object);
	}

	public static void print(String message) {
		System.out.print(message);
	}

	public static void print(Object object) {
		System.out.print(object);
	}

	public static void printEmptyLine() {
		System.out.println();
	}
	
	// Prompt user for any string where entry is required
	public static String inputString(String prompt) {
		String userInput = EMPTY_STRING;

		while (userInput.equals(EMPTY_STRING)) {
			System.out.print(prompt);

			userInput = scanner.nextLine().trim();

			if (userInput.equals(EMPTY_STRING)) {
				println(REQUIRED_ENTRY_ERROR);
				continue;
			} else {
				break;
			}
		}

		return userInput;
	}

	// Prompt user for a string matching one of two options
	public static String inputStringOptions(String prompt, String option1, String option2) {
		String userInput = EMPTY_STRING;
		boolean isValid = false;

		while (!isValid) {
			userInput = inputString(prompt);

			if (!userInput.equalsIgnoreCase(option1) && !userInput.equalsIgnoreCase(option2)) {
				println("Please enter " + option1 + " or " + option2 + " to continue.");
			} else {
				isValid = true;
			}
		}

		return userInput;
	}

	// prompt user for any integer value
	public static int inputInt(String prompt) {
		int userInput = 0;
		boolean isValid = false;

		while (!isValid) {
			print(prompt);

			if (scanner.hasNextInt()) {
				userInput = scanner.nextInt();
				isValid = true;
			} else {
				println(INVALID_NUMBER_ERROR);
			}

			scanner.nextLine();
		}

		return userInput;
	}

	// Prompt user for an integer value within a range
	public static int inputIntWithinRangeInclusive(String prompt, int min, int max) {
		int userInput = 0;
		boolean isValid = false;
		
		while (!isValid) {
			userInput = inputInt(prompt);
			
			if (userInput < min || userInput > max) {
				System.out.println("Number must be between " + min + " and " + max + ".");
			} else {
				isValid = true;
			}
		}
		
		return userInput;
	}

	// Prompt user for any double value
	public static double inputDouble(String prompt) {
		double userInput = 0.0;
		boolean isValid = false;
		
		while (!isValid) {
			System.out.print(prompt);
			
			if (scanner.hasNextDouble()) {
				userInput = scanner.nextDouble();
				isValid = true;
			} else {
				System.out.println(INVALID_NUMBER_ERROR);
			}
			
			scanner.nextLine();
		}
		
		return userInput;
	}

	// Prompt user for a double value within a range
	public static double inputDoubleWithinRangeInclusive(String prompt, double min, double max) {
		double userInput = 0;
		boolean isValid = false;
		
		while (!isValid) {
			userInput = inputDouble(prompt);
			
			if (userInput < min || userInput > max) {
				println("Number must be between " + min + " and " + max + ".");
			} else {
				isValid = true;
			}
		}
		
		return userInput;
	}

	// Prompt the user to continue
	public static boolean promptToContinue() {
		
		boolean willContinue = false;
		boolean isGettingInput = true;
		
		while (isGettingInput) {
			print(PROMPT_CONTINUE);
			
			String choice = scanner.next();
			Matcher affirmativeMatcher = OPTION_AFFIRMATIVE.matcher(choice);
			Boolean matchesAffirmative = affirmativeMatcher.matches();
			Matcher negativeMatcher = OPTION_NEGATIVE.matcher(choice);
			Boolean matchesNegative = negativeMatcher.matches();

			if (matchesAffirmative) {
				isGettingInput = false;
				willContinue = true;
				scanner.nextLine();
				printEmptyLine();
			} else if (matchesNegative) {
				isGettingInput = false;
				willContinue = false;
			} else {
				println(INVALID_CONTINUE_ERROR);
			}
		}
		
		return willContinue;
	}
}
