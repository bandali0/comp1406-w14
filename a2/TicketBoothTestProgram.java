public class TicketBoothTestProgram {
	public static void main(String args[]) {
		TicketBooth booth1, booth2;
		
		booth1 = new TicketBooth(5, 50);
		booth2 = new TicketBooth(1, 10);

		System.out.println("Here are the booths at the start:");
		System.out.println("" + booth1);
		System.out.println("" + booth2);

		// Simulate selling 2 passes, 5 tickets, 12 tickets and 3 tickets from
		// booth1
		booth1.sellPass();
		booth1.sellPass();
		booth1.sellTickets(5);
		booth1.sellTickets(12);
		booth1.sellTickets(3);

		// Simulate selling 2 passes, 5 tickets, 12 tickets and 3 tickets from
		// booth2
		booth2.sellPass();
		booth2.sellPass();
		booth2.sellTickets(5);
		booth2.sellTickets(12);
		booth2.sellTickets(3);

		// Make sure that it all worked
		System.out.println("\nBooth 1 has made $" + booth1.moneyMade);
		System.out.println("Booth 2 has made $" + booth2.moneyMade);
		System.out.println("\nHere are the booths at the end:");
		System.out.println("" + booth1);
		System.out.println("" + booth2);
	}
}