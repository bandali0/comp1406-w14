public class Treasure extends SunkenObject implements Catchable {

	public Treasure() {
		super(20f);

	}
	
	public boolean isDesirableTo (Fisher f) {
		return f.getNumThingsCaught() < Fisher.LIMIT;
	}
	
}