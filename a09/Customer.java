public class Customer {
	private String 		name;
	private String		number;
	private PhonePlan	plan;

	// 3-parameter constructor
	public Customer(String n, String num, PhonePlan p) {
		name = n;
		number = num;
		plan = p;
	}

	// Get methods
	public String 		getName() { return name; }
	public String 		getNumber() { return number; }
	public PhonePlan	getPlan() { return plan; }

	// Set methods
	public void	setPlan(PhonePlan p) { plan = p; }

	// Returns a string representation of this customer
	public String toString() {
		return name + " [" + number + "] on a " + plan.toString();
	}
}