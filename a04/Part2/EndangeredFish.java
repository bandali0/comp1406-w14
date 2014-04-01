public abstract class EndangeredFish extends Fish {

	public EndangeredFish(int aSize, float aWeight) {
		super(aSize, aWeight);
	}

	@Override
	public boolean canKeep() {
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + " (ENDANGERED)";
	}
	
}