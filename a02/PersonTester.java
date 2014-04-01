public class PersonTester {
	public static void main(String args[]) {
		Person mary;
		
		mary = new Person(4.9f, 20.00f);
		
		System.out.println(mary.height);
		System.out.println(mary.money);
		System.out.println(mary.ticketCount);
		System.out.println(mary.hasPass);
		System.out.println(mary);	// Notice the money is properly formatted
		
		mary.ticketCount = 3;
		System.out.println(mary);
		
		mary.useTickets(2);		// You have to write this method
		System.out.println(mary);
		
		mary.hasPass = true;
		System.out.println(mary);
	}
}