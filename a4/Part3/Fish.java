public abstract class Fish implements Catchable {
	// Any fish below this size must be thrown back into the lake 
	public static int THROW_BACK_SIZE = 18;
	
	protected int size;
	protected float weight;
	
	public Fish(int aSize, float aWeight) {
		size = aSize;
		weight = aWeight;
	}
	
	public boolean isDesirableTo(Fisher f) {
		return canKeep() && f.getNumThingsCaught() < Fisher.LIMIT && (weight+f.getWeightSoFar() <= f.getWeightLimit());
	}
	
	public abstract boolean canKeep();
	
	public int getSize() {
		return size;
	}
	public float getWeight() {
		return weight;
	}
	
	public String toString() {
		return ("A " + size + "cm " + weight + "kg " + getClass().toString().substring(6));
	}
}