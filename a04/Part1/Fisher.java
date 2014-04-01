public class Fisher {
	public static int LIMIT = 10; // Max # of fish that can be caught
	
	private String name;
	private Fish[] thingsCaught;
	private int numThingsCaught;
	private float weightLimit;
	
	public Fisher(String aName, int wl) {
		name = aName;
		thingsCaught = new Fish[LIMIT];
		numThingsCaught = 0;
		weightLimit = wl;
	}
	
	public String getName() {
		return name;
	}
	public int getNumThingsCaught() {
		return numThingsCaught;
	}
	public float getWeightLimit() {
		return weightLimit;
	}
	
	public String toString() {
		return name + " with " + numThingsCaught + " things caught";
	}
	
	// List all the things caught and kept by this fisher
	public void listThingsCaught() {
		System.out.println(" " + this + " as follows:");
		if (numThingsCaught > 0)
			for (int i=0; i<numThingsCaught; i++)
				System.out.println(" " + thingsCaught[i]);
		System.out.println(" -------------------------");
		System.out.println(" Total fish weight: " + getWeightSoFar() + "kg");
		System.out.println();
	}
	
	// Cause this fisher to keep the thing caught. 
	public void keep(Fish aThing) {
		thingsCaught[numThingsCaught++] = aThing;
	}
	
	// Simulate the fisher catching something in the lake and keeping what is caught if
	// it is desirable, otherwise throwing it back into the lake again. 
	public void goFishingIn(Lake aLake) {
		Fish aThing = aLake.catchSomething();
		if (aThing != null)
			if (aThing.isDesirableTo(this))
				this.keep(aThing);
			else
				aLake.add(aThing);
	}
	
	// Cause this fisher to give all fish to the given fisher, unless the given
	// fisher exceeds the wight or catch limit, then throw the fish back into the lake.
	public void giveAwayFish(Fisher f, Lake aLake) {
		for (int i=0; i<numThingsCaught; i++)
			if (thingsCaught[i].isDesirableTo(f))
				f.keep(thingsCaught[i]);
			else
				aLake.add(thingsCaught[i]);
		numThingsCaught = 0;
	}
	
	// Return the weight of all caught fish so far
	public float getWeightSoFar() {
		float total = 0;
		for (int i=0; i<numThingsCaught; i++)
			total += thingsCaught[i].getWeight();
		return total;
	}
	
}