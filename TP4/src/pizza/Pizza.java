package pizza;


public class Pizza {
	
	private Garniture[][] garnitures;
	private Part[] parts;
	
	public Pizza(Garniture[][] g) {
		this.garnitures = g;
	}

	public Garniture[][] getGarnitures() {
		return garnitures;
	}

	public void setGarnitures(Garniture[][] garnitures) {
		this.garnitures = garnitures;
	}

	public Part[] getParts() {
		return parts;
	}

	public void setParts(Part[] parts) {
		this.parts = parts;
	}

	@Override
	public String toString() {
		String res = "";
		for (Garniture[] gs : garnitures) {
			for (Garniture g : gs) {
				System.out.print(" "+g.toString()+" ");
			}
			System.out.println();
		}
		return res;
	}

}
