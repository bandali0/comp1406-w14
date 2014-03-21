public class PhonePlan {
	private int 	minutesAllowed;
	private int 	minutesUsed;

	// 2- parameter constructor
	public PhonePlan(int mins) {
		minutesAllowed = mins;
		minutesUsed = 0;
	}

	// Get methods
	public int getMinutesAllowed() { return minutesAllowed; }
	public int getMinutesUsed() { return minutesUsed; }


	// Set methods
	public void setMinutesAllowed(int x) { minutesAllowed = x; }
	public void setMinutesUsed(int x) { minutesUsed = x; }

	// Returns the number of minutes remaining for this plan
	public int getMinutesRemaining() {
		return minutesAllowed - minutesUsed;
	}

	// Returns a string representation of this plan
	public String toString() {
		return ("(" + minutesAllowed + " minute) monthly plan with " +
					getMinutesRemaining() + " minutes remaining");
	}
}