public class CallSimulationTestProgram {
	public static void main(String args[]) {

		PhoneNetwork	phoneNetwork = new PhoneNetwork();

		// Register some customers
		phoneNetwork.register("Rob Banks", "613-111-1111", 200);
		phoneNetwork.register("April Rain", "819-222-2222", 200);
		phoneNetwork.register("Rita Book", "613-333-3333", 100);
		phoneNetwork.register("Sue Permann", "613-444-4444", 100);
		phoneNetwork.register("Tim Bur", "819-555-5555", 100);
		phoneNetwork.register("Paddy O'Lantern", "613-666-6666", 100);
		phoneNetwork.register("Sam Pull", "613-777-7777", 200);
		phoneNetwork.register("Sandy Beach", "613-888-8888", 300);
		phoneNetwork.register("Adam Bomm", "819-999-9999", 300);
		phoneNetwork.register("Hugo First", "613-555-1234", 300);
		phoneNetwork.register("Lee Nover", "613-555-5678", 200);
		phoneNetwork.register("Mabel Syrup", "613-666-1234", 200);
		phoneNetwork.register("Mike Rohsopht", "613-666-5678", 300);
		phoneNetwork.register("Adam Sapple", "613-777-1234", 100);
		phoneNetwork.register("Moe Skeeto", "613-777-5678", 100);
		phoneNetwork.register("Anita Bath", "819-888-1234", 100);
		phoneNetwork.register("Rusty Chain", "613-888-5678", 100);
		phoneNetwork.register("Stu Pitt", "613-999-1234", 200);
		phoneNetwork.register("Val Crow", "613-999-5678", 300);
		phoneNetwork.register("Neil Down", "613-444-1234", 300);

		// Simulate 100 calls randomly
		for (int i=0; i<100; i++) {
			int ind = (int)(Math.random()*phoneNetwork.getCustomers().size());
			Customer fromPerson = phoneNetwork.getCustomers().get(ind);
			ind = (int)(Math.random()*phoneNetwork.getCustomers().size());
			Customer toPerson = phoneNetwork.getCustomers().get(ind);

			int callLength = (int)(Math.random()*1000 + 5);
			if (fromPerson != toPerson)
				phoneNetwork.makeCall(fromPerson.getNumber(), toPerson.getNumber(), callLength);
		}

		// Add a 5 minute call from Rusty Chain to April Rain
		phoneNetwork.makeCall("613-888-5678", "819-222-2222", 300);

		// Display the stats
		phoneNetwork.displayStats();

		// Compute some interesting details
		System.out.println("\nCustomer who made the most calls: " + phoneNetwork.customerMakingMostCalls());
		System.out.println("Customer who received the most calls: " + phoneNetwork.customerReceivingMostCalls());
		System.out.println("Did Rusty Chain call April Rain: " + phoneNetwork.wasCallMade("613-888-5678", "819-222-2222"));
		System.out.println("Did Rusty Chain call himself: " + phoneNetwork.wasCallMade("613-888-5678", "613-888-5678"));
		System.out.println("Did Stu Pitt call Mabel Syrup: " + phoneNetwork.wasCallMade("613-999-1234", "613-666-1234"));
	}
}