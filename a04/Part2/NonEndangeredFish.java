public abstract class NonEndangeredFish extends Fish {

	public NonEndangeredFish(int aSize, float aWeight) {
		super(aSize, aWeight);
	}

	@Override
	public boolean canKeep() {
		return size > Fish.THROW_BACK_SIZE;
	}
	
}