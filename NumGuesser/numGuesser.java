import java.util.Scanner;
import java.util.Random;

public class numGuesser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the number guessing game!\n" +
                   "A random positive number will be generated that you have to guess\n" +
                   "I'll let you know if you need to go higher or lower\n" +
                   "Let's begin\n" +
                   "Enter your first number");
        int randomInt = random.nextInt(100);
        int guessedNumber;
        boolean condition = true;
        while (condition) {
            guessedNumber = scanner.nextInt();
            if (guessedNumber < randomInt) {
                System.out.println("Go higher");
            }
            else if (guessedNumber > randomInt) {
                System.out.println("Go lower");
            }
            else {
                System.out.println("You got it, it was " + guessedNumber + "!");
                condition = false;
            }
        }
    }
        
}

