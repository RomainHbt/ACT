package pizza;

public class Tomate extends Garniture {

	public Tomate(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean isHam() {
		return false;
	}

	@Override
	public String toString() {
		return "T";
	}

}
