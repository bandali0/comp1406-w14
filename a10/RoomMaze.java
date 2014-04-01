public class RoomMaze {
	public static byte	ROWS = 8;

	private byte[][]	wallTable;
	
	private final int NOT_VISITED_BEFORE = 1;
	private final byte FIRST_ROOM = 2;


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
		return iRHelper(0, 0, FIRST_ROOM)-1;
	}

	
	private int iRHelper(int r, int c, byte index) {
		
		if (c == ROWS) {
			r++;  // go to the next row
			c = 0;  // at the first column
        }
		
//		  The base case for recursion
		if (r == ROWS)
			return index;
        
//        Main recursion stuff from here
		if (getWall(r, c) == NOT_VISITED_BEFORE)
            traceRoomFrom(r, c, index++);

        return iRHelper(r, ++c, index);  // recurse (to the next column)
    }
	
   
    public void traceRoomFrom(int r, int c, byte colorIndex) {
        
    	if (getWall(r, c) == NOT_VISITED_BEFORE) {
        	
//            Set the color index of the current square
    		wallTable[r][c] = colorIndex;
            
//            Look at the square above it
            if (r > 0)
            	traceRoomFrom(--r, c, colorIndex);
            
//            Look at the square to the right
            if (c < ROWS-1)
            	traceRoomFrom(++r, ++c, colorIndex);
            
//            Look at the square below it
            if (r < ROWS-1)
            	traceRoomFrom(++r, --c, colorIndex);
            
//            Look at the square to the left
            if (c > 0)
            	traceRoomFrom(--r, --c, colorIndex);
            
        
    	}
    	
    }
}