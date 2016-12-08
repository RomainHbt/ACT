package pizza;

public class Part {
	
	private Garniture[][] garnitures;
	
	public Part(Garniture[][] g) {
		this.garnitures = g;
	}
	
	public int getNbJambon(){
		int cpt = 0;
		for (Garniture[] gs : garnitures) {
			for (Garniture g : gs) {
				if(g.isHam()) cpt++;
			}
		}
		
		return cpt;
	}
	
	public boolean isRectangle(){
		return (garnitures[0].length != garnitures[garnitures.length-1].length);
	}
	
	public int getSurface(){
		return garnitures.length * garnitures[0].length;
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
