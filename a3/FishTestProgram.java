public class FishTestProgram {
	public static void main(String args[]) {
		Fish f = new Fish(4, "Sunfish");
		System.out.println(f);
		// should display A 4cm Sunfish
		System.out.println(f.getSize());
		// should display 4
		System.out.println(f.getSpecies()); // should display Sunfish
	}
}