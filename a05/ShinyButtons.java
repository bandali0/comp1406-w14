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

	public ShinyButtons() {
		buttonTable = new byte[ROWS][ROWS];
		resetButtons();
	}

	private void resetButtons() {
		for (int r = 0; r < ROWS; r++)
			for (int c = 0; c < ROWS; c++)
				buttonTable[r][c] = (byte) (Math.random() * 7);
	}

	public byte getButton(int r, int c) {
		return buttonTable[r][c];
	}
}