public class Fisher {

	private String name;
	private Fish[] fishCaught;
	private int numFishCaught;
	private int keepSize;

	public static int LIMIT = 10;

	public String getName() {
		return name;
	}

	public Fish[] getFishCaught() {
		return fishCaught;
	}

	public int getNumFishCaught() {
		return numFishCaught;
	}

	public int getKeepSize() {
		return keepSize;
	}

	public Fisher(String name, int keepSize) {
		this.name = name;
		this.keepSize = keepSize;
		fishCaught = new Fish[Fisher.LIMIT];
	}

	public String toString() {
		return String.format("%s with %d fish", name, numFishCaught);
	}

	public void keep(Fish f) {
		if (numFishCaught < Fisher.LIMIT)
			fishCaught[numFishCaught++] = f;
	}

	public boolean likes(Fish f) {
		return f.getSize() >= keepSize && !f.getSpecies().equals("Sunfish");
	}

	public void listFish() {
		System.out.println(String.format("%s with %d fish as follows:", name,
				numFishCaught));
		for (Fish f : fishCaught)
			if (f != null)
				System.out.println(f.toString());
	}

	public void goFishingIn(Pond p) {
		Fish f = p.catchAFish();
		if (f != null) {
			if (likes(f))
				if (numFishCaught < Fisher.LIMIT)
					keep(f);
			if (!likes(f) || numFishCaught >= Fisher.LIMIT)
				p.add(f);
		}
	}

	public void giveAwayFish(Fisher fisher, Pond p) {
		for (int i = 0; i < fishCaught.length; i++) {
			if (fishCaught[i] != null) {
				if (fisher.likes(fishCaught[i]))
					fisher.keep(fishCaught[i]);
				else
					p.add(fishCaught[i]);
				fishCaught[i] = null;
				numFishCaught--;
			}
		}
	}

}
