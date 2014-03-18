public class PondTestProgram {
	public static void main(String args[]) {
		// Create a pond with 10 fish
		Pond pond = new Pond(15);
		pond.add(new Fish(4, "Sunfish"));
		pond.add(new Fish(25, "Pike"));
		pond.add(new Fish(20, "Bass"));
		pond.add(new Fish(30, "Perch"));
		pond.add(new Fish(4, "Sunfish"));
		pond.add(new Fish(15, "Pike"));
		pond.add(new Fish(9, "Pike"));
		pond.add(new Fish(12, "Bass"));
		pond.add(new Fish(5, "Sunfish"));
		pond.add(new Fish(12, "Sunfish"));
		pond.listFish();
		
		// Now catch 7 random fish
		System.out.println("Catching 7 random fish as follows ...");
		for (int i = 0; i < 7; i++)
			System.out.println(pond.catchAFish());
		System.out.println();
		
		// Now show what is left in the pond
		pond.listFish();
		// Now try to catch 5 random fish ... but only 3 actually left
		System.out.println("Catching 5 random fish as follows ...");
		for (int i = 0; i < 5; i++)
			System.out.println(pond.catchAFish());
		System.out.println();
		// Now show what is left in the pond
		pond.listFish();
	}
}
