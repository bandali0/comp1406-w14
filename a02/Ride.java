import java.text.DecimalFormat;

public class Ride {

	String name;
	int ticketsRequired;
	float heightRequirement;
	int numberOfRiders;

	public Ride(String n, int tR, float hR) {
		name = n;
		ticketsRequired = tR;
		heightRequirement = hR;
	}

	public Ride() {
		name = "UNKNOWN";
		ticketsRequired = -1;
		heightRequirement = -1;
		numberOfRiders = 0;
	}
	
	public String toString(){
		String heightReq = new DecimalFormat("###.##").format(heightRequirement);
		return String.format("%s requiring %d tickets with a height restriction of %s'", name, ticketsRequired, heightReq);
	}

}
