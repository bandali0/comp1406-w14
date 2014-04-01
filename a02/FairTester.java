public class FairTester {
	public static void main(String args[]) {
		Ride coaster, ferris, merryGo, tosser;
		Person billy, donna, fredy, harry, larry;
		TicketBooth booth;

		// Make some rides on which people can ride, specify name, #tickets &
		// height req
		coaster = new Ride("Roller Coaster", 6, 4.25f);
		ferris = new Ride("Ferris Wheel", 5, 3.1f);
		merryGo = new Ride("Merry-Go-Round", 2, 0);
		tosser = new Ride("Tummy Tosser", 7, 4.9f);

		// Make a booth, specifying the number of available passes and tickets
		booth = new TicketBooth(4, 100);

		// Make some people by specifying their height and their money amounts
		billy = new Person(4.9f, 10.00f);
		donna = new Person(3.0f, 5.00f);
		fredy = new Person(6.0f, 0.00f);
		harry = new Person(4.8f, 78.50f);
		larry = new Person(4.0f, 50.00f);

		System.out.println(booth);

		System.out.println("\nBilly is a " + billy);
		System.out.println("Billy just bought " + billy.buyTickets(20, booth)
				+ " tickets.");
		System.out.println("Billy attempting to go on the " + coaster);
		System.out.println("Billy got on: " + billy.getOn(coaster));
		System.out.println("Billy attempting to go on the " + tosser);
		System.out.println("Billy got on: " + billy.getOn(tosser));
		System.out.println("Billy is now a " + billy + "\n");
		
		System.out.println("Donna is a " + donna);
		System.out
				.println("Donna is trying to buy a pass...was she successful: "
						+ donna.buyPass(booth));
		System.out.println("Donna just bought " + donna.buyTickets(6, booth)
				+ " tickets.");
		System.out.println("Donna is attempting to go on the " + ferris);
		System.out.println("Donna got on: " + donna.getOn(ferris));
		System.out.println("Donna is attempting to go on the " + merryGo);
		System.out.println("Donna got on: " + donna.getOn(merryGo));
		System.out.println("Donna is now a " + donna + "\n");
		
		System.out.println("Fredy is a " + fredy);
		System.out.println("Fredy just bought " + fredy.buyTickets(5, booth)
				+ " tickets.");
		System.out.println("Fredy is attempting to go on the " + merryGo);
		System.out.println("Fredy got on: " + fredy.getOn(merryGo));
		System.out.println("Fredy is now a " + fredy + "\n");
		
		System.out.println("Harry is a " + harry);
		System.out.println("Harry just bought " + harry.buyTickets(10, booth)
				+ " tickets.");
		System.out
				.println("Harry is trying to buy a pass...was he successful: "
						+ harry.buyPass(booth));
		System.out.println("Harry is attempting to go on the " + coaster);
		System.out.println("Harry got on: " + harry.getOn(coaster));
		System.out.println("Harry is attempting to go on the " + tosser);
		System.out.println("Harry got on: " + harry.getOn(tosser));
		System.out.println("Harry is attempting to go on the " + coaster);
		System.out.println("Harry got on: " + harry.getOn(coaster));
		System.out.println("Harry is now a " + harry + "\n");
		
		System.out.println("Larry is a " + larry);
		System.out.println("Larry just bought " + larry.buyTickets(15, booth)
				+ " tickets.");
		System.out.println("Larry is attempting to go on the " + tosser);
		System.out.println("Larry got on: " + larry.getOn(tosser));
		System.out.println("Larry is attempting to go on the " + coaster);
		System.out.println("Larry got on: " + larry.getOn(coaster));
		System.out.println("Larry is attempting to go on the " + merryGo);
		System.out.println("Larry got on: " + larry.getOn(merryGo));
		System.out.println("Larry is now a " + larry + "\n");
		
		System.out.println("Ticket Booth made $" + booth.moneyMade);
		System.out.println(booth);
		
		System.out.println(coaster + " and had " + coaster.numberOfRiders
				+ " riders.");
		System.out.println(ferris + " and had " + ferris.numberOfRiders
				+ " riders.");
		System.out.println(merryGo + " and had " + merryGo.numberOfRiders
				+ " riders.");
		System.out.println(tosser + " and had " + tosser.numberOfRiders
				+ " riders.");

	}
}
