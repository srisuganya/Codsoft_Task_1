package numbergame;
import java.util.Random;
import java.util.Scanner;

public class numbergame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int roundScore = 0; // Track the score for the current round
            boolean hasGuessedCorrectly = false;

            System.out.println("\nI have selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                    roundScore = maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            } else {
                totalScore += roundScore;
                System.out.println("\nThanks for playing! Your score for this round is: " + roundScore);
                System.out.println("Total Score: " + totalScore);
            }

            System.out.print("\nDo you want to play again? (Enter 'y' for yes): ");
        } while (scanner.next().equalsIgnoreCase("y"));

        scanner.close();
    }
}
