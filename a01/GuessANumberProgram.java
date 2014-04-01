import java.util.Random;
import java.util.Scanner;


public class GuessANumberProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int random = new Random().nextInt(100) + 1;
		
		System.out.println("I am thinking of a number from 1 to 100... guess what it is?");
		
		int count = 1;
		int guess = new Scanner(System.in).nextInt();
		while (guess != random) {
			if (guess < random)
				System.out.println("higher!");
			else
				System.out.println("lower!");
			guess = new Scanner(System.in).nextInt();
			count++;
		}
		
		System.out.println("Congratulations! You guessed the number with " + count + " tries!");

	}

}
