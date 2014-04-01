public class FishingTestProgram2 {
	public static void main(String[] args) {
		// Create a big pond with 15 fish
		Pond bigPond = new Pond(15);
		bigPond.add(new Fish(4, "Sunfish"));
		bigPond.add(new Fish(25, "Pike"));
		bigPond.add(new Fish(20, "Bass"));
		bigPond.add(new Fish(30, "Perch"));
		bigPond.add(new Fish(14, "Sunfish"));
		bigPond.add(new Fish(15, "Pike"));
		bigPond.add(new Fish(9, "Pike"));
		bigPond.add(new Fish(12, "Bass"));
		bigPond.add(new Fish(5, "Sunfish"));
		bigPond.add(new Fish(12, "Sunfish"));
		bigPond.add(new Fish(10, "Bass"));
		bigPond.add(new Fish(2, "Bass"));
		bigPond.add(new Fish(16, "Perch"));
		bigPond.add(new Fish(30, "Sunfish"));
		bigPond.add(new Fish(7, "Perch"));
		bigPond.listFish();
		
		// Create two people to fish in the pond
		Fisher fred = new Fisher("Fred", 15);
		Fisher suzy = new Fisher("Suzy", 10);
		
		System.out.println("First Fred catches 20 fish in the big pond ...");
		for (int i = 0; i < 20; i++)
			fred.goFishingIn(bigPond);
		fred.listFish();
		
		System.out.println("Suzy now catches 20 fish in the big pond ...");
		for (int i = 0; i < 20; i++)
			suzy.goFishingIn(bigPond);
		suzy.listFish();
		
		System.out.println("Here is what is left of the pond ...");
		bigPond.listFish();
		
		// Now simulate Suzy giving her fish to Fred
		suzy.giveAwayFish(fred, bigPond);
		fred.listFish();
		suzy.listFish();
		bigPond.listFish();
	}
}