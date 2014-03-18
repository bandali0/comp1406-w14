
public class Fish {

	private String species;
	private int size;
	
	public Fish(int size, String species) {
		this.size = size;
		this.species = species;
	}
	
	public String toString() {
		return String.format("A %dcm %s", size,  species);
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
