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
	
	
	public ArrayList<Customer> getCustomers() { return customers; }
	
	
	public void displayStats() {
		
		String dataFormat = "| %-12s | %-20s | %3d | %2d |  %4d  |  %4d  |  %4d  |  %4.2f  |  %6.2f  |  %3.2f  |  %6.2f  |%n";

		System.out.format("+--------------+----------------------+-----+----+--------+--------+--------+---------+----------+--------+----------+%n");
		System.out.printf("| PHONE NUMBER | NAME                 | OUT | IN |  PLAN  |  USED  |  OVER  |   BASE  |   EXTRA  |   HST  |   TOTAL  |%n");
		System.out.format("+--------------+----------------------+-----+----+--------+--------+--------+---------+----------+--------+----------+%n");
		
		for (Customer c: customers) {
			int over = c.getPlan().getMinutesUsed()-c.getPlan().getMinutesAllowed()>0? c.getPlan().getMinutesUsed()-c.getPlan().getMinutesAllowed():0;
			float base = (float) (20 + Math.ceil((c.getPlan().getMinutesAllowed()-100)/100.0)*5);
			float extra = over * .15f;
			float hst = (base + extra) * .13f;
			float total = base + extra + hst;
			
		    System.out.format(dataFormat, c.getNumber(), c.getName(), (outgoingCalls.get(c.getNumber()).size()), (incomingCalls.get(c.getNumber()).size()), c.getPlan().getMinutesAllowed(),
		    		c.getPlan().getMinutesUsed(), over, base, extra, hst, total);
		}
		
		System.out.format("+--------------+----------------------+-----+----+--------+--------+--------+---------+----------+--------+----------+%n");
		
	}
	
	
	public Customer customerMakingMostCalls() {
		int max = 0, maxIndex = 0;
		for (int i=0; i<customers.size(); i++)
			if ((outgoingCalls.get(customers.get(i).getNumber())).size() > max) {
				max = (outgoingCalls.get(customers.get(i).getNumber())).size(); 
				maxIndex = i;
			}
		return customers.get(maxIndex);
	}
	
	
	public Customer customerReceivingMostCalls() {
		int max = 0, maxIndex = 0;
		for (int i=0; i<customers.size(); i++)
			if ((incomingCalls.get(customers.get(i).getNumber())).size() > max) {
				max = (incomingCalls.get(customers.get(i).getNumber())).size(); 
				maxIndex = i;
			}
		return customers.get(maxIndex);
	}
	
	
	public boolean wasCallMade(String n1, String n2) {
		if (outgoingCalls.containsKey(n1))
			for (Call c: outgoingCalls.get(n1))
				if (c.getMadeTo().getNumber().equals(n2))
					return true;
		return false;
	}
}
