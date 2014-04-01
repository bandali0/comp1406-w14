import java.util.Scanner;

public class SmartPuzzleProgram {

	public static Scanner keyboard;

	public static void main(String[] args) {

		// initialize the scanner
		keyboard = new Scanner(System.in);

		// create the array that will hold the characters of the table
		char[][] table = new char[5][5];

		// initialize the array elements to "space" character
		for (int i = 0; i < table.length; i++)
			for (int j = 0; j < table[i].length; j++)
				table[i][j] = ' ';

		while (!gameOver(table)) {
			printTable(table);

			System.out.print("Enter a row (1-" + table.length + "): ");
			int row = keyboard.nextInt();

			if (row < 1 || row > table.length)
				System.out.println("Invalid row.");
			else {
				// user entered a valid row. we proceed.

				System.out
						.print("Enter a column (1-" + table[0].length + "): ");
				int column = keyboard.nextInt();

				if (column < 1 || column > table[0].length)
					System.out.println("Invalid column.");
				else {
					// user entered a valid column. we proceed.

					System.out.print("Enter a letter (S, M, A, R or T): ");
					char choice = keyboard.next().charAt(0);

					if (choice != 'S' && choice != 'M' && choice != 'A'
							&& choice != 'R' && choice != 'T')
						System.out
								.println("Invalid letter. Use 'S', M', 'A', 'R' or 'T'.");
					else {
						// user entered a valid letter. let's see if it only
						// exists once in the row and column.

						if (isLetterUnique(table, row - 1, column - 1, choice))
							// everything is valid. we finally get to apply the
							// user's choice
							table[row - 1][column - 1] = choice;
						else
							System.out.println("Either the position is already filled or the letter is not unique in the row/column.");

					}

				}
			}

			System.out.println();
		}
		
		printTable(table);
		System.out.println("Congratulations! You must be SMART.");

	}

	public static boolean gameOver(char[][] table) {
		int row_sum, column_sum;

		// sum each row
		for (int r = 0; r < table.length; r++) {
			row_sum = 0;
			for (int c = 0; c < table[r].length; c++)
				row_sum += (int) table[r][c];
			if (row_sum != 391)
				return false;
		}

		// sum each column
		for (int c = 0; c < table.length; c++) {
			column_sum = 0;
			for (int r = 0; r < table[c].length; r++)
				column_sum += (int) table[r][c];
			if (column_sum != 391)
				return false;
		}

		return true;
	}

	public static void printTable(char[][] table) {
		// print first line (column indices)
		System.out.print(" ");
		for (int c = 0; c < table[0].length; c++)
			System.out.print("   " + (c + 1));

		// print second line (top border)
		System.out.println();
		System.out.print("   ---");
		for (int c = 1; c < table[0].length; c++)
			System.out.print("+---");

		// print next rows
		for (int r = 0; r < table.length; r++) {
			System.out.println();
			System.out.print((r + 1) + " ");
			for (int c = 0; c < table[r].length; c++)
				System.out.print("| " + table[r][c] + " ");
			System.out.print("|");

			// print border
			System.out.println();
			System.out.print("   ---");
			for (int c = 1; c < table[0].length; c++)
				System.out.print("+---");

			System.out.println();

		}

	}

	public static boolean isLetterUnique(char[][] table, int r, int c, char l) {
		// returns true if 'l' exists only once in the given row and the given
		// column

		for (int i = 0; i < table.length; i++)
			if (table[i][c] == l)
				return false;

		for (int j = 0; j < table[0].length; j++)
			if (table[r][j] == l)
				return false;

		if (table[r][c] != ' ')
			return false;

		return true;

	}

}
