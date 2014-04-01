public class Lake {
	private Fish[] catchableThings;
	private int numThings;

	public Lake(int capacity) {
		catchableThings = new Fish[capacity];
		numThings = 0;
	}

	public int getNumCatchableThings() {
		return numThings;
	}

	public boolean isFull() {
		return numThings == catchableThings.length;
	}

	public String toString() {
		return "Lake with " + numThings + " catchable things";
	}

	// Add the given thing to the lake
	public void add(Fish aCatchableThing) {
		if (numThings < catchableThings.length)
			catchableThings[numThings++] = aCatchableThing;
	}
	
	// Choose a random thing to be caught in the lake and return it 
	public Fish catchSomething() {
		if (numThings == 0) return null;
		
		int index = (int) (Math.random() * numThings);
		Fish f = catchableThings[index];
		catchableThings[index] = catchableThings[numThings-1];
		catchableThings[numThings-1] = null;
		numThings--;
		return f;
	}
	
	// List all things in the lake 
	public void listAllThings() {
		System.out.println(" " + this + " as follows:");
		for (int i=0; i<numThings; i++)
			System.out.println(" " + catchableThings[i]);
		System.out.println();
	}
}