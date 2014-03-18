public class FisherTestProgram1 {
	public static void main(String[] args) {
		// Create two people to fish in the pond
		Fisher fred = new Fisher("Fred", 15);
		Fisher suzy = new Fisher("Suzy", 10);
		Fish f1 = new Fish(4, "Sunfish");
		Fish f2 = new Fish(25, "Sunfish");
		Fish f3 = new Fish(10, "Pike");
		Fish f4 = new Fish(15, "Pike");
		Fish f5 = new Fish(20, "Pike");

		System.out.println(fred.likes(f1));		// false
		System.out.println(fred.likes(f2));		// false
		System.out.println(fred.likes(f3));		// false
		System.out.println(fred.likes(f4));		// true
		System.out.println(fred.likes(f5));		// true

		System.out.println(suzy.likes(f1));		// false
		System.out.println(suzy.likes(f2));		// false
		System.out.println(suzy.likes(f3));		// true
		System.out.println(suzy.likes(f4));		// true
		System.out.println(suzy.likes(f5));		// true
		System.out.println();

		// FORCE the fishers to keep some fish (for testing purposes only)
		fred.keep(f1);
		fred.keep(f2);
		fred.keep(f3);
		fred.keep(f4);
		fred.keep(f5);
		suzy.keep(f2);
		suzy.keep(f3);
		
		System.out.println();
		
		// Now display the fish that were kept
		fred.listFish(); 	// should show 3 fish
		suzy.listFish(); 	// should show 2 fish
	}
}