public class TicketBooth {

	float moneyMade;
	int availablePasses, availableTickets;

	static float TICKET_PRICE = 0.50f, PASS_PRICE = 16.50f;

	public TicketBooth() {
		moneyMade = 0.0f;
		availablePasses = -1;
		availableTickets = -1;
	}

	public TicketBooth(int aP) {
		moneyMade = 0.0f;
		availablePasses = aP;
		availableTickets = -1;
	}

	public TicketBooth(int aP, int aT) {
		moneyMade = 0.0f;
		availablePasses = aP;
		availableTickets = aT;
	}

	public String toString() {
		return String.format("Ticket booth with %d passes and %d tickets",
				availablePasses, availableTickets);
	}

	public void sellPass() {
		if (availablePasses > 0) {
			availablePasses--;
			moneyMade += PASS_PRICE;
		}
	}

	public void sellTickets(int num) {
		if (availableTickets >= num) {
			availableTickets -= num;
			moneyMade += num * TICKET_PRICE;
		}
	}

}
