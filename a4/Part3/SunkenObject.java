public abstract class SunkenObject implements Catchable {
	float weight;
	
	public SunkenObject(float w) {
		weight = w;
	}
	
	public float getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "A " + weight + "kg " + getClass().toString().substring(6);
	}
	
	public boolean isDesirableTo (Fisher f) {
		return false;
	}	
}