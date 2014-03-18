public class Pond {

	private Fish[] fish;
	private int numFish;

	public Pond(int capacity) {
		fish = new Fish[capacity];
		numFish = 0;
	}

	public int getNumFish() {
		return numFish;
	}

	public boolean isFull() {
		return numFish >= fish.length;
	}
	
	public String toString() {
		return String.format("Pond with %d fish", numFish);
	}
	
	public void add(Fish f) {
		if (!isFull())
			fish[numFish++] = f;
	}
	
	public void listFish() {
		System.out.println(String.format("Pond with %d fish as follows:", numFish));
		for (Fish f : fish)
			if(f != null)
				System.out.println(f.toString());
	}
	
	public Fish catchAFish() {
		if (numFish > 0) {
			int randIndex =  (int)(Math.random() * fish.length);
			while (fish[randIndex] == null)
				randIndex =  (int)(Math.random() * fish.length);
			Fish randomFish = fish[randIndex];
			fish[randIndex] = fish[numFish-1];
			fish[--numFish] = null;
			return randomFish;
		}
		return null;
	}

}
