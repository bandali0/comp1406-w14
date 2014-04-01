public class ShinyButtons {
	public static byte RED = 0;
	public static byte ORANGE = 1;
	public static byte YELLOW = 2;
	public static byte GREEN = 3;
	public static byte BLUE = 4;
	public static byte LIGHT_GRAY = 5;
	public static byte DARK_GRAY = 6;
	public static byte ROWS = 8;
	private byte[][] buttonTable;
	private int score = 0;
	private boolean[][] selectionTable;
	private int matches;

	public ShinyButtons() {
		buttonTable = new byte[ROWS][ROWS];
		selectionTable = new boolean[ROWS][ROWS];
		resetButtons();
		processTable();
	}

	private void resetButtons() {
		for (int r = 0; r < ROWS; r++)
			for (int c = 0; c < ROWS; c++)
				buttonTable[r][c] = (byte) (Math.random() * 7);
	}

	public byte getButton(int r, int c) {
		return buttonTable[r][c];
	}

	public int getScore() {
		return score;
	}

	public void resetScore() {
		score = 0;
	}

	public void swap(int i1, int j1, int i2, int j2) {
		byte tmp = buttonTable[i1][j1];
		buttonTable[i1][j1] = buttonTable[i2][j2];
		buttonTable[i2][j2] = tmp;
	}

	public void processTable() {
		/*
		 * This is the buggy method. Unfortunately, I didn't succeed in debugging it.
		 * This is the cause of all the weird behavior in this app. Other than this,
		 * other things work fine.
		 */
		for (int i = 0; i < ROWS; i++)
			for (int j = 0; j < ROWS; j++)
				selectionTable[i][j] = false;

		for (int i = 0; i < ROWS; i++) {
			matches = 0;
			for (int j = 1; j < ROWS; j++) {
				if (buttonTable[i][j] == buttonTable[i][j - 1]) {
					matches++;
					if (matches > 2) {
						selectionTable[i][j - 2] = selectionTable[i][j - 1] = selectionTable[i][j] = true;
						int addition = 0;
						for (int n=3; n<=matches-1; n++)
							addition += i*30;
						score += 30 + addition;
					}
				} else
					matches = 0;
			}
		}

		for (int i = 1; i < ROWS; i++) {
			matches = 0;
			for (int j = 0; j < ROWS; j++) {
				if (buttonTable[i][j] == buttonTable[i - 1][j]) {
					matches++;
					if (matches > 2) {
						selectionTable[i - 2][j] = selectionTable[i - 1][j] = selectionTable[i][j] = true;
					}
				} else
					matches = 0;
			}
		}
		// printselection();
	}

	private void printselection() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < ROWS; j++)
				System.out.print(String.valueOf(selectionTable[j][i]) + ", ");
			System.out.println();
		}
	}

	public boolean getSelected(int row, int col) {
		return selectionTable[col][row];
	}

	public void cleanTable() {
		boolean newPieceAdded = false;
		int r = 7;
		while (r >= 0) {
			newPieceAdded = false;
			for (int c = 0; c <= 7; c++) {
				if (getSelected(r, c)) {
					// move the pieces down now ...
					for (int r2 = r; r2 >= 1; r2--) {
						selectionTable[r2][c] = selectionTable[r2 - 1][c];
						buttonTable[r2][c] = buttonTable[r2 - 1][c];
					}
					// Add a new piece
					buttonTable[0][c] = (byte) (Math.random() * 7);
					selectionTable[0][c] = false;
					newPieceAdded = true;
				}
			}
			if (!newPieceAdded)
				r--;
		}
	}
}
