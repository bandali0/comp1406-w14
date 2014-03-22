public class RoomMaze {
	public static byte	ROWS = 8;

	private byte[][]	wallTable;


	public RoomMaze() {
		wallTable = new byte[ROWS][ROWS];
		resetWalls();
	}

	public void resetWalls() {
		for (int r=0; r<ROWS; r++)
			for (int c=0; c<ROWS; c++) {
				wallTable [r][c] = (byte)(Math.random()*2);
			}

	}

	public byte getWall(int r, int c) { return wallTable[r][c]; }

	public int identifyRooms() {
		// Go through each location in the maze. If there is not a
		// wall there, then start tracing out the room recursively.
		// Keep count of how many rooms are traced out and assign
		// a colorIndex (i.e., store it in the wallTable) to each
		// room being traced.   Wall locations MUST have a value
		// of zero in the wallTable.  You may add attributes to this
		// class if you need to.
		return 1; // Replace this line
	}


	public void traceRoomFrom(int r, int c, byte colorIndex) {
		// Code missing.  This method MUST be directly recursive
	}
}