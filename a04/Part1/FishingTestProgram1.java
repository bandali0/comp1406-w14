public class FishingTestProgram1 {
	public static void main(String[] args) {
		// Create a big pond with 15 fish
		Lake weirdLake = new Lake(15);
		weirdLake.add(new Fish(76, 6.1f));
		weirdLake.add(new Fish(32, 0.4f));
		weirdLake.add(new Fish(20, 0.9f));
		weirdLake.add(new Fish(30, 0.4f));
		weirdLake.add(new Fish(140, 7.4f));
		weirdLake.add(new Fish(15, 0.3f));
		weirdLake.add(new Fish(90, 5.9f));
		weirdLake.add(new Fish(120, 6.8f));
		weirdLake.add(new Fish(80, 4.8f));
		weirdLake.add(new Fish(42, 3.2f));
		weirdLake.add(new Fish(100, 5.6f));
		weirdLake.add(new Fish(45, 2.0f));
		weirdLake.add(new Fish(16, 0.2f));
		weirdLake.add(new Fish(30, 1.2f));
		weirdLake.add(new Fish(7, 0.1f));
		
		System.out.println("Here is what is in the lake to begin with ...");
		weirdLake.listAllThings();
		
		// Create two people to fish in the lake
		Fisher fred = new Fisher("Fred", 25);
		Fisher suzy = new Fisher("Suzy", 15);
		
		System.out
				.println("Fred casts his fishing line into the lake 10 times ...");
		for (int i = 0; i < 10; i++)
			fred.goFishingIn(weirdLake);
		fred.listThingsCaught();
		
		System.out
				.println("Suzy casts her fishing line into the lake 10 times ...");
		for (int i = 0; i < 10; i++)
			suzy.goFishingIn(weirdLake);
		suzy.listThingsCaught();
		
		System.out.println("Here is what remains in the lake ...");
		weirdLake.listAllThings();
		
		// Now simulate Suzy giving her fish to Fred
		System.out
				.print("Suzy now gives all her fish to Fred (if he can keep ");
		System.out.println("them), otherwise she returns them to the lake ...");
		suzy.giveAwayFish(fred, weirdLake);
		suzy.listThingsCaught();
		fred.listThingsCaught();
		
		System.out.println("Here is the lake when Fred and Suzy go home ...");
		weirdLake.listAllThings();
	}
}