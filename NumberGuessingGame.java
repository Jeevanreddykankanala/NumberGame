import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int secretNumber;
        int maxAttempts = 10; // Limit the number of attempts
        int rounds = 0;
        int totalAttempts = 0;
        int bestScore = Integer.MAX_VALUE;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            rounds++;
            secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("\nRound " + rounds);
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    if (attempts < bestScore) {
                        bestScore = attempts;
                    }
                    break;
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Out of attempts! The correct number was: " + secretNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        double averageAttempts = (double) totalAttempts / rounds;
        System.out.println("\nGame Over! You played " + rounds + " rounds.");
        System.out.println("Your best score was " + bestScore + " attempts.");
        System.out.printf("Your average number of attempts was %.2f per round.%n", averageAttempts);

        scanner.close();
    }
}