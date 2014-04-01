public class Person {

	float height, money;
	int ticketCount;
	boolean hasPass;

	public Person(float h, float m) {
		height = h;
		money = m;
		ticketCount = 0;
		hasPass = false;
	}

	public void useTickets(int num) {
		ticketCount -= num;
	}

	public String toString() {
		if (hasPass)
			return String.format("%.1f' person with $%.2f and a pass", height,
					money);
		else
			return String.format("%.1f' person with $%.2f and %d tickets",
					height, money, ticketCount);
	}

	public boolean buyPass(TicketBooth booth) {
		if (money >= TicketBooth.PASS_PRICE && booth.availablePasses > 0) {
			booth.sellPass();
			money -= TicketBooth.PASS_PRICE;
			hasPass = true;
			return true;
		}
		return false;
	}

	public int buyTickets(int number, TicketBooth booth) {
		int ticketsNum = number;
		if (booth.availableTickets < number)
			ticketsNum = booth.availableTickets;

		if (money < TicketBooth.TICKET_PRICE * ticketsNum)
			ticketsNum = (int) (money / TicketBooth.TICKET_PRICE);
		
		booth.sellTickets(ticketsNum);
		money -= TicketBooth.TICKET_PRICE * ticketsNum;
		ticketCount += ticketsNum;
		return ticketsNum;
		
	}

	public boolean allowedToRide(Ride aRide) {
		return (height >= aRide.heightRequirement) && (hasPass || ticketCount >= aRide.ticketsRequired);
	}

	public boolean getOn(Ride aRide) {
		if (allowedToRide(aRide)) {
			if (!hasPass)
				ticketCount -= aRide.ticketsRequired;
			aRide.numberOfRiders++;
			return true;
		}
		return false;
	}
}
