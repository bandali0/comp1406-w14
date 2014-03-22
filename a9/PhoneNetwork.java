import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PhoneNetwork {
	private ArrayList<Customer> customers;
	private HashMap<String, ArrayList<Call>> outgoingCalls;
	private HashMap<String, ArrayList<Call>> incomingCalls;
	
	public PhoneNetwork() {
		customers = new ArrayList<Customer>();
		outgoingCalls = new HashMap<String, ArrayList<Call>>();
		incomingCalls = new HashMap<String, ArrayList<Call>>();
	}
	
	public HashMap<String, ArrayList<Call>> getOutgoingCalls() { return outgoingCalls; }
	public HashMap<String, ArrayList<Call>> getIncomingCalls() { return incomingCalls; }
	
	public void register(String name, String number, int minutes) {
		customers.add(new Customer(name, number, new PhonePlan(minutes)));
		outgoingCalls.put(number, new ArrayList<Call>());
		incomingCalls.put(number, new ArrayList<Call>());
	}
	
	public void makeCall(String fromPhoneNumber, String toPhoneNumber, int seconds) {
		Customer f = null, t = null;
		
		for (Customer c: customers) {
			if (c.getNumber().equals(fromPhoneNumber))
				f = c;
			if (c.getNumber().equals(toPhoneNumber))
				t = c;
		}
		
		if (f != null && t != null) {
			Call call = new Call(f, t, new Date(), seconds);
			outgoingCalls.get(fromPhoneNumber).add(call);
			incomingCalls.get(toPhoneNumber).add(call);
			
			f.getPlan().setMinutesUsed(f.getPlan().getMinutesUsed()+((int) Math.ceil(seconds/60.0)));
			t.getPlan().setMinutesUsed(t.getPlan().getMinutesUsed()+((int) Math.ceil(seconds/60.0)));
		}
	}
}
